package test.func.ship;

import test.func.ship.dtos.Freight;
import test.func.ship.dtos.Shipping;

import java.util.function.Function;

public class FreightFunction {


    public enum FreightChoice { FR1, FR2, FR3, FR4, FR5, FR6 }

    private FreightChoice freightChoose;
    private Function<Shipping, Freight> calcFreight;

    public FreightFunction(FreightChoice freightChoose, Function<Shipping, Freight> calcFreight) {
        this.freightChoose = freightChoose;
        this.calcFreight = calcFreight;
    }

    public FreightChoice getFreightChoose() {
        return freightChoose;
    }

    public Function<Shipping, Freight> getCalcFreight() {
        return calcFreight;
    }
}