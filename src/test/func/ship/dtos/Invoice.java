package test.func.ship.dtos;

public class Invoice {
        private double cost;

        public Invoice() {
            cost = 0;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }
    }