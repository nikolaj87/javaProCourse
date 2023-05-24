package javamain.hometask_reqex;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {

    public static void main(String[] args) {

        System.out.println(
        Stream.of(1, 2, 3, 4, 5).noneMatch(e -> e < 0)
);
//    Напишите программу, которая запрашивает у пользователя строку и проверяет,
//    является ли эта строка действительным email-адресом.
//    Действительный email-адрес должен содержать символ "@",
//    доменное имя и доменное расширение (например, ".com" или ".org").
//    Используйте регулярное выражение для проверки email-адреса.
        String str = "tel-run@gmail.com";
        System.out.println("строка является e-mail - " + checkMail(str));

//    Напишите программу, которая запрашивает у пользователя строку
//    и проверяет, состоит ли эта строка только из букв и цифр.
//    Используйте регулярное выражение для проверки,
//    что в строке содержатся только символы латинского алфавита
//            (большие и/или маленькие) и цифры.
        String str2 = "1543lkj7n8m6h3g4h5jk234";
        System.out.println("строка из букв и цифр " + checkString(str2));

//    Напишите программу, которая запрашивает у пользователя строку
//    и проверяет, является ли эта строка действительным номером телефона.
//    Действительный номер телефона должен начинаться с символа "+"
//    и содержать девять цифр. Используйте регулярное выражение
//    для проверки номера телефона.
        String str3 = "+380975461";
        System.out.println("строка это номер телефона - " + checkPhone(str3));

//    Напишите программу, которая запрашивает у пользователя строку
//    и заменяет все вхождения чисел в строке на слово "number".
//    Например, если строка содержит "12345", то программа должна
//    заменить это на "number". Используйте регулярное выражение
//    для поиска чисел в строке.
        String str4 = "hjk1lkjh123oiu55678l;lkj0";
        String str5 = "Number";
        System.out.println("строка с заменами - " + replaceNumber(str4, str5));

//    Напишите программу, которая запрашивает у пользователя строку
//    и проверяет, начинается ли эта строка с буквы "A" (большой или маленькой).
//    Используйте регулярное выражение для проверки начала строки.
        String str6 = "A45jkl";
        System.out.println("начинается в а - " + checkA(str6));

    }

    private static boolean checkA(String str6) {
        String regex = "[aA].*";
        return str6.matches(regex);
    }

    private static boolean checkMail(String str) {
        String regex = "[\\w.%+-]+@\\w+\\.\\w{2,}";
        return str.matches(regex);
    }

    private static boolean checkString(String str) {
        String regex = "[a-zA-Z0-9]+";
        return str.matches(regex);
    }

    private static boolean checkPhone(String str) {
        String regex = "\\+[0-9]{9}";
        return str.matches(regex);
    }

    private static String replaceNumber(String target, String source) {
        String regex = "[0-9]+";
        return target.replaceAll(regex, source);
    }

//    Напишите программу, которая получает на вход текст и проверяет,
//    вхождения определенных строк в текст. Строки заданы в виде коллекции.
//    Используйте регулярное выражение для проверки текста.
//    Верните в качестве результата работы коллекцию из строк,
//    которые входят в текст.
}
