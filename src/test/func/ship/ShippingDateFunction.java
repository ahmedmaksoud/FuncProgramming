package test.func.ship;

import test.func.ship.dtos.Availability;
import test.func.ship.dtos.ShippingDate;

import java.util.function.Function;

public class ShippingDateFunction {
    private shippingDateChoiceEnum shippingDateChoose;
    private Function<Availability, ShippingDate> calcDateShipping;



    public enum shippingDateChoiceEnum
    {
        SD1,
        SD2,
        SD3,
        SD4,
        SD5
    }

    public ShippingDateFunction(shippingDateChoiceEnum shippingDateChoose, Function<Availability, ShippingDate> calcDateShipping) {
        this.shippingDateChoose = shippingDateChoose;
        this.calcDateShipping = calcDateShipping;
    }

    public shippingDateChoiceEnum getShippingDateChoose() {
        return shippingDateChoose;
    }

    public Function<Availability, ShippingDate> getCalcShippingDate() {
        return calcDateShipping;
    }
}