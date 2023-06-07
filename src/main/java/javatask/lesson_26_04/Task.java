package javatask.lesson_26_04;

import java.util.*;
import java.util.stream.IntStream;

public class Task {
    public static void main(String[] args) {


        List<Integer> numbers =
                Arrays.asList(1, 2, 3, 4, 11, 5, 6, 6, 7, 8, 9, 10);
        int[] arr = {1, 2, 3, 65, 47, 89};

        System.out.println("повторения? " + Arrays.toString(arr));
        System.out.println(check(arr));
        System.out.println(check2(arr));


        // List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7,
        // 8, 9, 10);
        // - Фильтрация списка на нечетные числа
        System.out.println("=============================");
        System.out.println(numbers);
        System.out.println("без четных " + filter(numbers));


        //  Определение максимального значения в списке
        System.out.println("=============================");
        System.out.println("max = " + max(numbers));


        // Получение среднего значения списка целых чисел
        System.out.println("=============================");
        System.out.println("среднее значение " + average(numbers));


        // Нахождение суммы чисел, кратных 3 и 5, из списка чисел
        System.out.println("=============================");
        System.out.println("сумма чисел кратных 3 и 5 = " + sumFunction(numbers));


        // Поиск наибольшей длины последовательности из уникальных
        // чисел в списке
        System.out.println("=============================");
        System.out.println("максимальная длина последовательности " +
                "чисел = " + originalNumberLength(numbers));
        System.out.println("максимальная длина последовательности " +
                "чисел Streams = " + originalNumberLength2(numbers));


        // Преобразование списка строк в список чисел
        System.out.println("=============================");
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        System.out.println("List<String> to List<Integer> " + listConvert(strings));


        List<String> words = Arrays.asList("apple", "banana", "apricot",
                "cherry", "kiwi", "apple");

        // Фильтрация списка строк на те, которые начинаются с 'a'
        // и преобразование их в верхний регистр
        System.out.println("=============================");
        System.out.println(words);
        System.out.println("" + filterCharA(words));


        // Получение списка уникальных слов из списка строк, длина
        // которых больше 4 символов
        System.out.println("=============================");
        System.out.println("список уникальных слов, больше 4 символов");
        System.out.println("" + moreThanFourChars(words));


        /*   Преобразование списка объектов класса в список их имен,
         *    отсортированных по возрасту
         */
        List<Person> people = Arrays.asList(new Person("John", 25),
                new Person("Alice", 22), new Person("Bob", 30));
        System.out.println("=============================");
        System.out.println("список персон " + people);
        System.out.println("список их имен, сорт по возрасту" + listPersonToString(people));
//

        /*
         * Написать метод (стримами и НЕ стримами), который проходится по массиву
         * и находит все пары чисел, которые в сумме дают заданное число.

         */
        System.out.println("=============================");
        int[] arr2 = {2, 3, 5, 6, 4, 7, 8};
        List<Integer> l = List.of(2, 3, 5, 6, 4, 7, 8);
        int k = 10;
        System.out.println(Arrays.toString(arr2));
        System.out.println("кол-во пар массива составляющих " + k + " = " +
                +pairs(arr2, k));
        System.out.println("кол-во пар массива составляющих " + k + " STREAMS = " +
                +pairsStream(l, k));
    }

    // находит совпадения пар элементов дающих в сумме k
    private static int pairsStream(List<Integer> list, int k) {

        return IntStream.range(0, list.size() - 1)
                .mapToObj(o -> list.stream().skip(o + 1)
                        .filter(el -> el + list.get(o) == k).toList())
                .flatMap(Collection::stream).toList().size();
    }

    // находит совпадения пар элементов дающих в сумме k
    private static int pairs(int[] array, int k) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == 10) {
                    counter++;
                }
            }
        }
        return counter;
    }

    // конвертирует обьекты в имена и сортирует
    private static List<String> listPersonToString(List<Person> list) {
        return list.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .map(Person::getName)
                .toList();
    }

    // оставляет слова длиннее 4 символов
    private static List<String> moreThanFourChars(List<String> list) {
        return list.stream()
                .filter(e -> e.length() > 4)
                .distinct()
                .toList();
    }


    // конвертация листа стринг в интежер
    private static List<String> filterCharA(List<String> list) {
        return list.stream()
                .filter(e -> e.charAt(0) == 'a')
                .map(String::toUpperCase)
                .toList();
    }

    // конвертация листа стринг в интежер
    private static List<Integer> listConvert(List<String> list) {
        return list.stream()
                .map(Integer::parseInt)
                .toList();
    }

    // проверяет кол во вхождений неповторяющихся чисел
    private static int originalNumberLength(List<Integer> list) {
        System.out.println(list);
        int counterMax = 0, temp = 1;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + 1 == list.get(i + 1)) {
                temp++;
            } else {
                if (temp > counterMax) {
                    counterMax = temp;
                }
                temp = 1;
            }
        }
        return Math.max(temp, counterMax);
    }

    private static int originalNumberLength2(List<Integer> list) {
        List<Integer> listOfIndexes = new ArrayList<>();
        listOfIndexes.add(0);
        listOfIndexes.add(list.size());
//создадим список индексов которые делят лист на последовательности:
        listOfIndexes.addAll(1, IntStream.iterate(0, i -> ++i)
                .limit(list.size() - 1)
                .filter(e -> list.get(e) + 1 != list.get(e + 1))
                .map(e -> ++e)
                .boxed().toList());
//найдем расстояние между индексами и вычислим наибольшее через стрим
        return IntStream.range(0, (listOfIndexes.size()))
                .skip(1)
                .map(e -> listOfIndexes.get(e) - listOfIndexes.get(e - 1))
                .reduce(Math::max)
                .getAsInt();

//        int[] points = {0, x, list.size()};
//        System.out.println( "максимальная длина последовательности " +
//        IntStream.rangeClosed(0, 1)
//                .mapToObj(i -> list.subList(points[i], points[i + 1]))
//                .map(List::size).reduce(Integer::max).get()
//        );

    }

    // возвращает сумму чисул кратных 3 или 5
    private static int sumFunction(List<Integer> list) {
        return list.stream()
                .filter(e -> e % 3 == 0 || e % 5 == 0)
                .reduce((o1, o2) -> o1 + o2)
                .get();

//        return list.stream()
//                .filter(el -> el % 3 == 0 || el % 5 == 0)
//                .mapToInt(el -> el)
//                .sum();
    }

    // возвращает среднее из листа
    private static double average(List<Integer> list) {
        return list.stream()
                .mapToDouble(el -> el)
                .average()
                .getAsDouble();
    }


    //метод отфильтровывает четные числа
    private static List<Integer> filter(List<Integer> list) {
        return list.stream().filter(el -> el % 2 == 1).toList();
    }

    //метод находит максимальное значение
    private static int max(List<Integer> list) {

        return list.stream()
                .reduce((o1, o2) -> o1 > o2 ? o1 : o2)
                .get();

//        return list.stream()
//                .max(Comparator.naturalOrder())
//                .get();
    }

    //есть ли повторения элементов
    private static boolean check(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            if (list.contains(j)) {
                return true;
            }
            list.add(j);
        }
        return false;
    }

    // есть ли повторения элементов?
    private static boolean check2(int[] arr) {
        return Arrays.stream(Arrays.stream(arr)
                .distinct()
                .toArray()).count() != arr.length;
    }
}