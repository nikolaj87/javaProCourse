package main.java.javatask.task14thread.task3;

class Task {
    public static void main(String[] args) {
//    Создайте 2 потока, которые выводят все четные числа от 1 до 20 и все нечетные числа от 1 до
//    20 соответственно. Каждый поток должен использовать метод run() для вывода чисел.

        Thread th1 = new Thread(() -> {
            for (int i = 1; i < 21; i += 2) System.out.println(i);
        });
        Thread th2 = new Thread(() -> {
            for (int i = 2; i < 21; i += 2) System.out.println(i);
        });

        th1.start();
        th2.start();
    }
}
