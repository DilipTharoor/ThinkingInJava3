package com.dithkara.Item1;

/**
 * Example implementing Factory Pattern
 * This is creational since it is used when we create objects
 * The instance that needs to be created will be created using a variable
 */
public class VehicleFactory {

    Vehicle getVehicle(String type) {

        switch(type) {
            case "Car" :
                return new Car();
            case "Bus" :
                return new Bus();
        }

        return null;

    }

    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        vehicleFactory.getVehicle("Car").startCar();
        vehicleFactory.getVehicle("Bus").startCar();
    }


    interface Vehicle {

        void startCar();

    }

    class Bus implements Vehicle {

        @Override
        public void startCar() {
            System.out.println("Starting Bus");
        }
    }

    class Car implements Vehicle {

        @Override
        public void startCar() {
            System.out.println("Starting Car");
        }
    }
}
