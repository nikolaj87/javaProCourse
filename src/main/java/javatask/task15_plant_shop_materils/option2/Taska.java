//package javatask.task15_plant_shop_materils.option2;
//
//import java.util.Random;
//
//public class Taska {
//    //решим задачку Михаила то попроще исспользуя знания получинные на задачку с философами
//    //зациклим операцию с помощью 2 обьектов синхронизации
//    public static void main(String[] args) throws Exception {
//
//        Object lock1 = new Object();
//        Object lock2 = new Object();
//        Object lock3 = new Object();
//
//        Shop shop = new Shop(lock1, lock2);
//        Factory factory = new Factory(lock2, lock3);
//        Part part = new Part(lock3, lock1);
//
//
//    }
//
//
//}
//<<<<<<< HEAD

//===============================================================================
//class Shop implements Runnable {
//=======
////===============================================================================
//class Shop implements Runnable{
//>>>>>>> origin/master
//    private final Object o1;
//    private final Object o2;
//    private final Thread thrd;
//
//    public Shop(Object o1, Object o2) {
//        this.o1 = o1;
//        this.o2 = o2;
//        this.thrd = new Thread(this);
//        thrd.start();
//    }
//
//    public Thread getThrd() {
//        return thrd;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(444);
//
//                synchronized (o1) {
//                    synchronized (o2) {
//
//                        work();
//
//                        o1.notify();
//                        o2.notify();
//                    }
//                    o1.wait();
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private void work() throws InterruptedException {
//        System.out.println(" shop");
//        Thread.sleep(1111);
//    }
//}
//
////===============================================================================
//<<<<<<< HEAD
//class Part implements Runnable {
//=======
//class Part implements Runnable{
//>>>>>>> origin/master
//    private final Object o1;
//    private final Object o2;
//    private final Thread thrd;
//
//    public Part(Object o1, Object o2) {
//        this.o1 = o1;
//        this.o2 = o2;
//        this.thrd = new Thread(this);
//        thrd.start();
//    }
//
//    public Thread getThrd() {
//        return thrd;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(0);
//
//                synchronized (o1) {
//                    synchronized (o2) {
//
//                        work();
//
//                        o1.notify();
//                        o2.notify();
//                    }
//                    o1.wait();
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//<<<<<<< HEAD
//
//=======
//>>>>>>> origin/master
//    private void work() throws InterruptedException {
//        System.out.println(" part");
//        Thread.sleep(1111);
//    }
//
//}
//
////===============================================================================
//<<<<<<< HEAD
//class Factory implements Runnable {
//=======
//class Factory implements Runnable{
//>>>>>>> origin/master
//    private final Object o1;
//    private final Object o2;
//    private final Thread thrd;
//
//    public Factory(Object o1, Object o2) {
//        this.o1 = o1;
//        this.o2 = o2;
//        this.thrd = new Thread(this);
//        thrd.start();
//    }
//
//    public Thread getThrd() {
//        return thrd;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(111);
//
//                synchronized (o1) {
//                    synchronized (o2) {
//
//                        work();
//
//                        o1.notify();
//                        o2.notify();
//                    }
//                    o1.wait();
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private void work() throws InterruptedException {
//        System.out.println(" factory");
//        Thread.sleep(1111);
//    }
//}
//


