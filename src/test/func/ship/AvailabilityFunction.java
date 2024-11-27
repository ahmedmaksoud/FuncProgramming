package test.func.ship;

import test.func.ship.dtos.Availability;
import test.func.ship.dtos.Order;

import java.util.function.Function;




public class AvailabilityFunction {
    private AvailabilityChoice availabilityChoose;
    private Function<Order, Availability> calcAvailability;
    public enum AvailabilityChoice
    {
        AV1,
        AV2,
        AV3,
        AV4
    }
    public AvailabilityFunction(AvailabilityChoice availabilityChoose, Function<Order, Availability> calcAvailability) {
        this.availabilityChoose = availabilityChoose;
        this.calcAvailability = calcAvailability;
    }

    public AvailabilityChoice getAvailabilityChoose() {
        return availabilityChoose;
    }

    public Function<Order, Availability> getCalcAvailability() {
        return calcAvailability;
    }
}