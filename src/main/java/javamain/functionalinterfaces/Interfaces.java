package main.java.javamain.functionalinterfaces;

import java.util.Random;
import java.util.function.*;

public class Interfaces {
    public static void main(String[] args) {

//        Predicate<T>
//
//        Consumer<T>
//
//        Function<T, R>
//
//        Supplier<T>
//
//        UnaryOperator<T>
//
//        BinaryOperator<T>
        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(5));

        Consumer<Integer> printer = x -> System.out.println("x");
        printer.accept(600);

        Function<Integer, String> convert = x -> String.valueOf(x) + " $";
        System.out.println(convert.apply(500));

        Supplier<Integer> str = () -> new Random().nextInt(10);
        System.out.println(str.get());
    }


}
