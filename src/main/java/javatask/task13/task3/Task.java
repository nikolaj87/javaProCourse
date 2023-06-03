package main.java.javatask.task13.task3;

class Task {
    //    Напишите программу, которая проверяет, является ли двумерный массив симметричным
//            (относительно главной диагонали).
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 1},
                {2, 0, 5},
                {3, 5, 6}
        };
        System.out.println("симетрический массив - " + check(array));
    }

    public static boolean check(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[0].length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
