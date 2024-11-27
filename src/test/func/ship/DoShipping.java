package test.func.ship;

import test.func.ship.dtos.Customer;
import test.func.ship.dtos.Freight;
import test.func.ship.dtos.Order;
import test.func.ship.dtos.ShippingDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

public class DoShipping {

    public static void main(String[] args) {
        InvoicingPath invoicePath = new InvoicingPath();
        AvailabilityPath availabilityPath = new AvailabilityPath();

        ConfigurationResult configResult = setConfiguration();

        Function<Order, Double> costOfOrder = calcAdjustedCostofOrder(
                configResult.getProcessConfiguration(),
                invoicePath,
                availabilityPath
        );
        System.out.println(costOfOrder.apply(configResult.getOrder()));
    }

    // Setup of the Process Configuration and Data
    public static ConfigurationResult setConfiguration() {
        ProcessConfiguration processConfiguration = new ProcessConfiguration();
        Customer customer = new Customer();
        Order order = new Order();

        // Configuration setup
        processConfiguration.setInvoiceChoice(InvoiceFunction.invoiceChoiceEnum.INV3);
        processConfiguration.setShippingChoice(ShippingFunction.shippingChoiceEnum.SH2);
        processConfiguration.setFreightChoice(FreightFunction.FreightChoice.FR3);
        processConfiguration.setAvailabilityChoice(AvailabilityFunction.AvailabilityChoice.AV2);
        processConfiguration.setShippingDateChoice(ShippingDateFunction.shippingDateChoiceEnum.SD2);

        order.setCustomer(customer);

        Date date = Date.from(LocalDate.of(2021, 3, 16).atStartOfDay(ZoneId.systemDefault()).toInstant());

        order.setDate(date);
        order.setCost(2000);

        return new ConfigurationResult(order, processConfiguration);
    }

    public static Function<Order, Freight> invoicePathFunc(ProcessConfiguration c, InvoicingPath fpl) {

        Function<Order, Freight> p =
                fpl.getInvoiceFunctions().stream()
                        .filter(x -> x.getInvoiceChoose().equals(c.getInvoiceChoice()))
                        .map(InvoiceFunction::getCalcInvoice)
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("No matching InvoiceFunction"))
                        .andThen(
                                fpl.getShippingFunctions().stream()
                                        .filter(x -> x.getShippingChoose().equals(c.getShippingChoice()))
                                        .map(ShippingFunction::getCalcShipping)
                                        .findFirst()
                                        .orElseThrow(() -> new IllegalStateException("No matching ShippingFunction"))
                        )
                        .andThen(
                                fpl.getFreightFunctions().stream()
                                        .filter(x -> x.getFreightChoose().equals(c.getFreightChoice()))
                                        .map(FreightFunction::getCalcFreight)
                                        .findFirst()
                                        .orElseThrow(() -> new IllegalStateException("No matching FreightFunction"))
                        );

        return p;
    }

//    public static Function<Order, Double> calcAdjustedCostOfOrder(
//            ProcessConfiguration c,
//            InvoicingPath invoicePath,
//            AvailabilityPath availabilityPath) {
//
//        return order -> adjustCost(order,
//                invoicePathFunc(c, invoicePath),
//                availabilityPathFunc(c, availabilityPath));
//    }

    public static Function<Order, ShippingDate> availabilityPathFunc(
            ProcessConfiguration c,
            AvailabilityPath spl) {

        Function<Order, ShippingDate> p =
                spl.getAvailabilityFunctions().stream()
                        .filter(x -> x.getAvailabilityChoose().equals(c.getAvailabilityChoice()))
                        .map(AvailabilityFunction::getCalcAvailability)
                        .findFirst()
                        .orElseThrow(() -> new IllegalStateException("No matching AvailabilityFunction"))
                        .andThen(
                                spl.getShippingDateFunctions().stream()
                                        .filter(x -> x.getShippingDateChoose().equals(c.getShippingDateChoice()))
                                        .map(ShippingDateFunction::getCalcShippingDate)
                                        .findFirst()
                                        .orElseThrow(() -> new IllegalStateException("No matching ShippingDateFunction"))
                        );

        return p;
    }

//    public static <T1, T2, T3> Function<T1, T3> compose(Function<T1, T2> f, Function<T2, T3> g) {
//        return x -> g.apply(f.apply(x));
//    }

    public static double adjustCost(Order order, Function<Order, Freight> calcFreight, Function<Order, ShippingDate> calcShippingDate) {
        Freight freight = calcFreight.apply(order);
        ShippingDate shippingDate = calcShippingDate.apply(order);

        Calendar cal = Calendar.getInstance();
        cal.setTime(shippingDate.getDate());
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        System.out.println("\n\nDay of Shipping: " + dayOfWeek + "\n");

        cal.setTime(shippingDate.getDate());
        double cost =  dayOfWeek == DayOfWeek.MONDAY.getValue()
                ? freight.getCost() + 1000
                : freight.getCost() + 500;

        // Final Cost
        return cost;
    }


    public static Function<Order, Double> calcAdjustedCostofOrder(
            ProcessConfiguration config,
            InvoicingPath invoicePath,
            AvailabilityPath availabilityPath) {

        return order -> adjustCost(
                order,
                invoicePathFunc(config, invoicePath),
                availabilityPathFunc(config, availabilityPath)
        );
    }
}
