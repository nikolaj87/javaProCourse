package main.java.javatask.adds.threads.thread_book;

public class Thread9 implements Runnable {
    volatile boolean b = true;

    @Override
    public void run() {
        int counter = 0;
        while (b) {
            counter++;
        }
        System.out.println(counter);
    }


    public static void main(String[] args) throws InterruptedException {
        Thread9 thrd = new Thread9();
        Thread th = new Thread(thrd);
        th.start();

        Thread.sleep(500);
        System.out.println("sleep 0.5");

        thrd.b = false;

        th.join();
        System.out.println("end");
    }
}


