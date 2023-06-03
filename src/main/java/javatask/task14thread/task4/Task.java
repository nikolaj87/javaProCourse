package main.java.javatask.task14thread.task4;

class Task {

    public static void main(String[] args) {
//    Создайте 4 потока, которые выводят сообщение "Hello, World!" каждый с задержкой в 1 секунду.
//    Каждый поток должен использовать метод run() для вывода сообщения.
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello, World!");
        };

        Thread th1 = new Thread(r);
        Thread th2 = new Thread(r);
        Thread th3 = new Thread(r);
        Thread th4 = new Thread(r);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
