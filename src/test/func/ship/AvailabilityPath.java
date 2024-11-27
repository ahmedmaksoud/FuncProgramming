package test.func.ship;

import test.func.ship.dtos.Availability;
import test.func.ship.dtos.Order;
import test.func.ship.dtos.ShippingDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AvailabilityPath {

    private List<AvailabilityFunction> availabilityFunctions;
    private List<ShippingDateFunction> shippingDateFunctions;

    public AvailabilityPath() {
        availabilityFunctions = new ArrayList<>();
        availabilityFunctions.add(new AvailabilityFunction(AvailabilityFunction.AvailabilityChoice.AV1, this::calcAvailability1));
        availabilityFunctions.add(new AvailabilityFunction(AvailabilityFunction.AvailabilityChoice.AV2, this::calcAvailability2));
        availabilityFunctions.add(new AvailabilityFunction(AvailabilityFunction.AvailabilityChoice.AV3, this::calcAvailability3));
        availabilityFunctions.add(new AvailabilityFunction(AvailabilityFunction.AvailabilityChoice.AV4, this::calcAvailability4));

        shippingDateFunctions = new ArrayList<>();
        shippingDateFunctions.add(new ShippingDateFunction(ShippingDateFunction.shippingDateChoiceEnum.SD1, this::calcShippingDate1));
        shippingDateFunctions.add(new ShippingDateFunction(ShippingDateFunction.shippingDateChoiceEnum.SD2, this::calcShippingDate2));
        shippingDateFunctions.add(new ShippingDateFunction(ShippingDateFunction.shippingDateChoiceEnum.SD3, this::calcShippingDate3));
        shippingDateFunctions.add(new ShippingDateFunction(ShippingDateFunction.shippingDateChoiceEnum.SD4, this::calcShippingDate4));
        shippingDateFunctions.add(new ShippingDateFunction(ShippingDateFunction.shippingDateChoiceEnum.SD5, this::calcShippingDate5));
    }

    public List<AvailabilityFunction> getAvailabilityFunctions() {
        return availabilityFunctions;
    }

    public List<ShippingDateFunction> getShippingDateFunctions() {
        return shippingDateFunctions;
    }

    // Functional methods
    private Availability calcAvailability1(Order order) {
        Availability a = new Availability();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        a.setDate(calendar.getTime());
        return a;

    }
    private Availability calcAvailability2(Order order) {  Availability a = new Availability();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 4);
        a.setDate(calendar.getTime());
        return a;}
    private Availability calcAvailability3(Order order) { Availability a = new Availability();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        a.setDate(calendar.getTime());
        return a; }
    private Availability calcAvailability4(Order order) {  Availability a = new Availability();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        a.setDate(calendar.getTime());
        return a;}

    private ShippingDate calcShippingDate1(Availability availability) {
        ShippingDate a = new ShippingDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(availability.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        a.setDate(calendar.getTime());
        return a;

    }
    private ShippingDate calcShippingDate2(Availability availability) { ShippingDate a = new ShippingDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(availability.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        a.setDate(calendar.getTime());
        return a;}
    private ShippingDate calcShippingDate3(Availability availability) { ShippingDate a = new ShippingDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(availability.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 4);
        a.setDate(calendar.getTime());
        return a; }
    private ShippingDate calcShippingDate4(Availability availability) { ShippingDate a = new ShippingDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(availability.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        a.setDate(calendar.getTime());
        return a;}
    private ShippingDate calcShippingDate5(Availability availability) { ShippingDate a = new ShippingDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(availability.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        a.setDate(calendar.getTime());
        return a;}
}
