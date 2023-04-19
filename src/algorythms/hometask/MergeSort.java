package algorythms.hometask;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {10, 8, 7, 5, 13, 11};
        mergeSortRecursive(array, array.length);
    }

    private static void mergeSortRecursive(int[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            r[i-mid] = array[i];
        }

        System.out.println(Arrays.toString(l));
        System.out.println(Arrays.toString(r));

        mergeSortRecursive(l, mid);
        mergeSortRecursive(r, n - mid);

        System.out.println(Arrays.toString(l));
        System.out.println(Arrays.toString(r));
    }

}
