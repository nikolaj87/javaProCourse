package algorythms.hometask.task6;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        /* реализация подобная той что была на уроке сделана со списками.
        После окончания цикла все элементы меньше array[0] (я не завожу переменную опорную
        но этот элемент будет по умолчанию опорным) окажутся слева а те что больоше - справа.
        Индекс также будет известен. Теперь НО.

        рекурсивно не удалось вызывать метод. Ведь когда отрабатывает левая часть массива,
        она меняет все поинтеры i j и я не пойму как вызвать старые поинтеры для того чтоб
        запустить рекурсию в правой части списка.
        Пришлось поменять логику на более линейную как в QuickSort2
         */

        int[] array = {5, 1, 3, 7, 9, 0, 1};
        System.out.println("array before sort ");
        System.out.println(Arrays.toString(array));
        function(array, 0, array.length - 1);
    }

    static void function(int[] array, int start, int end) {

        if (start >= end) return;

        int i = start;
        int j = end;

        int temp;
        while (i < j) {
            if (array[j] < array[i]) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                while (i < j) {
                    if (array[i] > array[j]) {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        break;
                    }
                    i++;
                }
            }
            j--;
        }

//        function(array, start, i);
//        function(array, j, end);

        System.out.println("array before sort ");
        System.out.println(Arrays.toString(array));
    }

}
