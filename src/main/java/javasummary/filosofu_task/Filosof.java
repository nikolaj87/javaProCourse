package javasummary.filosofu_task;

public class Filosof implements Runnable {

    private final Fork left;
    private final Fork right;

    public Filosof(Fork left, Fork right) {
        this.left = left;
        this.right = right;
        Thread thrd = new Thread(this);
        thrd.start();
    }


    @Override
    public void run() {
        while (true) {
            try {
//                Thread.sleep((long) (Math.random() * 1000));
                synchronized (left) {
                    synchronized (right) {
                        eat();
                        right.notify();
                        left.notify();
                    }
                    left.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void eat() {
        System.out.println(Thread.currentThread().getName() + " поднял 2 вилки и могу поесть ");
    }
}
