package main.java.javatask.adds.threads.thread_book;

// Использование методов wait() и notify() для имитации часов

class TickTock {

    String state; // содержит сведения о состоянии часов

    synchronized void tick(boolean running) {
        if (!running) { // остановить часы
            state = "ticked";
            notify(); // уведомить ожидающие потоки
            return;
        }

        System.out.print("Tick ");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        state = "ticked"; // установить текущее состояние
        // после такта "тик"
        notify();         //позволить выполняться методу tock()
        try {
            while (!state.equals("tocked"))
                wait();   // ожидать до завершения метода tock()
        } catch (InterruptedException exc) {
            System.out.println("Прерывание потока");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) { // остановить часы
            state = "tocked";
            notify(); // уведомить ожидающие потоки
            return;
        }

        System.out.println("Tock");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        state = "tocked";
        notify();
        try {
            while (!state.equals("ticked"))
                wait();
        } catch (InterruptedException exc) {
            System.out.println("Прерывание потока");
        }
    }
}


class MyThread5 implements Runnable {
    Thread thrd;
    TickTock ttOb;

    // Конструктор нового потока
    MyThread5(String name, TickTock tt) {
        thrd = new Thread(this, name);

        ttOb = tt;
    }

    // Создание и запуск потока с помощью фабричного метода
    public static MyThread5 createAndStart(String name, TickTock tt) {
        MyThread5 myThrd = new MyThread5(name, tt);

        myThrd.thrd.start(); // запуск потока
        return myThrd;
    }

    // Точка входа для потока
    public void run() {
        if (thrd.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 3; i++) {
                ttOb.tick(true);
            }
            ttOb.tick(false);
        } else {
            for (int i = 0; i < 3; i++) {
                ttOb.tock(true);
            }
            ttOb.tock(false);
        }
    }
}


class ThreadCom {
    public static void main(String args[]) {
        TickTock tt = new TickTock();
        MyThread5 mt1 = MyThread5.createAndStart("Tick", tt);
        MyThread5 mt2 = MyThread5.createAndStart("Tock", tt);


        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Прерывание основного потока");
        }
    }
}

