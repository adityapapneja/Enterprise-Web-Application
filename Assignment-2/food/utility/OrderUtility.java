package food.utility;

import food.model.FoodOrder;

public class OrderUtility {

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String customerName) {
        return customerName != null && !customerName.trim().isEmpty() && customerName.matches("^[a-zA-Z\\s]+$");
    }

    public static void generateOrderSummary(FoodOrder order) {
        System.out.println("----------------------------------------");
        System.out.println("Restaurant: " + FoodOrder.getRestaurantName());
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Order Type: " + order.getClass().getSimpleName());
        System.out.printf("Base Bill Amount: Rs. %.2f\n", order.getAmount());
        System.out.printf("Discount Applied: Rs. %.2f\n", order.applyDiscount());
        System.out.printf("Delivery Charge: Rs. %.2f\n", order.calculateDeliveryCharge());
        System.out.printf("Final Payable Amount: Rs. %.2f\n", order.calculateFinalAmount());
        System.out.println("----------------------------------------");
    }
}