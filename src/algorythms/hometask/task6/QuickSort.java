package algorythms.hometask.task6;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {11,6,2,12,16,4,21,8,4,12,4,11,3};
        function(array, 0, array.length - 1);

    }

    static int[] function(int[] array, int start, int end) {
        int[] array2 = new int[array.length];
        int i = 0;
        int j = end;
        int middle = array[start];
        System.out.println(" начало i= " + i + " " + " конец j= " + j + " мидл = " + middle);

        for (int k = start; k <= end; k++) {
            if (array[k] < middle) {
                array2[i] = array [k];
                i++;

            } else if (array[k] > middle) {
                array2[j] = array[k];
                j--;
            }
        }
        start = i-1;
        System.out.println(start);
        end = j;
        for (int k = i; k <= j; k++) {
            array2[k] = middle;
        }
        System.out.println(Arrays.toString(array2));

        function(array2, 0, start);
//        function(array2, j, end);

        return array;
    }

}
