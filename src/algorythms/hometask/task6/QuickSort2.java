package algorythms.hometask.task6;


import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] array = {5,1,3,7,9,0,1};
        sort(array);
    }

    private static int[] array;

    /*
    попытался сделать сортировку которая бы НЕ СОЗДАВАЛА дополнительные массивы а работала
    рекурсивно с одним. Выбирается опорный элемент по середине и ПОПАРНО перекидываются
    слева направо элементы которые нарушают порядок.
    По факту за 1 проход не факт что слева от опорного окажутся все что меньше а справа от
    опорного окажутся все что больше. Может выполнится только одно из условий. Но зато меньше
    итераций за счет ПОПАРНОСТИ смены позиций элемента. НАПРИМЕР
    БЫЛО  5, 1, 3, 7, 9, 0, 1       7 - опорный
    СТАЛО 5, 1, 3, 1, 0, 9, 7       как видим 9 стоит левее 7

     */

    public static void sort(int[] notSorted) {
        if (notSorted ==null || notSorted.length==0) return;
        array = notSorted;
        System.out.println("перед сортировкой " + Arrays.toString(array));
        mySort(0, notSorted.length - 1);
        System.out.println("после сортировки " + Arrays.toString(array));
    }

    private static void mySort(int start, int finish) {

        int i = start, j = finish, temp;
        int pivot = array[start + (finish-start)/2];
        System.out.println(pivot);

        while (i <= j) {
            while (array[i] < pivot) i++;      //если слева меньше опорного пропускаем
            while (array[j] > pivot) j--;      //если справа больше опорного прорускаем
            if (i <= j) {                      //нашли нарушение порядка - меняем местами
                temp = array[i];
                array[i++] = array[j];
                array[j--] = temp;
            }
        }

        if (start < j) mySort(start, j);        //вызываем рекурсивно
        if (i < finish) mySort(i, finish);
    }
}