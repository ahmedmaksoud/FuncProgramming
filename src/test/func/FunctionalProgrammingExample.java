package test.func;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalProgrammingExample {
    public static void main(String[] args) {
        // List of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Predicate for filtering even numbers
        Predicate<Integer> isEven = num -> num % 2 == 0;

        // Function for squaring a number
        Function<Integer, Integer> square = num -> num * num;

        // Functional approach: Filter and transform the list
        List<Integer> evenSquares = numbers.stream()
                .filter(isEven) // Filter even numbers
                .map(square)   // Square each number
                .collect(Collectors.toList());

        // Print the result
        System.out.println("Squared Even Numbers: " + evenSquares);
    }
}
