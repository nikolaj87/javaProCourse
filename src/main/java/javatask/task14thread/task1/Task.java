package main.java.javatask.task14thread.task1;

class Task {
    public static void main(String[] args) {
//    Создайте 5 потоков, которые выводят числа от 1 до 10. Каждый поток
//    должен использовать метод run() для вывода чисел.
        task1();

    }

    private static void task1() {
        Thread th1 = new Thread(() -> {
            for (int i = 1; i < 11; i++) System.out.println(i);
        });

        Thread th2 = new Thread(new MyThread1());
        Thread th3 = new Thread(new MyThread1());
        Thread th4 = new Thread(new MyThread1());
        Thread th5 = new Thread(new MyThread1());

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();
    }
}
