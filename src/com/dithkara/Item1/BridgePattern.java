package com.dithkara.Item1;

/**
 * Implementation for Bridge pattern which is also a service provider pattern
 * This is a structural pattern where in we decouple the implementation from the abstraction
 *
 * Dependency injection is also considered as a service provider framework.
 *
 * We should never write our own service provider from Java 6 onwards since it is already provided by java.util.ServiceLoader
 *
 *
 */
public class BridgePattern {

    public BridgePattern() {
        // service access is done using the class type
        Car car1 = new Car(new Honk());
        car1.startCar();

        Car car2 = new Car(new Rev());
        car2.startCar();
    }

    public static void main(String[] args) {
        BridgePattern bridgePattern = new BridgePattern();
    }

    abstract class Sound {

        public abstract void makeSound();
    }

    // Service 1
    class Honk extends Sound{

        @Override
        public void makeSound() {
            System.out.println("Honking...");
        }

    }

    // Service 2
    class Rev extends Sound{

        @Override
        public void makeSound() {
            System.out.println("Revving...");
        }

    }

    class Car {

        Sound sound;

        public Car(Sound sound) {
            this.sound = sound;
        }

        public void startCar() {
            System.out.println("Starting Car");
            this.sound.makeSound();
        }
    }
}
