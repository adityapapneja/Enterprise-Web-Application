package food.model;

import food.service.Discountable;

public abstract class FoodOrder implements Discountable {
    private String orderId;
    private String customerName;
    private double amount;
    private static String restaurantName = "Tasty Bites Hub";
    private static int orderCount = 0;

    public FoodOrder(String orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        orderCount++;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static String getRestaurantName() {
        return restaurantName;
    }

    public static void setRestaurantName(String name) {
        restaurantName = name;
    }

    public static int getTotalOrders() {
        return orderCount;
    }

    public static void displayTotalOrders() {
        System.out.println("Total Orders Placed: " + orderCount);
    }

    public abstract double calculateDeliveryCharge();

    public double calculateFinalAmount() {
        return amount - applyDiscount() + calculateDeliveryCharge();
    }
}