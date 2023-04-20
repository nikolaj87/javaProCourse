package algorythms.hometask.task6;

import java.util.LinkedList;
import java.util.List;

public class QuickSortList {

    public static void main(String[] args) {

        /*
        Реализация на основе списка.
        quickSort доделанный с урока во вторник. Решил не пушить опорный элемент ни в один из
        списков, а держать его отдельно и добавить его в результирующий список уже при сборке
        кстати возможно это сделает алгоритм эффективней.
        конечно надо учитывать что опорный элемент может быть не один
        */

        int[] array = {11, 6, 2, 12, 16, 4, 21, 8, 4, 12, 4, 3, 11, 11};
        List<Integer> list = new LinkedList<>();
        for (int i : array) list.add(i);          //создаю список на основе массива.
                                                  //то что вы делали на уроке list.of это неизменяемый список так нельзя
        System.out.println("array before sort " + list);
        function(list);
        System.out.println("array after sort " + list);
    }

    static void function(List<Integer> list) {

        if (list.size() < 2) return;                //базовый случай

        List<Integer> l = new LinkedList<>();       //создаем два списка новых
        List<Integer> r = new LinkedList<>();
        int middle = list.get(0);                   //опорным будет нолевой элемент

        for (int i : list) {
            if (i < middle) {                       //пушим элемент в один из списков в зависимости > <
                l.add(i);
            } else if (i > middle) {
                r.add(i);
            }
        }
            function(l);                            //вызываем рекурсивно для каждого списка
            function(r);

            construct(list, l, r, middle);          //собираем в обратном порядке
        }


    static void construct(List<Integer> list, List<Integer> l, List<Integer> r, int element) {

        int count = list.size() - (l.size() + r.size());     //счетчик помнит количество опорных элементов
        list.clear();                                        //надо обязательно почистить список перед сборкой

        list.addAll(l);                                      //пушим левый список
        for (int i = 0; i < count; i++)                      //опорный элемент
            list.add(element);
        list.addAll(r);                                      //пушим правый список
    }
}
