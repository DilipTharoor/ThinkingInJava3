package com.dithkara.Item1;

import java.util.HashMap;
import java.util.Map;

/**
 * Accessing a class declared with a public static function.
 * Here we are creating a class which is instance controlled just like flyweight pattern
 * Makes sure it is singleton
 * Makes sure it is noninstantiable if required, it is not so here though
 * Makes sure it is immutable which is provided by Enums by default
 */
public class MyInstanceControlledVehicle {

    private static final Map<String, Vehicle> vehicleMap = new HashMap<>();

    /**
     * The return type can be any subtype, eventhough we dont expose each subtype.  Which is an example of
     * interface based frameworks and is also a good practice to refer to returned object as an interface rather than
     * the implementation.
     *
     * As an added advantage we can later remove subclasses from the exposed API and the clients needn't care about what
     * subclasses are supported and what is since we are only exposing the interface.
     *
     * Use the name as 'from' or 'of' or 'valueOf' or 'getInstance' or 'newInstance' or 'getType' or 'newType'
     *
     * @param type
     * @return
     */
    public static Vehicle fromType(String type) {

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
        MyInstanceControlledVehicle.fromType("Car").startCar();
        MyInstanceControlledVehicle.fromType("Car").startCar();
        MyInstanceControlledVehicle.fromType("Car").startCar();
        MyInstanceControlledVehicle.fromType("Car").startCar();
        MyInstanceControlledVehicle.fromType("Bus").startCar();
        MyInstanceControlledVehicle.fromType("Bus").startCar();
        MyInstanceControlledVehicle.fromType("Bus").startCar();
        MyInstanceControlledVehicle.fromType("Bus").startCar();
    }


    interface Vehicle {

        void startCar();

    }

    static class Bus implements Vehicle {

        @Override
        public void startCar() {
            System.out.println("Starting Bus. Instance : " + this);
        }
    }

    static class Car implements Vehicle {

        @Override
        public void startCar() {
            System.out.println("Starting Car. Instance : " + this);
        }
    }

}
