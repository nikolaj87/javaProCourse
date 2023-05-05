package javatask.lesson_03_05;

import java.util.Arrays;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("sum not noteven " + sum(numbers));

        List<String> strings = Arrays.asList("Java", "Python", "C++", "Ruby", "JavaScript", "PHP");
        System.out.println("longest - " + longest(strings));

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("Charlie", 25),
                new Person("David", 35),
                new Person("Eve", 28));
        System.out.println("sorted more than 25 years " + sort(people));

        List<Integer> numbers2 = Arrays.asList(1, 5, 10, 15, 20);
        System.out.println("max x2 " + max2(numbers2));

        List<String> strings2 = Arrays.asList("Java", "JavaScript", "Python", "Ruby", "JavaFX", "Scala");
        System.out.println(str2(strings2));



    }
    private static List<String> str2(List<String> list) {
        return list.stream().filter(e -> (e.charAt(0) == 'J'))
                .filter(e -> e.charAt(e.length()-1) == 'a').toList();
    }

    private static int max2(List<Integer> list) {
        return 2 * list.stream().reduce(Math::max).get();
    }


    private static List<Person> sort(List<Person> list) {
        return list.stream().filter(o -> o.getAge() > 25).sorted().toList();
    }


    private static String longest(List<String> list) {
        return list.stream().min((e1, e2) -> (e2.length() - e1.length())).get();
    }


    private static int sum(List<Integer> list) {
        return list.stream().filter(e -> e % 2 == 1).reduce((e1, e2) -> e1 + e2).get();
    }

}
