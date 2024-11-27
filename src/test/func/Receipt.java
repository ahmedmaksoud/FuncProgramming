package test.func;

public class Receipt {
        private  OrderType type = null;
        private  double value = 100000d;

        public Receipt(OrderType type, double value) {
            this.type = type;
            this.value = value;
        }

    public Receipt() {
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