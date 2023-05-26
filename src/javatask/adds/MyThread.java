package javatask.adds;

public class MyThread implements Runnable {
    String thrdName;

    public MyThread(String name) {
        thrdName = name;
    }

    @Override
    public void run() {
        System.out.println(thrdName + " start");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("B " + thrdName + ", счетчик: " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(thrdName + " - прерван");
        }
        System.out.println(thrdName + " - завершение");
    }
}

class UseThreads {
    public static void main(String[] args) {
        System.out.println("запуск основного потока");

        MyThread mt = new MyThread("порожденный обьект 1");
        Thread newThrd = new Thread(mt);


        newThrd.start();

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException exc) {
                System.out.println("прерывание основного потока");
            }
        }
        System.out.println("завершение основного потока");
    }
}
