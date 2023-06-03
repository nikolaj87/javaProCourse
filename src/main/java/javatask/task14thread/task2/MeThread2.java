package main.java.javatask.task14thread.task2;

class MeThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i*i);
        }
    }
}
