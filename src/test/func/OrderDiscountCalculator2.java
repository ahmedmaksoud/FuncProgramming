package test.func;

import java.util.function.Function;

public class OrderDiscountCalculator2 {

    Function<Double, Double> REGULAR;
    Function<Double, Double> PREMIUM;
    Function<Double, Double> VIP;

    public OrderDiscountCalculator2() {
        REGULAR = this::calculateRegularDiscount;
        PREMIUM = this::calculatePremiumDiscount;
        VIP = this::calculateVipDiscount;
    }


    public static void main(String[] args) {

        OrderDiscountCalculator2 orderDiscountCalculator2 = new OrderDiscountCalculator2();
        orderDiscountCalculator2.doCalc();
    }

    private  void doCalc() {
        // Example order
        Order order = new Order(Order.OrderType.PREMIUM, 1000.0);

        // Get the discount function based on order type
        Function<Double, Double> discountFunction =
                order.getType().equals(Order.OrderType.REGULAR) ? REGULAR
                        : order.getType().equals(Order.OrderType.PREMIUM) ? PREMIUM
                        : VIP;

        // Apply discount using the separate method
        calculateAndPrintDiscount(discountFunction, order);
    }


    // Separate method to apply the discount
    private  void calculateAndPrintDiscount(Function<Double, Double> discountFunction, Order order) {
        if (discountFunction != null) {
            double discountedPrice = discountFunction.apply(order.getValue());
            System.out.println("Discounted price: " + discountedPrice);
        } else {
            System.out.println("Invalid order type!");
        }
    }

    // Complex logic for Regular Discount
    private  double calculateRegularDiscount(double orderValue) {
        if (orderValue > 500) {
            return orderValue - 50;
        } else {
            return orderValue * 0.98;
        }
    }

    // Complex logic for Premium Discount
    private  double calculatePremiumDiscount(double orderValue) {
        if (orderValue > 1000) {
            return orderValue * 0.85;
        } else {
            return orderValue * 0.90;
        }
    }

    // Complex logic for VIP Discount
    private  double calculateVipDiscount(double orderValue) {
        return orderValue - (orderValue * 0.20) + 10;
    }

    public  String testFunc(String orderValue) {
        return "";
    }
}
