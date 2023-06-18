

public class myApp {
    public static void main(String[] args) {

        Factory factory = new Factory();
        Delivery delivery = new Delivery(factory);
        Shop shop = new Shop(delivery);

        new Thread(factory).start();
        new Thread(delivery).start();
        new Thread(shop).start();

    }
}