package algorythms.hometask.task4;


public class Task1_2 {
    public static void main(String[] args) {
//            Task 1. Закончить итерационное решение задачи о Ханойских башнях.
     // сделано на прошлый дз.

//            Task 2. Даны два целых числа x и n, напишите функцию для вычисления x^n
//        решение 1 - рекурсивно O(n)
          System.out.println(function(2, 55));

//        решение 2 - улучшить решение 1 до O(log n)
//        кстати спасибо за задачу. Люблю когда приходится доставать карандаш и думать. Ато большинство задач Tel-Ran
//        решаются в момент прочтения. Так и не получилось рекурсивно сделать, но идея по улучшению алгоритма все же
//        появилась
          System.out.println(function2(2, 55));

//        System.out.println(functionRecurs(x));

//          System.out.println(function3(2, 55));
    }


     private static long function(int x, double n) {
         if (n == 0) return 1;
         return x * function(x, n - 1);
     }


    // идея метода состоит в сокрашении количества итераций.
    // например имеем n^125 тогда представим это как n^64 * n^32 * n^16 * n^2 * n
    // цикл n^64 потребует не 64 итерации а 6 итераций
    public static long function2 (long x, int n) {

        if (n == 0) return 1;
        long sum = 1;                      // вне цикла считает сумму
        long multiplier = x;
        int num = 1;
        int size = n;

        while (size > 0) {                 //внешний вайл образает размер степени
            while (num < size / 2) {       //внутренний вайл умножает число само на себя нужное кол-во раз
                multiplier *= multiplier ;
                num *= 2;
            }
            size = size - num;
            num = 1;                       //обнуляем счетчики
            sum = sum * multiplier;
            multiplier = x;
        }
        return sum;
    }

    public static void function3 (int x, int n) {
        while(true) {
           int multi = n/2;
        }
    }


//    рекурсивное решение для некоторых чисел выдает ошибку, но суть таже
//    static double num = 5;
//    static int counter = 1;
//    static int start = 2;
//
//    private static double functionRecurs(double x) {
//
//        if (num == 0) return 1;
//        if (num == 1 ) return start;
//        if (counter > num/2) {
//            num = num - counter;
//            counter = 1;
//            x = start;
//        }
//        counter *= 2;
//        return x * functionRecurs(x*x);
//    }






}

