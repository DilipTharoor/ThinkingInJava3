package com.dithkara.Item4_Non_Instantiability;

/**
 * This is used for util classes which has multiple static functions.
 *
 */
public class NonInstantiable {

    /**
     * Making this private makes sure that it can't be instantiated.
     *
     * Also makes sure it cannot be inherited because implicitly the super constructor will get called,
     * which in this case will not be allowed
     */
    private NonInstantiable() {
        // Not strictly required
        throw new AssertionError();
    }

    public static void function1(){

    }

    public static String function2() {
        return "message";
    }
}
