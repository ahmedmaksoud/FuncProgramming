package test.func;

import java.util.function.Function;

public class CompositeMethod {

    // Method that accepts a Function and returns another Function
    public static <T, R, V> Function<T, V> transformFunction(
            Function<T, R> inputFunction,
            Function<R, V> transformationFunction
    ) {


        return inputFunction.andThen(transformationFunction);
    }

    public static void main(String[] args) {
        // Example function: Takes an Integer and returns its square
        Function<Integer, Integer> squareFunction = x -> x * x;

        // Example function: Takes an Integer and converts it to a String
        Function<Integer, String> toStringFunction = Object::toString;

        // Use transformFunction to combine the above two functions
        Function<Integer, String> squareThenToString = transformFunction(squareFunction, toStringFunction);

        // Apply the returned function
        System.out.println(squareThenToString.apply(5)); // Output: "25"

        Function<Integer, Integer> addOne = CompositeMethod::addOne;

        Function<Integer, Integer> multiply = CompositeMethod::multiplyTwo;

        Function<Integer, Integer> res = transformFunction(addOne, multiply);

        System.out.println(res.apply(5)); //

        Function<Order, Invoice> getOrder = CompositeMethod::getOrder;

        Function<Invoice, Receipt> getReceipt = CompositeMethod::getRecipt;

        Function<Order, Receipt> rec = transformFunction(getOrder, getReceipt);

        System.out.println(rec.apply(new Order()).getValue()); //

    }

    private static Integer addOne (Integer number) {
        return number + 1;
    }

    private static Integer multiplyTwo (Integer number) {
        return number * 2;
    }


    private static Invoice getOrder (Order order) {
        return new Invoice();
    }

    private static Receipt getRecipt (Invoice invoice) {
        return new Receipt();
    }
}
