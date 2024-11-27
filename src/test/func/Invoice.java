package test.func;

public class Invoice {
        private  OrderType type = null;
        private  double value = 0;

    public Invoice() {
    }

    public Invoice(OrderType type, double value) {
            this.type = type;
            this.value = value;
        }

        public OrderType getType() {
            return type;
        }

        public double getValue() {
            return value;
        }

        // Enum for test.func.Order Types
        public enum OrderType {
            REGULAR, PREMIUM, VIP
        }
    }