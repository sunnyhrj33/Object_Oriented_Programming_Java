package OnlineFoodOrdering;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


    public class Order {
        private static int orderId;
        private Customer customer;
        private List<FoodItem> orderedItems;
        private List<Integer> quantity;
        private double totalPrice;
        private String orderStatus;
        int index;

        public Order(Customer customer, List<FoodItem> orderedItems,List<Integer> quantity, double totalPrice, String orderStatus) {
            this.orderId = index++;
            this.customer = customer;
            this.orderedItems = orderedItems;
            this.quantity= quantity;
            this.totalPrice = totalPrice;
            this.orderStatus = orderStatus;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public List<FoodItem> getOrderedItems() {
            return orderedItems;
        }

        public void setOrderedItems(List<FoodItem> orderedItems) {
            this.orderedItems = orderedItems;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public List<Integer> getQuantity() {
            return quantity;
        }

        public void setQuantity(List<Integer> quantity) {
            this.quantity = quantity;
        }

        public void addItem(FoodItem item, int quantity) {
            orderedItems.add(item);
            this.quantity.add(quantity);
            calculateTotal();
        }

        public void removeItem(FoodItem item) {
            int itemIndex = orderedItems.indexOf(item);
            if (itemIndex != -1) {
                orderedItems.remove(itemIndex);
                quantity.remove(itemIndex);
                calculateTotal();
            }
        }
        /*public void removeItem(FoodItem item) {
            orderedItems.remove(item);
            calculateTotal();
        }*/


        public void calculateTotal() {
            totalPrice = 0;
            for (int i = 0; i < orderedItems.size(); i++) {
                totalPrice += orderedItems.get(i).getItemPrice() * quantity.get(i);
            }
        }

        @Override
        public String toString() {
            return "Order{" +
                    "customer=" + customer +
                    ", orderedItems=" + orderedItems +
                    ", quantity=" + quantity +
                    ", totalPrice=" + totalPrice +
                    ", orderStatus='" + orderStatus + '\'' +
                    ", index=" + index +
                    '}';
        }

        public void placeOrder() {
            orderStatus = "Placed";
        }
    }


