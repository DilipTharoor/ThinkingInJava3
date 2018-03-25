package com.dithkara.Item3_Singleton;

public class Main {

    public static void main(String[] args) {
        // Usual approach if not enum
        System.out.println(Singleton.INSTANCE);
        System.out.println(Singleton.INSTANCE);

        // For special cases
        System.out.println(Singleton2.getInstance());
        System.out.println(Singleton2.getInstance());

        // Best approach
        System.out.println(Singleton3.INSTANCE);
        System.out.println(Singleton3.INSTANCE);

    }
}
