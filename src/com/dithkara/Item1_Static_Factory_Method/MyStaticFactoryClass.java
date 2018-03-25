package com.dithkara.Item1_Static_Factory_Method;

/**
 * Accessing a class declared with a public static function.
 * Helps in creating an immutable class : Something whos state cannot be changed once it is created.
 * Use this whenever we are thinking of creating multiple constructors for the same class.
 *
 * Difficult to sublclass because there are no public or protected constructors
 *
 */
public class MyStaticFactoryClass {

    private String message = "message";

    public String getMessage() {
        return message;
    }

    public void setMessage(String defaultMsg) {
        this.message = defaultMsg;
    }

    /**
     * Public static function to get the instance
     * @return the instance of MyStaticFactoryClass
     */
    public static MyStaticFactoryClass getStaticClass() {
        return new MyStaticFactoryClass();
    }

    /**
     * Public static function to get the instance.
     * Here we do not need to use a second constructor with a different paramter list to identify between the two
     * We can name the static factory methods instead of creating two different constructors
     * @return the instance of MyStaticFactoryClass with initialised values
     */
    public static MyStaticFactoryClass getStaticClassInitialised() {
        MyStaticFactoryClass myStaticFactoryClass =  new MyStaticFactoryClass();
        myStaticFactoryClass.setMessage("new message");
        return myStaticFactoryClass;
    }



    public static void main(String[] args) {

        MyStaticFactoryClass myStaticFactoryClass = MyStaticFactoryClass.getStaticClass();
        System.out.println(myStaticFactoryClass.getMessage());

        MyStaticFactoryClass myStaticFactoryClassWithDefaultMsg = MyStaticFactoryClass.getStaticClassInitialised();
        System.out.println(myStaticFactoryClassWithDefaultMsg.getMessage());

    }
}
