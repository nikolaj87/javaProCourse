package main.java.javatask.task14thread.task5;

class Thread5 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class Task {

    public static void main(String[] args) {

//    Создайте 3 потока, каждый из которых выводит свое имя 5 раз.
//    Каждый поток должен использовать метод run() для вывода имени.

        Thread th1 = new Thread(new Thread5(),"поток1");
        Thread th2 = new Thread(new Thread5(),"поток2");
        Thread th3 = new Thread(new Thread5(),"поток3");

        th1.start();
        th2.start();
        th3.start();

        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
