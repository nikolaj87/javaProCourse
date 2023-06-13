package javasummary.lesson06_09;

public class ThreadHT {
    public static void main(String[] args) {
        int n = 3;
        long t = System.currentTimeMillis();
        System.out.println("numbers found " + countNumbers(n));
        System.out.println("time required INLINE " + (System.currentTimeMillis() - t));

        long t2 = System.currentTimeMillis();
        System.out.println("numbers found " + countNumbersParallel(n));
        System.out.println("time required PARALLEL " + (System.currentTimeMillis() - t2) +
                 " millis");
    }

//    Взять  пример расчетной задачи (см. слайды к занятию):  найти и посчитать все целые числа
//    в диапазоне от Integer.MIN_VALUE до Integer.MAX_VALUE, которые делятся на заданное целое
//    число без остатка. Решить данную задачу последовательно и параллельно в нескольких потоках.
//    Сравнить время выполнения.


    public static int countNumbers(int n) {

        int counter = 0;

        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            if (i % n == 0) counter++;
        }
        return counter;
    }


    public static int countNumbersParallel(int n) {

        MyThread th1 = MyThread.createAndStart(Integer.MIN_VALUE, Integer.MIN_VALUE/2, n);
        MyThread th2 = MyThread.createAndStart(Integer.MIN_VALUE/2, 0, n);
        MyThread th3 = MyThread.createAndStart(0, Integer.MAX_VALUE/2, n);
        MyThread th4 = MyThread.createAndStart(Integer.MAX_VALUE/2, Integer.MAX_VALUE, n);

        try {
            th1.getThrd().join();
            th2.getThrd().join();
            th3.getThrd().join();
            th4.getThrd().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return th1.getCounter() + th2.getCounter() + th3.getCounter() + th4.getCounter();
    }

}

