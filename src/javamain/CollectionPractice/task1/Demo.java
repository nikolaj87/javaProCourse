package javamain.CollectionPractice.task1;

public class Demo {
    public static void main(String[] args) {

        DailyOrders o = new DailyOrders();
        Order order1 = new Order("pizza", 2, 10.5);
        o.addOrder(order1);
        Order order2 = new Order("sushi", 1, 15.25);
        o.addOrder(order2);
        Order order3 = new Order("juice", 3, 5);
        o.addOrder(order3);
        Order order4 = new Order("juice", 1, 5);
        o.addOrder(order4);

        System.out.println(o.getOrders());

        o.removeOrder(order4);

        System.out.println(o.getOrders());

        System.out.println( "общая стоимость = " +
                o.totalPrice()
        );
        System.out.println( "заказ по ид = " +
                o.findOrderById(5703)
        );
    }
}
