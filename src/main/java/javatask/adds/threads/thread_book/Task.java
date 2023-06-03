package main.java.javatask.adds.threads.thread_book;

class MyThread implements Runnable {
    Thread thrd;


    MyThread(String name) {
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

class ThreadVariations {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока.");

        MyThread2 mt1 = MyThread2.createAndStart("Порожденный поток 1");
        MyThread2 mt2 = MyThread2.createAndStart("Порожденный поток 2");
        MyThread2 mt3 = MyThread2.createAndStart("Порожденный поток 3");

        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Прерывание основного потока");
            }
        } while (mt1.thrd.isAlive() ||
                mt2.thrd.isAlive() ||
                mt3.thrd.isAlive());

//            for (int i = 0; i < 50; i++) {
//            System.out.print(".");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException exc) {
//                System.out.println("Прерывание основного потока.");
//            }
//        }
        System.out.println("Завершение основного потока.");
    }
}
