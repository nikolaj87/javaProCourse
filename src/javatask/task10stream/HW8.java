package javatask.task10stream;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HW8 {

    public static void main(String[] args) {
        /**
         * Дан двумерный массив строк, необходимо выбрать
         * все уникальные слова из массива и вернуть отсортированный
         * список слов в порядке убывания частоты их появления в массиве.
         */
        String[][] words = {{"apple", "orange", "pear", "orange"},
                {"orange", "pear", "pear", "apple"},
                {"apple", "orange", "orange", "pear"},
                {"orange", "pear", "apple", "pear"}};
        System.out.println("список слов по убиванию частотности " + m8(words));
//-------------------------------------------------------------------------------------------
        /**
         * Есть двумерный массив строк, представляющий таблицу данных,
         * где первый столбец - это имена, а остальные столбцы -
         * это числовые значения. Вам нужно написать программу,
         * которая найдет среднее значение для каждого числового
         * столбца, игнорируя строки, которые не могут быть преобразованы в числа.
         */
        String[][] data = {
                {"name1", "10", "20", "30"},
                {"name2", "40", "50", "not a number"},
                {"name3", "60", "70", "80"}};
        System.out.println(m9(data));
    }

    private static List<Double> m9(String[][] data) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        return IntStream.range(0, data[0].length - 1)
                .mapToObj(number -> Arrays.stream(data)
                        .map(el -> el[number + 1])
                        .filter(pattern.asPredicate())
                        .mapToInt(Integer::parseInt)
                        .average().orElse(0))
                .toList();
    }

    private static List<String> m8(String[][] words) {

        return Arrays.stream(words).flatMap(el -> Arrays.stream(el))
                .collect(Collectors.toMap(o -> o, o -> 1, Integer::sum))
                .entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .map(entry -> entry.getKey())
                .toList();
    }
}