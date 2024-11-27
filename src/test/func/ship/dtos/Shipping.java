package test.func.ship.dtos;

public class Shipping {
        private double cost;
        private int shipperID;

        public Shipping() {
            cost = 0;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public int getShipperID() {
            return shipperID;
        }

        public void setShipperID(int shipperID) {
            this.shipperID = shipperID;
        }
    }