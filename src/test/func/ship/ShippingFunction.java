package test.func.ship;

import test.func.ship.dtos.Invoice;
import test.func.ship.dtos.Shipping;

import java.util.function.Function;

public class ShippingFunction {
    private shippingChoiceEnum shippingChoose;
    private Function<Invoice, Shipping> calcShipping;

    public enum shippingChoiceEnum { SH1, SH2, SH3 }



    public ShippingFunction(shippingChoiceEnum shippingChoose, Function<Invoice, Shipping> calcShipping) {
        this.shippingChoose = shippingChoose;
        this.calcShipping = calcShipping;
    }

    public shippingChoiceEnum getShippingChoose() {
        return shippingChoose;
    }

    public Function<Invoice, Shipping> getCalcShipping() {
        return calcShipping;
    }
}