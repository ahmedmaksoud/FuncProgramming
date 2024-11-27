package test.func;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class OrderDiscountCalculator {
    
    public static void main(String[] args) {
        // Map order types to discount strategies using method references
        Map<String, Function<Double, Double>> discountStrategies = new HashMap<>();
        discountStrategies.put("REGULAR", OrderDiscountCalculator::calculateRegularDiscount);
        discountStrategies.put("PREMIUM", OrderDiscountCalculator::calculatePremiumDiscount);
        discountStrategies.put("VIP", OrderDiscountCalculator::calculateVipDiscount);

        // Example order details
        String orderType = "PREMIUM";
        double orderValue = 1000.0;

        // Get the discount function based on order type
        Function<Double, Double> discountFunction = discountStrategies.get(orderType.toUpperCase());

        // Apply discount using the separate method
        calculateAndPrintDiscount(discountFunction, orderValue);
    }

    // Separate method to apply the discount
    private static void calculateAndPrintDiscount(Function<Double, Double> discountFunction, double orderValue) {
        if (discountFunction != null) {
            double discountedPrice = discountFunction.apply(orderValue);
            System.out.println("Discounted price: " + discountedPrice);
        } else {
            System.out.println("Invalid order type!");
        }
    }

    // Complex logic for Regular Discount
    private static double calculateRegularDiscount(double orderValue) {
        if (orderValue > 500) {
            return orderValue - 50;
        } else {
            return orderValue * 0.98;
        }
    }

    // Complex logic for Premium Discount
    private static double calculatePremiumDiscount(double orderValue) {
        if (orderValue > 1000) {
            return orderValue * 0.85;
        } else {
            return orderValue * 0.90;
        }
    }

    // Complex logic for VIP Discount
    private static double calculateVipDiscount(double orderValue) {
        return orderValue - (orderValue * 0.20) + 10;
    }
}
