package main.java.javatask.task13.task4;

class Task {

    public static void main(String[] args) {

//        Напишите программу, которая находит наименьший путь от верхнего левого угла
//        до нижнего правого угла в двумерном массиве. Каждая ячейка содержит стоимость прохода.

        int[][] grid = {
                {1, 3, 1, 2},
                {1, 5, 1, 2},
                {4, 2, 3, 4}
        };
        findWay(grid);
    }

    public static void findWay(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) arr[i][j] += arr[i][j - 1];
                else if (j == 0) arr[i][j] += arr[i - 1][j];
                else arr[i][j] += Math.min(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        createWay(arr);
    }

    private static void createWay(int[][] arr) {

        int i = arr.length - 1;
        int j = arr[0].length - 1;

        arr[i][j] = 0;
        arr[0][0] = 0;

        while (i != 0 || j != 0) {
            if (i == 0) {
                arr[i][j] = 0;
                j--;
                continue;
            }
            if (j == 0) {
                arr[i][j] = 0;
                i--;
                continue;
            }
            if (arr[i - 1][j] < arr[i][j - 1]) {
                arr[i - 1][j] = 0;
                i--;
            } else {
                arr[i][j - 1] = 0;
                j--;
            }
        }

        System.out.println("кратчайший путь показан нолями");

        for (int k = 0; k < arr.length; k++) {
            for (int l = 0; l < arr[0].length; l++) {
                System.out.print(arr[k][l] + " ");
            }
            System.out.println();
        }

    }

}
