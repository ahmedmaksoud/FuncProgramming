package test.func.ship;

public class ProcessConfiguration {
    private InvoiceFunction.invoiceChoiceEnum invoiceChoice;
    private ShippingFunction.shippingChoiceEnum shippingChoice;
    private FreightFunction.FreightChoice freightChoice;
    private AvailabilityFunction.AvailabilityChoice availabilityChoice;
    private ShippingDateFunction.shippingDateChoiceEnum shippingDateChoice;

    public InvoiceFunction.invoiceChoiceEnum getInvoiceChoice() {
        return this.invoiceChoice;
    }

    public void setInvoiceChoice(InvoiceFunction.invoiceChoiceEnum invoiceChoice) {
        this.invoiceChoice = invoiceChoice;
    }

    public ShippingFunction.shippingChoiceEnum getShippingChoice() {
        return this.shippingChoice;
    }

    public void setShippingChoice(ShippingFunction.shippingChoiceEnum shippingChoice) {
        this.shippingChoice = shippingChoice;
    }

    public FreightFunction.FreightChoice getFreightChoice() {
        return this.freightChoice;
    }

    public void setFreightChoice(FreightFunction.FreightChoice freightChoice) {
        this.freightChoice = freightChoice;
    }

    public AvailabilityFunction.AvailabilityChoice getAvailabilityChoice() {
        return this.availabilityChoice;
    }

    public void setAvailabilityChoice(AvailabilityFunction.AvailabilityChoice availabilityChoice) {
        this.availabilityChoice = availabilityChoice;
    }

    public ShippingDateFunction.shippingDateChoiceEnum getShippingDateChoice() {
        return this.shippingDateChoice;
    }

    public void setShippingDateChoice(ShippingDateFunction.shippingDateChoiceEnum shippingDateChoice) {
        this.shippingDateChoice = shippingDateChoice;
    }
}