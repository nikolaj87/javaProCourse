package algorythms.hometask.task6;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {11, 6, 2, 12, 16, 4, 21, 8, 4, 12, 4, 3, 11, 11};
        System.out.println("array before sort ");
        System.out.println(Arrays.toString(array));
        function(array, 0, array.length - 1);

    }

    static int[] function(int[] array, int start, int end) {
        int[] newArray = new int[(end + 1) - start ];
        int i = start;
        int j = end;
        int middle = array[start];
        System.out.println("начало i = " + i + " " + " конец j = " + j + " опорный элем = " + middle);

        for (int k = start; k <= end; k++) {
            if (array[k] < middle) {
                newArray[i++] = array[k];
            } else if (array[k] > middle) {
                newArray[j--] = array[k];
            }

        }

        for (int k = i; k <= j; k++) {
            newArray[k] = middle;
        }
        System.out.println("array after sort");
        System.out.println(Arrays.toString(newArray));
        System.out.println("опорный элемент имеет индекс " + i);
        System.out.println("последный индекс опорного элемента имеет индекс " + j);

//        function(newArray, 0, i-1);
//        function(array2, j, end);

        return array;
    }

}
