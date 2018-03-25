package com.dithkara.Item3_Singleton;

import java.io.Serializable;

/**
 * Best singleton approach which helps against reflection attacks and also serialization issues
 * Cannot use when you want to extend anything other than Enums
 * But can declare an enum to implement as shown below
 */
public enum Singleton3 implements Operator{

    INSTANCE {
        @Override
        public String apply(String message) {
            return message + "in subclass";
        }
    }

}

interface Operator {
    String apply(String message);
}
