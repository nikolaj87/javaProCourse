package javatask.task11regex;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReqExTask {
    public static void main(String[] args) {

        String variable = "1_va";
        System.out.println("variable is valid - " + isValid(variable));
        String ipAddress = "192.168.0.1";
        System.out.println("IP is valid - " + isValidIP(ipAddress));
        String text = "Some text with dates: 01-01-2022, 31-12-2023, 15-02-2024";
        System.out.println("dates are: " + findDate(text));
        System.out.println("========================================================================================");
        String str = "<!DOCTYPE html><html lang=\"ru\"><head><meta charset=\"utf-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "<title>Заголовок страницы</title><link rel=\"stylesheet\" href=\"./styles/style.css\"> " +
                "<header> <h1>Это мой сайт</h1> <p>Он хороший</p> <nav> <ul> " +
                "<li>" +
                "<a href=\"index.html\">Эта страница</a></li> " +
                "<li>" +
                "<a href=\"catalog.html\">Другая страница</a>" +
                "</li> " +
                "</ul> </nav> </header> <main> <article> <section> " +
                "<h2>Первая секция</h2> <p>Она обо мне</p> " +
                "<img src=\"images/image.png\" alt=\"Человек и пароход\"> " +
                " defer></script> --> </body></html>";

        pars(str);
        //=================================================================================================
        File dir = new File("C:\\Users\\Slonick\\IdeaProjects\\javaProCourse\\src\\javatask\\files");
        File[] arrFiles = dir.listFiles();
        List<File> lst = Arrays.asList(arrFiles);
        System.out.println("все файлы:");
        System.out.println(lst);
        System.out.println("файлы MP3 и PDF:");
        System.out.println(fileSearch(lst));
    }


    /**
     * Задача с уровнем сложности 4:
     * Напишите программу на Java, которая будет проверять,
     * является ли заданная строка допустимым именем переменной.
     * Допустимые имена переменных должны начинаться с буквы или
     * знака подчеркивания, а затем могут содержать любую комбинацию
     * букв, цифр и знаков подчеркивания. Минимальная длина имени
     * переменной должна быть 2 символа.
     */

    private static boolean isValid(String variable) {

        return variable.matches("[a-zA-Z_$][a-zA-Z0-9_$]+");
    }

    /**
     * Задача 1 (Уровень сложности: 5)
     * Проверить, является ли строка действительным IP-адресом формата IPv4.
     * String ipAddress = "192.168.0.1";
     */
    private static boolean isValidIP(String IP) {
        return IP.matches("\\d{3}.\\d{3}.\\d.\\d");
    }

    /**
     * Задача 2 (Уровень сложности: 7)
     * Найти все даты в формате "DD-MM-YYYY" в заданной строке.
     * String text = "Some text with dates: 01-01-2022, 31-12-2023, 15-02-2024";
     */

    private static List<String> findDate(String text) {
        List<String> list = new ArrayList<>();

        String regex = "(0[1-9]|1\\d|2\\d|3[01])-(0[1-9]|1[012])-\\d{4}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        while (m.find()) {
            list.add(text.substring(m.start(), m.end()));
        }
        return list;
    }

    /**
     * Задача с уровнем сложности 10:
     * Напишите программу на Java, которая
     * будет парсить и анализировать структуру
     * HTML-документа. Вам нужно найти все ссылки
     * (<a> теги) в HTML-коде и вывести их атрибуты
     * href и текст ссылки.
     */

    private static void pars(String html) {

        String regex = "<a\\s+href=\"([^\"]+)\">([^<]+)</a>";

        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(html);

        while (m.find()) {
            String tegA = html.substring(m.start(), m.end());
            System.out.println("тэг = " + tegA);
            System.out.println("ссылка = " + tegA.substring(tegA.indexOf("\"") + 1, tegA.lastIndexOf("\"")));
            System.out.println("текст ссылки = " + tegA.substring(tegA.indexOf(">") + 1, tegA.lastIndexOf("<")));
            System.out.println("----------------------------------------------------------------------");
        }
    }

    /**
     * Написать программу, которая ищет все файлы определенного расширения
     * на вашем компьютере
     */

    private static List<File> fileSearch(List<File> list) {

        String regex = ".*\\.mp3|.*\\.pdf";

        return list.stream()
                .filter(f -> f.getName().matches(regex))
                .toList();
    }
}



