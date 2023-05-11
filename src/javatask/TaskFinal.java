package javatask;

import javatask.Person;

import java.util.AbstractMap;
import java.util.List;

public class TaskFinal {

    /**
     * Дана коллекция объектов класса Person, содержащая поля name и список
     * friends, представляющий список друзей данного человека. Напишите метод,
     * который находит людей в коллекции, у которых максимальное число общих друзей.
     * 10-10
     */

    public static void findMostCommonFriends(List<Person> people) {

        people.stream()
                .flatMap(p1 -> people.stream().skip(people.indexOf(p1) + 1)
                        .map(p2 -> new AbstractMap.SimpleEntry<List<Person>, Long>(List.of(p1, p2),
                                p1.getFriends().stream().filter(el -> p2.getFriends().contains(el)).count()) {
                        }))
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .filter(el -> el.getValue() > 0)
                .forEach(System.out::println);

    }
}