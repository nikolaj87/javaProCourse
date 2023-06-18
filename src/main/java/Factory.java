

public class Factory implements Runnable{
    private int productCount = 0;

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                while (productCount >= 10) {
                    try {
                        wait(); // Засыпаем, если достигнут предел продуктов
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                productCount++;
                System.out.println("Завод изготовил продукт ,количество продукта -" + productCount);
            }
        }
    }
}