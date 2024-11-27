package test.func.ship;



import test.func.ship.dtos.Freight;
import test.func.ship.dtos.Invoice;
import test.func.ship.dtos.Order;
import test.func.ship.dtos.Shipping;

import java.util.ArrayList;
import java.util.List;

public class InvoicingPath {

    private List<InvoiceFunction> invoiceFunctions;
    private List<ShippingFunction> shippingFunctions;
    private List<FreightFunction> freightFunctions;

    public InvoicingPath() {
        invoiceFunctions = new ArrayList<>();
        invoiceFunctions.add(new InvoiceFunction(InvoiceFunction.invoiceChoiceEnum.INV1, this::calcInvoice1));
        invoiceFunctions.add(new InvoiceFunction(InvoiceFunction.invoiceChoiceEnum.INV2, this::calcInvoice2));
        invoiceFunctions.add(new InvoiceFunction(InvoiceFunction.invoiceChoiceEnum.INV3, this::calcInvoice3));
        invoiceFunctions.add(new InvoiceFunction(InvoiceFunction.invoiceChoiceEnum.INV4, this::calcInvoice4));
        invoiceFunctions.add(new InvoiceFunction(InvoiceFunction.invoiceChoiceEnum.INV5, this::calcInvoice5));

        shippingFunctions = new ArrayList<>();
        shippingFunctions.add(new ShippingFunction(ShippingFunction.shippingChoiceEnum.SH1, this::calcShipping1));
        shippingFunctions.add(new ShippingFunction(ShippingFunction.shippingChoiceEnum.SH2, this::calcShipping2));
        shippingFunctions.add(new ShippingFunction(ShippingFunction.shippingChoiceEnum.SH3, this::calcShipping3));

        freightFunctions = new ArrayList<>();
        freightFunctions.add(new FreightFunction(FreightFunction.FreightChoice.FR1, this::calcFreightCost1));
        freightFunctions.add(new FreightFunction(FreightFunction.FreightChoice.FR2, this::calcFreightCost2));
        freightFunctions.add(new FreightFunction(FreightFunction.FreightChoice.FR3, this::calcFreightCost3));
        freightFunctions.add(new FreightFunction(FreightFunction.FreightChoice.FR4, this::calcFreightCost4));
        freightFunctions.add(new FreightFunction(FreightFunction.FreightChoice.FR5, this::calcFreightCost5));
        freightFunctions.add(new FreightFunction(FreightFunction.FreightChoice.FR6, this::calcFreightCost6));
    }

    public List<InvoiceFunction> getInvoiceFunctions() {
        return invoiceFunctions;
    }

    public List<ShippingFunction> getShippingFunctions() {
        return shippingFunctions;
    }

    public List<FreightFunction> getFreightFunctions() {
        return freightFunctions;
    }

    // Define functional methods here
    private Invoice calcInvoice1(Order order) {
        Invoice invoice = new Invoice();
        invoice.setCost(order.getCost() * 1.1);
        return invoice;
    }
    private Invoice calcInvoice2(Order order) {
        Invoice invoice = new Invoice();
        invoice.setCost(order.getCost() *  2.2);
        return invoice;
    }
    private Invoice calcInvoice3(Order order) {
        Invoice invoice = new Invoice();
        invoice.setCost(order.getCost() * 4.4);
        return invoice;}
    private Invoice calcInvoice4(Order order) {

        Invoice invoice = new Invoice();
        invoice.setCost(order.getCost() * 8.8);
        return invoice;
    }
    private Invoice calcInvoice5(Order order) {
        Invoice invoice = new Invoice();
        invoice.setCost(order.getCost() * 10);
        return invoice;
    }

    private Shipping calcShipping1(Invoice invoice) {
        Shipping s = new Shipping();
        s.setShipperID(  (invoice.getCost() > 1000) ? 1 : 2);
        //s.setCost(invoice.getCost());

        return s;
    }
    private Shipping calcShipping2(Invoice invoice) {
        Shipping s = new Shipping();
        s.setShipperID(  (invoice.getCost() > 2000) ? 1 : 2);
        //s.setCost(invoice.getCost());

        return s;
    }
    private Shipping calcShipping3(Invoice invoice) {  Shipping s = new Shipping();
        s.setShipperID(  (invoice.getCost() > 3000) ? 2 : 3);
        //s.setCost(invoice.getCost());

        return s;}

    private Freight calcFreightCost1(Shipping shipping) {

        Freight f = new Freight();
        f.setCost( (shipping.getShipperID() == 1) ? shipping.getCost() * 0.25 : shipping.getCost() * 0.5);
        return f;
    }
    private Freight calcFreightCost2(Shipping shipping) {
        Freight f = new Freight();
        f.setCost( (shipping.getShipperID() == 1) ? shipping.getCost() * 0.30 : shipping.getCost() * 0.5);
        return f;
    }
    private Freight calcFreightCost3(Shipping shipping) {
        Freight f = new Freight();
        f.setCost( (shipping.getShipperID() == 1) ? shipping.getCost() * 0.40 : shipping.getCost() * 0.5);
        return f;
    }
    private Freight calcFreightCost4(Shipping shipping) {
        Freight f = new Freight();
        f.setCost( (shipping.getShipperID() == 1) ? shipping.getCost() * 0.60 : shipping.getCost() * 0.5);
        return f;
    }
    private Freight calcFreightCost5(Shipping shipping) {
        Freight f = new Freight();
        f.setCost( (shipping.getShipperID() == 1) ? shipping.getCost() * 0.90 : shipping.getCost() * 0.5);
        return f;
    }
    private Freight calcFreightCost6(Shipping shipping) {
        Freight f = new Freight();
        f.setCost( (shipping.getShipperID() == 1) ? shipping.getCost() * 0.95 : shipping.getCost() * 0.5);
        return f;
    }
}
