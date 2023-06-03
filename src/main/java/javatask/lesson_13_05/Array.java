package main.java.javatask.lesson_13_05;

public class Array {

    public static void main(String[] args) {
        int n = 4;
        arrayFill(n);

        int[] array2 = {0,0,0,0,1,1,2,3,2,8,8,11,11,22,22,33};
        System.out.println(isStepUp(array2));
    }

    public static boolean isStepUp(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }

        return true;
    }

    public static void arrayFill(int n) {
        int[][] arr = new int [n][n];
        int count = 1;

        for (int i = n - 1 ; i >= 0 ; i--) {
            for (int j = 0; j < arr.length; j++) {
                arr[j][i] = count++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
