package javatask.task15_plant_shop_materils;

import lombok.SneakyThrows;

public class Process {
    public static void main(String[] args) {

        Manager manager = new Manager();

        manager.setCurrent(Actions.PARTS);

        Thread t2 = new Thread(new Shop(manager));
        Thread t3 = new Thread(new Parts(manager));
        Thread t1 = new Thread(new Factory(manager));

        t1.start();
        t2.start();
        t3.start();

    }
}

class Manager {
    private volatile Actions current;

    public Actions getCurrent() {
        return current;
    }

    public void setCurrent(Actions current) {
        this.current = current;
    }
}


enum Actions {
    SHOP,
    PARTS,
    FACTORY
}


class Parts implements Runnable {

    final Manager manager;

    public Parts(Manager manager) {
        this.manager = manager;
    }

//ЗАПЧАСТИ
    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(11);

        synchronized (manager) {
            while (true) {

                Thread.sleep(2222);

                if (manager.getCurrent() != Actions.SHOP)
                    manager.wait();

                manager.setCurrent(Actions.PARTS);
                work();
                manager.notifyAll();

                manager.wait();
            }
        }
    }

    private void work() {
        System.out.println("3 получили 10 тыш --- производим запчасти --- передаем на сборку");
    }
}


class Shop implements Runnable {

    final Manager manager;

    public Shop(Manager manager) {
        this.manager = manager;
    }

    //МАГАЗИН
    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(11);
        synchronized (manager) {
            while (true) {

                Thread.sleep(2222);

                if (manager.getCurrent() != Actions.FACTORY) manager.wait();

                manager.setCurrent(Actions.SHOP);
                work();
                manager.notifyAll();

                manager.wait();
            }
        }
    }

    private void work() {
        System.out.println("2 магазин получил авто --- продаем авто --- 10тыш направляем на запчасти");
    }
}


class Factory implements Runnable {

    final Manager manager;

    public Factory(Manager manager) {
        this.manager = manager;
    }
    //СБОРКА АВТО
    @SneakyThrows
    @Override
    public void run() {
        synchronized (manager) {
            while (true) {

                Thread.sleep(2222);

                if (manager.getCurrent() != Actions.PARTS)
                    manager.wait();

                manager.setCurrent(Actions.FACTORY);
                work();
                manager.notifyAll();

                manager.wait();

            }
        }
    }

    public void work() {
        System.out.println("1 сборка поучила 1000 запчастей --- собираем авто --- передаем авто в магазин");
    }

}


