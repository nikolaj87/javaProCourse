package main.java.javatask.task13.task2;

public class Task2 {

    //    Напишите программу, которая находит наибольшую общую подматрицу,
//    состоящую только из нулей, в двумерном массиве.
    public static void main(String[] args) {


        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        task2(matrix);
    }

    private static void task2(int[][] matrix) {
        int maxSize = 0;
        int temp;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp = check(i, j, matrix);
                if (maxSize < temp) maxSize = temp;
            }
        }
        System.out.println("==============================================");
        System.out.println("количество нолей в наибольшей матрице: " + maxSize);

    }

    private static int check(int i, int j, int[][] arr) {
        int down = i;
        int right = j;

        while (true) {
            if (right == arr[0].length - 1 || down == arr.length - 1) break;
            if (arr[i][right + 1] == 0 && arr[down + 1][j] == 0) {
                right++;
                down++;
            } else break;
        }


        while (!isZeroMatrix(i, j, down, right, arr)) {
            down--;
            right--;
        }

        int temp = (down - i + 1) * (right - j + 1);
        if (down > i) {
            System.out.println("-------------------------------");
            System.out.println("найдена матрица: ");
            System.out.println("левый верхний угол: "+ i + " " + j);
            System.out.println("правый нижний угол: " + down + " " + right);
            System.out.println("количество нолей = " + temp);
        }
        return temp;
    }

    private static boolean isZeroMatrix(int i, int j, int down, int right, int[][] arr) {
        for (int k = i; k <= down; k++) {
            for (int l = j; l <= right; l++) {
                if (arr[k][l] == 1) return false;
            }
        }
        return true;
    }

}
