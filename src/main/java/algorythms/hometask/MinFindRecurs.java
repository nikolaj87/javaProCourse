package main.java.algorythms.hometask;

public class MinFindRecurs {
    public static void main(String[] args) {

        int[] array = {0, 4, 2, 3, 4, 5, 1};
        System.out.println(minFind(array, 0));

    }

    public static int minFind(int[] arr, int n) {
        int lastCheck = arr.length - 2;
        if (n == lastCheck) {
            return Math.min(arr[lastCheck], arr[lastCheck + 1]);
        }
            return Math.min(arr[n], minFind(arr, n + 1));
    }
}


