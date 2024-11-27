package test.func;

import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionalPipelineExample {

    public static void main(String[] args) {
        // Input string
        String input = "Functional Programming in Java";

        // Define the tasks as functions
        Function<String, String> toUpperCase = str -> str.toUpperCase();
        Function<String, String> removeVowels = str -> str.replaceAll("[AEIOUaeiou]", "");
        Function<String, String> reverseString = str -> new StringBuilder(str).reverse().toString();

        // Create the pipeline by chaining the functions
        OrderDiscountCalculator2 orderDiscountCalculator2 = new  OrderDiscountCalculator2();

        String result = Stream.of(input)
                .map(toUpperCase)
                .map(orderDiscountCalculator2::testFunc)
                .map(reverseString)
                .map(FunctionalPipelineExample::testFunc2)
                .findFirst()
                .orElse("");

        // Output the result
        System.out.println("Final Result: " + result);
    }

    public  static String testFunc2(String orderValue) {
        return "";
    }


}