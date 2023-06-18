

public class Delivery implements Runnable {
    private Factory factory;

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Delivery(Factory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        synchronized (factory) {
            System.out.println("Доставка привезла продукты в магазин ,количество продукта -" + factory.getProductCount());

            for (int i = 0; i < 10; i++) {
                while (factory.getProductCount() == 0) {
                    try {
                        factory.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int productCount = factory.getProductCount();
                factory.setProductCount(productCount - 1);
                factory.notify();
            }
        }
    }
}