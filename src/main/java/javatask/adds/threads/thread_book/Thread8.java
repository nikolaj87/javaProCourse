package main.java.javatask.adds.threads.thread_book;

class Thread8 implements Runnable {
    Thread thrd;
    Obj obj;

    public Thread8(Obj obj, String name) {
        this.thrd = new Thread(this, name);
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            obj.print(thrd.getName(), i);
        }
    }
}


class Obj {
    public synchronized void print(String name, int i) {

        if (i == 5) {
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        System.out.println(name);


//        try {
//            wait();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }
}


class Demo2 {
    public static void main(String[] args) {
        Obj o = new Obj();
        Thread8 th1 = new Thread8(o, "first");
        Thread8 th2 = new Thread8(o, "second");
        th1.thrd.start();
        th2.thrd.start();

        try {
            th1.thrd.join();
            th2.thrd.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
