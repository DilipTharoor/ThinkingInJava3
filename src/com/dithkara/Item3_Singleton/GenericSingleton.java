package com.dithkara.Item3_Singleton;

// Just written here, but this will be elaborated in Item 30
public class GenericSingleton {

    // Instance of an interface here, then it has to implement an apply
    private static SingletonInterface<Object> ID_FUNC = new SingletonInterface<Object>() {

        // Need to implement this because we are creating an interface instance
        @Override
        public Object apply(Object arg) {
            return arg;
        }
    };

    public static <T> SingletonInterface<T> idFunction() {
        return (SingletonInterface<T>) ID_FUNC;
    }

    public static void main(String[] args) {
        String[] strings = { "Item1", "Item2", "Item3" };
        SingletonInterface<String> sameString = idFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = { 1, 2, 3 };
        SingletonInterface<Number> sameNumber = idFunction();
        for (Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }
    }


}
interface SingletonInterface<T>
{
    T apply(T arg);
}

