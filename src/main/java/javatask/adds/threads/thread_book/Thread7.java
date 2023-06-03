package main.java.javatask.adds.threads.thread_book;


class Thread7 implements Runnable {
    Thread thrd;
    DoSmth doSmth;

    public Thread7(String name, DoSmth obj) {
        thrd = new Thread(this, name);
        doSmth = obj;
    }
    public static Thread7 createAndStart(String name, DoSmth doSmth) {
        Thread7 t = new Thread7(name, doSmth);
        t.thrd.start();
        return t;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            doSmth.print(thrd.getName(), true);
        }
        doSmth.print(thrd.getName(), false);
    }
}


class DoSmth {

    public DoSmth() {}

    public synchronized void print(String name, boolean fl) {
        if(!fl) {
            notify();
            return;
        }
        System.out.println(name);

        notify();
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


class Demo {
    public static void main(String[] args) {
        DoSmth doSmth = new DoSmth();
        Thread7 th1 = Thread7.createAndStart("first", doSmth);
        Thread7 th2 = Thread7.createAndStart("second", doSmth);
        try {
            th1.thrd.join();
            th2.thrd.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



