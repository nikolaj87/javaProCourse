package javasummary.lesson05_05;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CatExamples {

    public static void main(String[] args) {


        Cat cat1 = new Cat("Tom", 2, "black", true);
        Cat cat2 = new Cat("Mikky", 1, "white", false);
        Cat cat3 = new Cat("Vasya", 3, "white", true);
        Cat cat4 = new Cat("Steve", 1, "grey", false);
        Cat cat5 = new Cat("Bob", 2, "black", true);
        List<Cat> catList = Arrays.asList(cat1, cat2, cat3, cat4, cat5);


        // 1. Получить Map<String, Boolean> имя / информация, голодна ли кошка
        System.out.println("мапа  имя - голод " + task1(catList));
        // 2. Получить Map<String, Long> цвет / количество кошек данного цвета
        System.out.println("мапа  цвет - кол-во " + task2(catList));
        // 3. Получить Map<String, Set<String>> цвет / список имен кошек данного цвета
        System.out.println("мапа  цвет - список имен " + task3(catList));
        // 4. Получить Map<Integer, Integer> возраст / количество голодных кошек данного возраста
        System.out.println("мапа  возраст - кол-во голодных котов " + task4(catList));
    }

    private static Map<String, Boolean> task1(List<Cat> list) {
        return list.stream().collect(Collectors.toMap(Cat::getName, Cat::isHungry));
    }

    private static Map<String, Long> task2(List<Cat> list) {
        return list.stream().collect(Collectors.toMap(Cat::getColour, c -> 1L, Long::sum));
    }

    private static Map<String, List<String>> task3(List<Cat> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Cat::getColour,
                        Collectors.mapping(Cat::getName, Collectors.toList())));
    }

    private static Map<Integer, Integer> task4(List<Cat> list) {
        return list.stream().filter(Cat::isHungry)
                .collect(Collectors.toMap(Cat::getAge, c -> 1, (i,j) -> i+j));
    }

}