package com.dithkara.Item1_Static_Factory_Method;

import java.util.HashMap;
import java.util.Map;

/**
 * Example implementing Flyweight Pattern.
 * It is a structural pattern
 * Makes sure that everytime something is created, something already does not exist.
 * if exists it returns the existing instance
 */
public class FlyweightPattern {

    private final Map<String, Vehicle> vehicleMap;

    Vehicle getVehicle(String type) {

        if (null != vehicleMap.get(type)) {
            return vehicleMap.get(type);
        }

        switch (type) {
            case "Car":
                Vehicle car = new Car();
                vehicleMap.put("Car", car);
                return car;
            case "Bus":
                Vehicle bus = new Bus();
                vehicleMap.put("Bus", bus);
                return bus;
        }

        return null;

    }

    public static void main(String[] args) {
        FlyweightPattern vehicleFactory = new FlyweightPattern();

        vehicleFactory.getVehicle("Car").startCar();
        vehicleFactory.getVehicle("Bus").startCar();
        vehicleFactory.getVehicle("Car").startCar();
        vehicleFactory.getVehicle("Car").startCar();
        vehicleFactory.getVehicle("Car").startCar();
        vehicleFactory.getVehicle("Bus").startCar();
        vehicleFactory.getVehicle("Bus").startCar();
        vehicleFactory.getVehicle("Bus").startCar();
    }


    public FlyweightPattern() {
        vehicleMap = new HashMap<>();
    }

    interface Vehicle {

        void startCar();

    }

    class Bus implements Vehicle {

        @Override
        public void startCar() {
            System.out.println("Starting Bus. Instance : " + this);
        }
    }

    class Car implements Vehicle {

        @Override
        public void startCar() {
            System.out.println("Starting Car. Instance : " + this);
        }
    }

}
