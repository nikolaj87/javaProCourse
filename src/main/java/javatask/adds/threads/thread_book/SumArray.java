package main.java.javatask.adds.threads.thread_book;

class SumArray {
    private int sum;

    int sumArray(int[] nums) {
        sum = 0; // обнуление суммы

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("Текущее значение суммы для "
                    + Thread.currentThread().getName() + " будет " + sum);
            try {
                Thread.sleep(10); // разрешение переключения
                // между задачами
            } catch (InterruptedException exc) {
                System.out.println("Поток прерван.");
            }
        }
        return sum;
    }
}

class MyThread4 implements Runnable {
    Thread thrd;
    static SumArray sa = new SumArray();
    int[] a;
    int answer;

    // Конструктор нового потока
    MyThread4(String name, int[] nums) {
        thrd = new Thread(this, name);
        a = nums;
    }

    // Создание и запуск потока с помощью фабричного метода
    public static MyThread4 createAndStart(String name, int[] nums) {
        MyThread4 myThrd = new MyThread4(name, nums);

        myThrd.thrd.start(); // запуск потока
        return myThrd;
    }

    // Точка входа для потока
    public void run() {
        int sum;

        System.out.println(thrd.getName() + " - запуск.");

        answer = sa.sumArray(a);
        System.out.println("Сумма для " + thrd.getName() + " будет " + answer);

        System.out.println(thrd.getName() + " - завершение.");
    }
}

class Sync {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        MyThread4 mtl = MyThread4.createAndStart("Порожденный поток #1", a);

        MyThread4 mt2 = MyThread4.createAndStart("Порожденный поток #2", a);
        try {
            mtl.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Прерывание основного потока.");
        }
    }
}