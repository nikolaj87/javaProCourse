package main.java.javasummary.lesson26_05;

import java.util.Arrays;
import java.util.List;

public class Task {
//Написать Generic метод <T> List<T> , который преобразует массив в список

    //    2.  Задание: напишите метод filter(Object[] ints, ()->()), который принимает
//    на вход массив (любого типа) и реализацию интерфейса Filter c методом apply (Object o),
//    чтобы убрать из массива лишнее. Проверьте как он работает на строках или других объектах.
//    interface Filter {
//       boolean apply(o);
//    }
    public static void main(String[] args) {

        Filter filter = o -> {
            return (int) o > 3;
        };

        Object[] arr = List.of(1,2,3,4,5).toArray();
        System.out.println(Arrays.toString(filter(arr, filter)));
    }

    public static<T> T[] filter(T[] ints, Filter<T> fil) {
        int newSize = 0;
        for (int i = 0; i < ints.length; i++) {
            if(fil.apply(ints[i])){
                System.out.println("123");
                ints[newSize++] = ints[i];
            }
        }
        T[] ts = Arrays.copyOf(ints, newSize);
        return ts;

//        Iterator<T> iterator = Arrays.stream(ints).iterator();
//        while (iterator.hasNext()) {
//            T o = iterator.next();
//            if (fil.apply(o)) {
//                iterator.remove();
//            }
//        }
//
//        return ints;
    }


    public <T> List<T> convert(T[] t) {
        return Arrays.asList(t);
    }

    public <T> T[] convert2(List<T> list) {
        return (T[]) list.stream().toArray();
    }


}
