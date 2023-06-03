package main.java.javatask.adds.threads.thread_book;

public class UseMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thrd;
        thrd = Thread.currentThread();

        System.out.println(thrd.getName());
        System.out.println(thrd.getPriority());

        thrd.join();

    }
}
