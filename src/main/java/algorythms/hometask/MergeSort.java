package algorythms.hometask;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {10, 8, 7, 5, 13, 11, 0 , 1, 2};
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

        merge(array, l, r, mid, n-mid);

//        System.out.println(Arrays.toString(l));
//        System.out.println(Arrays.toString(r));
        System.out.println("new " + Arrays.toString(array));
    }

    static void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while(i < left && j < right) {
            if (l[i] < r[j]) {
                array[k++] = l[i++];
            } else {
                array[k++] = r[j++];
            }
        }
        while(i < left) {
            array[k++] = l[i++];
        }
        while(j < right) {
            array[k++] = r[j++];
        }
    }

}
