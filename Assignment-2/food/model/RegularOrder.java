package food.model;

public class RegularOrder extends FoodOrder {

    public RegularOrder(String orderId, String customerName, double amount) {
        super(orderId, customerName, amount);
    }

    @Override
    public double calculateDeliveryCharge() {
        return 80.0;
    }

    @Override
    public double applyDiscount() {
        return getAmount() * 0.10;
    }
}