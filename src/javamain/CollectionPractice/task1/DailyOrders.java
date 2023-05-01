package javamain.CollectionPractice.task1;

import java.util.LinkedList;
import java.util.List;

public class DailyOrders {

    private List<Order> orders = new LinkedList<>();


    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder (Order order) {
        orders.add(order);
    }

    public void removeOrder (Order order) {
        if (orders.contains(order))
            orders.remove(order);
        else
            System.out.println("no such order");
    }
    public double totalPrice () {
        double sum = 0;
        for (Order o : orders) {
            sum += o.getPrice() * o.getQuantity();
        }
        return sum;
    }
    public Order findOrderById (int id) {
        Order order = new Order(id,"",0,0);
        for (Order o : orders) {
            if (o.getId() == id) return o;
        }
        return order;
    }
}
