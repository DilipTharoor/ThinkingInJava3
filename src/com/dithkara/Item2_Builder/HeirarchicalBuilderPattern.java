package com.dithkara.Item2_Builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * This should be used instead of Telescoping constructors(one constructor calling another with added constructor....)
 * or Java bean pattern (multiple setters and a constructor).
 *
 * Java bean pattern has an inconsistent state while it is being built and also difficult to make it immutable
 */
public class HeirarchicalBuilderPattern {

    public static void main(String [] args) {

        Car car = new Car.Builder(Car.Level.COMFORT).addon(VehicleAbstract.Addon.INSURANCE).build();
        Cycle cycle = new Cycle.Builder().addon(VehicleAbstract.Addon.LUGGAGE_HOLDER).build();
    }
}

abstract class VehicleAbstract {

    public enum Addon {

        INSURANCE,
        LUGGAGE_HOLDER

    }

    final Set<Addon> addons;

    VehicleAbstract(Builder<?> builder) {
        addons = builder.addons.clone();
    }

    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Addon> addons = EnumSet.noneOf(Addon.class);

        public T addon(Addon addon) {
            addons.add(Objects.requireNonNull(addon));
            // can't return this so it needs to be self()
            return self();
        }

        abstract VehicleAbstract build();

        protected abstract T self();
    }



}

class Car extends VehicleAbstract {

    public enum Level {BUDGET, COMFORT, LUXURY};

    private final Level level;

    public static class Builder extends VehicleAbstract.Builder<Builder> {

        private final Level level;

        public Builder(Level level) {
            this.level = Objects.requireNonNull(level);
        }

        @Override
        public Car build() {
            return new Car(this);
        }

        // This is added since it is extended from it's base class
        // this makes sure that we do not need casts
        // this is called covariant return typing
        @Override
        protected Builder self() { return this;}
    }

    private Car(Builder builder) {
        super(builder);
        level = builder.level;
    }
}

class Cycle extends VehicleAbstract {

    private final boolean forRacing;

    public static class Builder extends VehicleAbstract.Builder<Builder> {

        private final boolean forRacing;

        public Builder() {
            this.forRacing = true;
        }

        @Override
        public Cycle build() {
            return new Cycle(this);
        }

        // this makes sure that we do not need casts
        // this is called covariant return typing
        @Override
        protected Builder self() { return this;}
    }

    private Cycle(Builder builder) {
        super(builder);
        forRacing = builder.forRacing;
    }
}
