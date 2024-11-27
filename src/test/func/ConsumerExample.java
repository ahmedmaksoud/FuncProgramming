package test.func;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        // List of names
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Consumer to print each name
        Consumer<String> printName = name -> System.out.println("Name: " + name);

        // Consumer to convert each name to uppercase
        Consumer<String> toUpperCase = name -> System.out.println("Uppercase Name: " + name.toUpperCase());

        // Apply the Consumer
        System.out.println("Printing Names:");
        names.forEach(printName);

        System.out.println("\nConverting to Uppercase:");
        names.forEach(toUpperCase);

        // Chaining Consumers
        System.out.println("\nChaining Consumers:");
        Consumer<String> combinedConsumer = printName.andThen(toUpperCase);
        names.forEach(combinedConsumer);
        System.out.println("???????????????????????????");
        names.forEach(System.out::println);
    }
}
