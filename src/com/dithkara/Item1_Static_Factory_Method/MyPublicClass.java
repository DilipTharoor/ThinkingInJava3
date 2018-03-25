package com.dithkara.Item1_Static_Factory_Method;

/**
 * Accessing a class declared with a public constructor
 */
public class MyPublicClass {

    private final String message = "message";

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {

        MyPublicClass publicClass = new MyPublicClass();
        System.out.println(publicClass.getMessage());

    }
}
