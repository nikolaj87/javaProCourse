package main.java.javatask.adds.threads.thread_book;

class MyThread2 implements Runnable {
    Thread thrd;


    MyThread2(String name) {
        thrd = new Thread(this, name);
    }


    public static MyThread2 createAndStart(String name) {
        MyThread2 myThrd = new MyThread2(name);
        myThrd.thrd.start();
        return myThrd;
    }


    @Override
    public void run() {
        System.out.println(thrd.getName() + " - запуск.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("В " + thrd.getName() + ", : " + count);
            }
        } catch (InterruptedException exc) {
            System.out.println(thrd.getName() + " - прерван.");
        }
        System.out.println(thrd.getName() + " - завершение.");
    }
}

class JoinThreads {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока.");

        MyThread2 mt1 = MyThread2.createAndStart("Порожденный поток 1");
        MyThread2 mt2 = MyThread2.createAndStart("Порожденный поток 2");
        MyThread2 mt3 = MyThread2.createAndStart("Порожденный поток 3");
        System.out.println("TYT" + mt1.thrd.getPriority());
        try {
            mt1.thrd.join();
            System.out.println("1 joined");
            mt2.thrd.join();
            System.out.println("2 joined");
            mt3.thrd.join();
            System.out.println("3 joined");
        } catch (InterruptedException e) {
            System.out.println("прерывание основного потока.");
        }
        System.out.println("Завершение основного потока.");
    }
}
