package javatask.task13.Task2;

import org.jetbrains.annotations.NotNull;

public class Task2 {

    //    Напишите программу, которая находит наибольшую общую подматрицу,
//    состоящую только из нулей, в двумерном массиве.
    public static void main(String[] args) {


        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println(matrix.length);
        task2(matrix, matrix.length - 1);
    }

    private static void task2(int[][] matrix, int size) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                check(i, j, matrix, size);
            }
        }
    }

    private static void check(int y, int x, int[][] arr, int n) {

        System.out.println(y + " " + x);

        boolean flag = true;

        if(y == arr.length - n || x == arr.length - n) return;
        for (int i = y; i <= y + n; i++) {
            for (int j = x; j <= x + n; j++) {

//                System.out.println("inside " + i + " " + j);
                if (arr[i][j] == 1) flag = false;
            }
        }
        System.out.println(y + " " + x + " " + flag);
        n++;
//        check(y,x, arr, n);
    }

}
