package com.dithkara.Item3_Singleton;

import java.io.Serializable;

/**
 * Singleton makes it difficult to test, because it is difficult to mock unless this implements a interface
 *
 * This is the best option unless the ones mentioned for Singleton2 is considered
 */
public class Singleton implements Serializable{

    // has to be declared transient so that it is not serialized, so that it makes it singleton
    private final transient String message;

    // makes it singleton
    // can create another instance using AccessibleObject.setAccessible, needs extra check to fail this
    public static final Singleton INSTANCE = new Singleton();

    // This also makes sure it is made singleton
    private Singleton() {
        this.message = "first message";
    }

    // Needs to be implemented otherwise deserialization will create another instance instead of this one
    private Object readResolve() {
        return INSTANCE;
    }

}
