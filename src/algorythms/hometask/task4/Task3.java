//package algorythms.hometask.task4;
//
//import java.util.Random;
//
//public class Task3 {
//
//    public static void main(String[] args) {
//
////        Task 3. Найдите пиковый элемент в двумерном массиве
////        Элемент является пиковым, если он больше или равен своим четырем соседям слева, справа,
////        сверху и снизу. Например, соседями для A[i][j] являются A[i-1][j], A[i+1][j], A[i][j-1] и A[i][j+1].
////        Для угловых элементов отсутствующие соседи считаются отрицательными бесконечными значениями.
//
//        int size = 5;
//        System.out.println("дан следуюший массив: ");
//        int[][] array = fillArr(size);
//
//        xtreameAnalizer(array);
//    }
//
//    private static int[][] fillArr(int size) {
//
//        int[][] arr = new int[size][size];
//        Random random = new Random();
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                arr[i][j] = random.nextInt(10, 99);
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//        return arr;
//    }
//
//    private static void xtreameAnalizer(int[][] arr) {
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                check(i, j, arr);
//            }
//        }
//    }
//
//// напишем цикл фор который будет срезать крайние запросы при обрашениии к боковым или угловым
//// элементам. Тaкже он будет проверять является ли число больше, чем его соседи. Если число
//// находится в углу или сбоку то цикл срежет не сушествуюшие запросы чтобы не обрашаться
//// к несушествуюшим индексам.
//    private static boolean check(int i, int j, int[][] arr) {
//        int top = arr[i][j];
//        for (int k = i - 1; k <= i + 1; k++) {
//            if (k < 0 || k == arr.length) continue;
//
//            for (int l = j - 1; l <= j + 1; l++) {
//                if ((l < 0 || l == arr.length) ||
//                     (k == i - 1 && l == j - 1) ||
//                       (k == i + 1 && l == j - 1) ||
//                         (k == i - 1 && l == j + 1) ||
//                           (k == i + 1 && l == j + 1))
//                    continue;
//                if (top < arr[k][l])
//                    return false;
//            }
//        }
//        System.out.println("элемент [" + i + "][" + j + "] " + top + " является пиковым");
//        return true;
//    }
//}
