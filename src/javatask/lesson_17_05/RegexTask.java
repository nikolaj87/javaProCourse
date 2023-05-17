package javatask.lesson_17_05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTask {
    public static void main(String[] args) {
        String input = "Contact us at info@example.com or support@example.com";
        System.out.println(replace(input));
        System.out.println("проверка телефона " + check( "+1-555-123-4567"));
        System.out.println("проверка ссылки " + isValidURL("https://www.example.com/path/to/page.html"));
    }
    /**
     * Задача 1 (Сложность 4/10):
     * Найти и заменить все email адреса в строке на "REDACTED".
     */
    private static String replace(String input) {
        String replacement = "REDACTED";
        String regex = "[a-z]*@[a-z]*\\.[a-z]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.replaceAll(replacement);
    }

    /**
     * Задача 2 (Сложность 6/10):
     * Проверить, является ли строка валидным номером телефона
     * в формате "+X-XXX-XXX-XXXX", где X - цифра.
     */

    //String phoneNumber = "+1-555-123-4567";
    private static boolean check(String phoneNumber) {
        String regex = "^\\+\\d-\\d{3}-\\d{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    /**
     * Задача 3 (Сложность 8/10):
     * Проверить, является ли строка валидным URL-адресом,
     * начинающимся с "http://" или "https://",
     * и содержащим доменное имя и путь.
     */

    // String url = "https://www.example.com/path/to/page.html";
    private static boolean isValidURL(String URL) {
        String regex = "https?://\\S+";
        return URL.matches(regex);
    }

}