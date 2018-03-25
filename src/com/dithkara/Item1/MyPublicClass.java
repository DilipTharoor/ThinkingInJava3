package com.dithkara.Item1;

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
