package javatask.hometask.task8stream;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {


    public static void main(String[] args) {
//написать программу на Java, которая на вход получает массив
// строк и проверяет, есть ли среди них хотя бы одна строка,
// содержащая только цифры. Если есть, то программа должна вернуть эту строку,
// иначе - вернуть null.

        String[] strings = {"два", "вдох", "123456", "1f", "g2"};
        System.out.println("is a there a string of numbers? - " + check(strings));
        System.out.println("===================================================================");

//написать программу на Java, которая считывает текстовый файл,
// заменяет в нем все вхождения слова "???"
// на слово "вырезано цензурой" и сохраняет изменения в тот же файл
        String str = "Работа с регулярными выражениями в любой Java-программе начинается с создания" +
                " объекта класса ???. Для этого необходимо вызвать один из двух имеющихся в" +
                " классе статических методов compile. Первый метод принимает один аргумент – " +
                "строковый литерал регулярного выражения, а второй – плюс еще параметр, " +
                "включающий режим сравнения шаблона с текстом. A если че не нравится - ???.";
        System.out.println(substitution(str));
        System.out.println("===================================================================");
// Напишите программу на Java, которая
// запрашивает у пользователя строку и выводит
// на экран все уникальные слова в этой строке, отсортированные в алфавитном порядке.
        String str2 = "Регулярные выражения — тема, которую программисты, даже опытные," +
                " зачастую откладывают на потом. Однако большинству Java-разработчиков рано или поздно " +
                "придётся столкнуться с обработкой текстовой информации. Чаще всего — с операциями " +
                "поиска в тексте и редактированием. Без регулярных выражений продуктивный и компактный " +
                "программный код, связанный с обработкой текстов, попросту немыслим. Так что хватит" +
                " откладывать, разберёмся с «регулярками» прямо сейчас. Это не такая уж и сложная задача.";
        System.out.println(uniqueSorted(str2));
//Напишите программу на Java, которая запрашивает
// у пользователя текст, содержащий числа в формате
// "число.число", и выводит на экран среднее арифметическое всех чисел в тексте.
        System.out.println("===================================================================");
        String incomeNumbers = "12.54.23.2.44.1";
        System.out.println("average is " + average(incomeNumbers));
    }

    private static final List<Integer> ACCEPTABLE_VALUES = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
    private static final List<Character> DELETE = List.of(',', '.', '«', '»', '—');

    private static double average(String str) {
        return Arrays.stream(str.split("\\."))
                .mapToInt(Integer::parseInt).average().orElse(0.0);
    }

    private static String check(String[] strings) {
        return Arrays.stream(strings).filter(e -> e.chars().map(j -> j - '0')
                        .allMatch(ACCEPTABLE_VALUES::contains))
                .findFirst().orElse("");
    }

    private static String substitution(String str) {
        return Arrays.stream(str.split(" "))
                .map(o -> o.startsWith("???") ? "ВЫРЕЗАНО ЦЕНЗУРОЙ" + o.substring(3) : o)
                .reduce((o1, o2) -> o1 + " " + o2).orElse("");
    }

    private static List<String> uniqueSorted(String str) {

        return Arrays.stream(str.split(" "))
                .map(o -> o.chars().filter(el -> !DELETE.contains((char) el))
                        .collect(StringBuilder::new,               // supplier
                                StringBuilder::appendCodePoint,    // accumulator
                                StringBuilder::append)             // combiner
                        .toString())
                .distinct().sorted(Comparator.naturalOrder()).toList();
    }
}
