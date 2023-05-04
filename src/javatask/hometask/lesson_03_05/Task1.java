package javatask.hometask.lesson_03_05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6};
        System.out.println("среднее " + average(arr));

        List<String> list = Arrays.asList("apple", "banana", "pear", "orange", "grapefruit");
        System.out.println("наибольшее больше 5 букв " + maxMoreFive(list));

        List<String> list2 = Arrays.asList("apple", "banana", "apricot", "orange", "avocado");
        System.out.println("первый на букву А " + firstA(list2));

        System.out.println("сумма квадратов четных " + sumEven(arr));

        List<String> list3 = Arrays.asList("apple", "banana", "orange", "pear", "orange", "apple");
        System.out.println("list unique " + unique(list3));
    }

    private static double average (int[] arr) {
        IntStream stream = Arrays.stream(arr);
        return
                stream
                .average().orElse(0.0);
    }

    private static String maxMoreFive (List<String> list) {
        return list.stream().filter(e -> e.length()>5).max(Comparator.naturalOrder()).get();
    }

    private static Optional<String> firstA (List<String> list) {
        return list.stream().filter(e -> e.charAt(0) == 'a').findFirst();
    }

    private static int sumEven (int[] arr) {
        return Arrays.stream(arr).filter(e -> e % 2 == 0).map(e -> e * e).sum();
    }

    private static List<String> unique (List<String > list ) {
        return list.stream().distinct().toList();
    }


}
