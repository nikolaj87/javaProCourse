package javatask.hometask.adds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WorkWithStream {
    public static void main(String[] args) {

        System.out.println("=============================");
        List<Integer> list = List.of(9,1, 9, 9, 5, 5,9);
        int k = 10;
        System.out.println("list " + list);
        System.out.println("кол-во пар массива составляющих " + k + " = " +
                +pairsStream2(list, k));


//        List<Integer> list = List.of(1, 2, 3, 4, 11, 5, 6, 7, 8, 1);
//        List<Integer> listOfIndexes = new ArrayList<>();
//        listOfIndexes.add(0);
//        listOfIndexes.add(list.size());
////создадим список индексов которые делят лист на последовательности:
//        listOfIndexes.addAll(1, IntStream.iterate(0, i -> ++i)
//                .skip(0)
//                .limit(list.size() - 1)
//                .filter(e -> list.get(e) + 1 != list.get(e + 1))
//                .map(e -> ++e)
//                .boxed().toList());
//        System.out.println(listOfIndexes);
////найдем расстояние между индексами и вычислим наибольшее через стрим
//        System.out.println( "максимальная длина последовательности " +
//        IntStream.range(0, (listOfIndexes.size()))
//                .skip(1)
//                .map(e -> listOfIndexes.get(e)- listOfIndexes.get(e-1))
//                .reduce(Math::max)
//                .getAsInt()
//        );
////        int[] points = {0, x, list.size()};
////        System.out.println( "максимальная длина последовательности " +
////        IntStream.rangeClosed(0, 1)
////                .mapToObj(i -> list.subList(points[i], points[i + 1]))
////                .map(List::size).reduce(Integer::max).get()
////        );
    }        // находит совпадения пар элементов дающих в сумме k

    private static int pairsStream2(List<Integer> list, int k) {
        System.out.println(
                IntStream.range(0, list.size() - 1)
                        .mapToObj(o -> list.stream().skip(o + 1)
                                .filter(el -> el + list.get(o) == k).toList())
                        .flatMap(Collection::stream).toList().size()
        );

//                        list.subList(o + 1, list.size())
//                        .stream().filter(el -> el + list.get(o) == k).toList())

        return IntStream.range(0, list.size() - 1)
                .mapToObj(o -> list.subList(o + 1, list.size())
                        .stream().filter(el -> el + list.get(o) == k).toList())
                .flatMap(Collection::stream).toList().size();


//        return IntStream.range(0, list.size() - 1)
//                .boxed()
//                .collect(Collectors.toMap(list::get, i ->
//                         list.subList(++i, list.size())))
//                .entrySet().stream()
//                .map(e -> e.getValue().stream()
//                        .filter(o -> o + e.getKey() == k).toList())
//                .flatMap(Collection::stream).toList().size();
    }
}
