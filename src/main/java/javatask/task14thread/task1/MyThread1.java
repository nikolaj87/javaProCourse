package main.java.javatask.task14thread.task1;

public class MyThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
    }
}
