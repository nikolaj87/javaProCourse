package javamain.threads.semaph;

import java.util.concurrent.Semaphore;

class CommonResources {
    private int x = 0;

    Semaphore semaphore = new Semaphore(2);

    public void incr() {
        try {
            semaphore.acquire(1);
            x++;
            System.out.println(Thread.currentThread().getName() + " is working");

            Thread.sleep(2000);
            semaphore.release(1);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



class Go implements Runnable {
    private final CommonResources cr;

    public Go(CommonResources cr) {
        this.cr = cr;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            cr.incr();
        }
    }
}

class Demo2 {
    public static void main(String[] args) {

        CommonResources cr = new CommonResources();

        new Thread(new Go(cr)).start();
        new Thread(new Go(cr)).start();
        new Thread(new Go(cr)).start();

    }
}
