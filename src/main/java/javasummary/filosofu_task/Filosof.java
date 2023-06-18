package javasummary.filosofu_task;

public class Filosof implements Runnable{

    private final Thread thrd;
    private final Fork left;
    private final Fork right;

    public Filosof(Fork left, Fork right) {
        this.left = left;
        this.right = right;
        this.thrd = new Thread(this);
    }


    public Thread getThrd() {
        return thrd;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 100));
                synchronized (left) {
//                    System.out.println(Thread.currentThread().getName() +
//                            "взял левую вилку");
                    synchronized (right) {
//                        System.out.println(Thread.currentThread().getName() +
//                                "взял правую вилку");
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


    public void eat(){
        System.out.println(Thread.currentThread().getName() + " поднял 2 вилки и могу поесть ");
        try {
            Thread.sleep(333);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void think(){

    }

}
