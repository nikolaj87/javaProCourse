package javamain.threads.exchanger;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class Truck implements Runnable{
    private int truckNumber;
    private String startPoint;
    private String endPoint;
    private List<String> goods;

    private Exchanger<List<String>> exchanger;

    public Truck(int truckNumber, String startPoint, String endPoint, List<String> goods, Exchanger<List<String>> exchanger) {
        this.truckNumber = truckNumber;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.goods = goods;
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        System.out.println("Truck " + truckNumber + " is loading with goods: " + goods);
        System.out.println("Truck " + truckNumber + " starts from " + startPoint + " to " + endPoint);
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(4000) + 2000); // в дороге

            // грузовики достигли точки обмена грузом и производят обмен товаром
            System.out.println("Truck " + truckNumber + " arrives at point E for goods exchange");
            String temp = goods.get(1);
            goods = exchanger.exchange(goods);

            goods.remove(1);
            goods.add(temp);
            System.out.println("Truck " + truckNumber + " exchanged goods at point E. Received goods: " + goods);
            Thread.sleep(2000);
            System.out.println("Truck " + truckNumber + " arrives at " + endPoint + " and delivers goods " + goods);
        } catch (InterruptedException e ) {}
    }
}
