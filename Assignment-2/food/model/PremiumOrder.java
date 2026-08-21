package food.model;

public class PremiumOrder extends FoodOrder {

    public PremiumOrder(String orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    @Override
    public double calculateDeliveryCharge() {
        return 50.0;
    }

    @Override
    public double applyDiscount() {
        return getAmount() * 0.15;
    }
}