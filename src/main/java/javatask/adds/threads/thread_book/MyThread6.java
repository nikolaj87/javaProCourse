package main.java.javatask.adds.threads.thread_book;

class MyThread6 implements Runnable {

    Thread thrd;
    boolean suspended;
    boolean stopped;


    MyThread6(String name) {
        thrd = new Thread(this, name);
        suspended = false;
        stopped = false;
    }


    public static MyThread6 createAndStart(String name) {
        MyThread6 myThrd = new MyThread6(name);
        myThrd.thrd.start(); // запуск потока
        return myThrd;
    }


    public void run() {
        System.out.println(thrd.getName() + " - запуск.");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if ((i % 10) == 0) {
                    System.out.println();
                    Thread.sleep(250);
                }

                synchronized (this) {
                    while (suspended) wait();
                    if (stopped) break;
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thrd.getName() + " - прерван.");
        }
        System.out.println(thrd.getName() + " - выход.");
    }

    synchronized void mystop() {
        stopped = true;
        suspended = false;
        notify();
    }

    synchronized void mysuspend() {
        suspended = true;
    }

    synchronized void myresume() {
        suspended = false;
        notify();
    }
}

class Suspend {
    public static void main(String[] args) {
        MyThread6 mt1 = MyThread6.createAndStart("Мой поток");

        try {
            Thread.sleep(2000); // позволить потоку ob1 начать
                                        // выполнение
            mt1.mysuspend();
            System.out.println("Приостановка потока.");
            Thread.sleep(1000);

            mt1.myresume();
            System.out.println("Возобновление потока.");
            Thread.sleep(1000);

            mt1.mysuspend();
            System.out.println("Приостановка потока.");
            Thread.sleep(1000);

            mt1.myresume();
            System.out.println("Возобновление потока.");
            Thread.sleep(1000);

            mt1.mysuspend();
            System.out.println("Остановка потока.");
            mt1.mystop();
        } catch (InterruptedException e) {
            System.out.println("Прерывание основного потока ");
        }

        // Ожидание завершения потока
        try {
            mt1.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Прерывание основного потока ");
        }
        System.out.println("Выход из основного потока.");
    }

}

