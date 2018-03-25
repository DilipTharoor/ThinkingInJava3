package com.dithkara.Item3_Singleton;

import java.io.Serializable;

/**
 * Singleton makes it difficult to test, because it is difficult to mock unless this implements a interface
 *
 * This is the method to use, if you want to change ur mind and return another instance
 * generic singleton factory is derived from this
 * method reference can be used as a supplier //TODO need example for this
 */
public class Singleton2 implements Serializable {

    private final transient String message;

    // this is private instead of public in the first one, has to be final
    private static final Singleton2 INSTANCE = new Singleton2();

    // This also makes sure it is made singleton
    private Singleton2() {
        this.message = "test message";
    }

    // The Api is clearer in this approach,
    // this can be modified to return another instance if required
    public static Singleton2 getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

}
