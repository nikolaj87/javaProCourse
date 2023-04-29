package algorythms.hometask.task7;

import java.util.*;
import java.util.function.Function;

public class Task {



    //Дано число, записанное своими разрядами в массиве, например, число 546
    //будет представлено массивом [5, 4, 6]. Прибавить к этому "числу" 1.

    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(3L);
        list.add(null);
        list.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println(list);

        System.out.println( "A" .compareTo( "B"));
        String one1 = "One";
        String one2 = "One";
        String one3 = new String("One");
        String one4 = new String("One");

        System.out.println(one3 == one4);
//        System.out.println(one2.equals(one3));



        int[] arr = {1, 2, 3, 9};
        System.out.println("before " + Arrays.toString(arr));
        System.out.println("after1 " + Arrays.toString(increment(arr)));
        System.out.println("after2 " + Arrays.toString(increment2(arr)));
        System.out.println("after3" + Arrays.toString(increment3(new int[]{9, 9, 9, 9})));
    }

    //начали стримы учить. Тоже допустимый вариант решения в строчку:
    private static int[] increment3(int[] arr) {
        return Integer.toString(Arrays.stream(arr).reduce((e1, e2) -> 10 * e1 + e2)
                        .getAsInt() + 1).chars().map(c -> c - '0').toArray();
    }
    //=======================================================================================================
    //самое очевидное решение:
    private static int[] increment(int[] arr) {
        StringBuilder str = new StringBuilder();
        for (int j : arr) {
            str.append(j);
        }
        str = new StringBuilder(String.valueOf(Integer.parseInt(str.toString()) + 1));

        int[] newArray = new int[str.length()];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = str.charAt(i) - 48;
        }
        return newArray;
    }
    //==========================================================================
    //решение в лоб как ни странно стремится к О(1) и является куда более
    //эффективным.
    private static int[] increment2(int[] array) {

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 9) {
                if (i == 0) {
                    return copy(array);
                } else array[i] = 0;
            } else {
                array[i] = array[i] + 1;
                return array;
            }
        }
        return array;
    }

    private static int[] copy(int[] arr) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 1; i < newArr.length; i++) newArr[i] = 0;
        newArr[0] = 1;
        return newArr;
    }
}
