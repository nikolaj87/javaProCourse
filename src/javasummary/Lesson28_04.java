package javasummary;

import java.util.Random;
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
                (e1, e2) -> (int)Math.pow(e1, e2);

        //Создать функцию, которая обрезает входную строку до 5 символов, делает
        // их upper case и добавляет ____ в конец.
        Function<String, String> myStr =
                ((Function<String, String>)e -> e.substring(0,5))
                .andThen(String::toUpperCase)
                .andThen(e -> e + "___");





    }
}
