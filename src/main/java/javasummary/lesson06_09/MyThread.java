package javasummary.lesson06_09;

public class MyThread implements Runnable{

    private final int start;
    private final int finish;
    private final int n;
    private int counter;
    private final Thread thrd;

    public MyThread(int start, int finish, int n) {
        this.start = start;
        this.finish = finish;
        this.n = n;
        this.thrd = new Thread(this);
    }

    public int getCounter() {
        return counter;
    }
    public Thread getThrd() {
        return thrd;
    }

    public static MyThread createAndStart(int start, int finish, int n) {
        MyThread m = new MyThread(start, finish, n);
        m.thrd.start();
        return m;
    }

    @Override
    public void run() {
        for (int i = start; i < finish; i++) {
            if (i % n == 0) counter++;
        }
    }
}
