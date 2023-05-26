package javatask.task14thread.task2;

class Task2 {
    //    Создайте 3 потока, которые вычисляют и выводят квадраты чисел от 1 до 10.
//    Каждый поток должен использовать метод run() для вычисления и вывода квадратов.
    public static void main(String[] args) {

        Thread th1 = new Thread(new MeThread2());
        Thread th2 = new Thread(new MeThread2());
        Thread th3 = new Thread(new MeThread2());

        th1.start();
        th2.start();
        th3.start();

    }
}
