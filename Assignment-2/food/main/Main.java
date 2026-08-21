package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.utility.OrderUtility;

public class Main {
    public static void main(String[] args) {
        FoodOrder[] orders = new FoodOrder[6];

        String[] ids = {"ORD101", "ORD102", "ORD103", "ORD104", "ORD105", "ORD106"};
        String[] names = {"Aarav Sharma", "Diya Patel", "Rohan Gupta", "Priya Singh", "Karan Verma", "Ananya Roy"};
        double[] amounts = {450.0, 1200.0, 300.0, 850.0, 1500.0, 600.0};
        boolean[] isPremium = {false, true, false, true, true, false};

        for (int i = 0; i < orders.length; i++) {
            if (OrderUtility.validateCustomerName(names[i]) && OrderUtility.validateAmount(amounts[i])) {
                if (isPremium[i]) {
                    orders[i] = new PremiumOrder(ids[i], names[i], amounts[i]);
                } else {
                    orders[i] = new RegularOrder(ids[i], names[i], amounts[i]);
                }
            }
        }

        System.out.println("================ ALL ORDERS BILL SUMMARY ================");
        for (FoodOrder order : orders) {
            if (order != null) {
                OrderUtility.generateOrderSummary(order);
            }
        }

        System.out.println();
        FoodOrder.displayTotalOrders();
    }
}