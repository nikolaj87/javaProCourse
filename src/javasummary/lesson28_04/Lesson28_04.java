package javasummary.lesson28_04;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lesson28_04 {

    public static void main(String[] args) {

        //Создать Supplier, который генерирует случайные значения типа Integer
        Supplier<Integer> generateRandomInt = () -> new Random().nextInt(10);

        //Создать BiFunction, которая возводит первый аргумент типа int в степень
        // второго аргумента типа int
        BiFunction<Integer, Integer, Integer> multi =
                (e1, e2) -> (int) Math.pow(e1, e2);

        //Создать функцию, которая обрезает входную строку до 5 символов, делает
        // их upper case и добавляет ____ в конец.
        Function<String, String> myStr =
                ((Function<String, String>) e -> e.substring(0, 5))
                        .andThen(String::toUpperCase)
                        .andThen(e -> e + "___");
        //сортировать с помошью стрима
        String[] arr = {"sun", "mon", "tue", "wed", "thur", "fri", "wed", "thur"};
        Arrays.stream(arr).sorted().toArray();
        Arrays.stream(arr).sorted(Comparator.reverseOrder()).toArray();

        // из листа инт сделать лист стринг
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        list.stream().map(String::valueOf).toList();

        //выборки из списка котов
        Cat cat1 = new Cat("fgh", 1, "dfg", true);
        Cat cat2 = new Cat("sdf", 1, "dfg", false);
        Cat cat3 = new Cat("hjy", 3, "dfg", true);
        Cat cat4 = new Cat("tyu", 2, "black", false);
        List<Cat> catList = Arrays.asList(cat1, cat2, cat3, cat4);

        catList.stream().filter(o -> o.getAge() >= 2 && o.isHungry())
                .toList();
        catList.stream().filter(o -> o.getColour().equals("black")
                && o.getName().charAt(0) == 't').toList();
        catList.stream().filter(o -> o.getAge() == 1)
                .map(Cat::getName).toList();
        //посчитать количество неповторяющихся слов в списке
        Arrays.stream(arr).distinct().count();
        //посчитать число повторений слова
        Arrays.stream(arr).filter(e -> e.equals("wed")).count();
        //из списка слов вывести первое по алфавиту
        Arrays.stream(arr).sorted().findFirst();
        //посчитать колво чисел от 1 до 1000 которые делятся на 7
        int[] arrayOneToThousand = new int[1001];
        for (int i = 0; i <= 1000; i++) arrayOneToThousand[i] = i;
        Arrays.stream(arrayOneToThousand).filter(e -> e % 7 == 0)
                .count();
        //посчитать сумму квадратов чисел от 1 до 10
        int[] oneToTenArray = new int[11];
        for (int i = 0; i < 11; i++) oneToTenArray[i] = i;
        Arrays.stream(oneToTenArray).mapToDouble(e -> Math.pow(e, 2))
                .reduce(Double::sum);
        //вывести абривиатуру S.M.A.R.T. по 1 букве каждого слова
        List<String> myStrList = Arrays.asList("Specific", "Measurable",
                "Achievable", "Relevant", "Time-bound");
        myStrList.stream().map(e -> e.substring(0,1).concat("."))
                .reduce((e1,e2) -> e1+e2);
    }
}
