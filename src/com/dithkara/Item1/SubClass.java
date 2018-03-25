package com.dithkara.Item1;

class SubClass implements InterfaceWithStatic {

}

interface InterfaceWithStatic {

    /**
     * Java 8 allows static classes in interface but it needs a body.  So now we do not need a noninstantiable companion class
     * anymore like we had for Collections API
     * Java 9 allows this to be private, but static fields and member classes needs to be public
     *
     * TODO : Need to find out how to override this in the subclass
     */
    static void staticFunction() {
        int i = 1;
    }
}
