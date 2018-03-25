package com.dithkara.Item2_Builder;

/**
 * This should be used instead of Telescoping constructors(one constructor calling another with added constructor....)
 * or Java bean pattern (multiple setters and a constructor).
 *
 * Java bean pattern has an inconsistent state while it is being built and also difficult to make it immutable
 *
 * This should be used when the parameters are more than 4, if most of them are identical and some of them are optional
 */
public class BuilderPattern {

    public static void main(String [] args) {
        // chaining resulting in fluent API
        // Fluent API makes sure that we implement chaining by having an order of calls which relates to a
        // real world scenario
        Vehicle vehicle = new Vehicle.Builder("Mercedes", "C Class").cost(66000).year(2017).build();
    }
}

class Vehicle {

    String model;
    String make;
    int year;
    int cost;

    // should have a private constructor
    private Vehicle(Builder builder) {
        this.model = builder.model;
        this.make = builder.make;
        this.year = builder.year;
        this.cost = builder.cost;
    }

    // need this to be static so that we can call this from outside
    // Builder might not be performance friendly so use it only when needed
    public static class Builder {

        // Mandatory
        private String model;
        private String make;

        // optional
        private int year;
        private int cost;

        // Pass the mandatory parameters here
        public Builder(String model, String make) {
            // Do validity checks here and throw IllegalArgumentException if invalid
            this.model = model;
            this.make = make;
        }

        public Builder year(int year) {
            // Do validity checks here and throw IllegalArgumentException if invalid
            this.year = year;
            return this;
        }

        public Builder cost(int cost) {
            // Do validity checks here and throw IllegalArgumentException if invalid
            this.cost = cost;
            return this;
        }

        public Vehicle build() {
            // this calls the private constructor
            return new Vehicle(this);
        }

    }

}
