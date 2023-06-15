package javatask.adds.threads.practice2;

import java.util.concurrent.Exchanger;

public class MyRnbl implements Runnable {

    private Thread thrd;
    private Exchanger<String> exchanger;
    volatile static boolean stop = false;


    public MyRnbl(Exchanger<String> exchanger) {
        this.thrd = new Thread(this);
        this.exchanger = exchanger;
    }

    public Thread getThrd() {
        return thrd;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " doing smth");
        try {
            if (Thread.currentThread().getName().equals("Thread-1")
                    || Thread.currentThread().getName().equals("Thread-0")) {
                Thread.sleep(1000);
            } else {
                Thread.sleep(1055);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            if (stop) Thread.currentThread().interrupt();

            System.out.println(Thread.currentThread().getName() +
                    "   " + exchanger.exchange(Thread.currentThread().getName()));
            stop = true;

            Thread.currentThread().interrupt();

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " stop ");
            return;
        }
        if (Thread.currentThread().isInterrupted())   return;


        System.out.println(Thread.currentThread().getName() + " doing smth");

    }
}
