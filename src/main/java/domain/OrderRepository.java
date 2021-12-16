package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OrderRepository {
    private static List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void resetSpecificTable(int tableNumber) {
        Iterator<Order> ordersItr = orders.iterator();

        while (ordersItr.hasNext()) {
            Order order = ordersItr.next();

            if(order.getTableNumber() ==  tableNumber) {
                ordersItr.remove();
            }
        }
    }

    public boolean hasThisTableOrder(int tableNumber) {
        for (Order order : orders) {
            if (order.getTableNumber() == tableNumber) {
                return true;
            }
        }
        return false;
    }

    public int getTotalPayment(int tableNumber) {
        int sum = 0;

        for (Order order : orders) {
            if (order.getTableNumber() == tableNumber) {
                sum += order.getTotalPrice();
            }
        }
        return sum;
    }

    public int countChicken() {
        int count = 0;
        for (Order order : orders) {
            if (order.isChicken()) {
                count += order.getQuantity();
            }
        }
        return count;
    }

    public List<Order> orderedMenus() {
        return Collections.unmodifiableList(orders);
    }
}
