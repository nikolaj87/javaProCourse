public class Shop implements Runnable{
    private Delivery delivery;

    public Shop(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public void run() {
        synchronized (delivery){
            for (int i = 0; i < 10; i++) {
                while (delivery.getFactory().getProductCount() > 0 ){
                    try {
                        delivery.wait(); // Засыпаем, пока в магазине есть продукты
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("после продажи остаток продукта - " + (delivery.getFactory().getProductCount()-1));

                System.out.println("Магазин продал продукты");
                delivery.notify();
            }
        }
    }
}