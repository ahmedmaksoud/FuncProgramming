package test.func;

import java.util.*;
import java.util.stream.Stream;

public class FunctionalPipelineExample3 {

    public static void main(String[] args) {
        // Input string
        String input = "Functional Programming in Java";


        // Create the pipeline
        Map<String, String> result = Stream.of(input)
                .map(FunctionalPipelineExample3::orderDiscountCalculator2)
                .map(FunctionalPipelineExample3::removeVowels)
                .map(FunctionalPipelineExample3::reverseString)
                .findFirst()
                .orElse(Map.of("original", input, "result", "Error"));

        // Output the result
        System.out.println("Original: " + result.get("original"));
        System.out.println("Result: " + result.get("result"));
    }

    // Task 1: Simulating an order discount calculation
    public static Map<String, String> orderDiscountCalculator2(String input) {
        String result = input + " - Discounted";
        return Map.of("original", input, "result", result);
    }

    // Task 2: Remove all vowels
    public static Map<String, String> removeVowels(Map<String, String> inputMap) {
        String input = inputMap.get("result");
        String result = input.replaceAll("[AEIOUaeiou]", "");
        return Map.of("original", input, "result", result);
    }

    // Task 3: Reverse the string
    public static Map<String, String> reverseString(Map<String, String> inputMap) {
        String input = inputMap.get("result");
        String result = new StringBuilder(input).reverse().toString();
        return Map.of("original", input, "result", result);
    }
}
