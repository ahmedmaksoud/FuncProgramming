package test.func.ship;

import test.func.ship.dtos.Invoice;
import test.func.ship.dtos.Order;

import java.util.function.Function;

public class InvoiceFunction {
    private invoiceChoiceEnum invoiceChoose;
    private Function<Order, Invoice> calcInvoice;

    public enum invoiceChoiceEnum { INV1, INV2, INV3, INV4, INV5 }

    public InvoiceFunction(invoiceChoiceEnum invoiceChoose, Function<Order, Invoice> calcInvoice) {
        this.invoiceChoose = invoiceChoose;
        this.calcInvoice = calcInvoice;
    }

    public invoiceChoiceEnum getInvoiceChoose() {
        return invoiceChoose;
    }

    public Function<Order, Invoice> getCalcInvoice() {
        return calcInvoice;
    }
}