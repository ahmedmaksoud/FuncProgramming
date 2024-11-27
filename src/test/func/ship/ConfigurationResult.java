package test.func.ship;

import test.func.ship.dtos.Order;

public class ConfigurationResult {
    private Order order;
    private ProcessConfiguration processConfiguration;

    public ConfigurationResult(Order order, ProcessConfiguration processConfiguration) {
        this.order = order;
        this.processConfiguration = processConfiguration;
    }

    public Order getOrder() {
        return order;
    }

    public ProcessConfiguration getProcessConfiguration() {
        return processConfiguration;
    }
}
