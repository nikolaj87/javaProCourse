package javatask.hometask.task4;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class WordFromChars {

    public static void main(String[] args) {

        List<Character> list = charGenerate(12);
        String word = "java";
        System.out.println("можно ли составить из " + list + " слово " + word + " ?");

        if (isPossible(list, word)) {
            System.out.println("получилось");
        } else {
            System.out.println("это НЕ возможно");
        }
//           TEST
//        List <Character> list2 = new ArrayList<>();
//        list2.add('j');
//        list2.add('a');
//        list2.add('v');
//        list2.add('h');
//        list2.add('d');
//        list2.add('z');
//        System.out.println("можно ли составить из " + list2 + " слово java?");
//        System.out.println(isPossible(list2, "java" ));
//    }
    }

    private static boolean isPossible(List<Character> list, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!list.contains(word.charAt(i))) {
                System.out.println("нету " + word.charAt(i));
                return false;
            } else {
                list.remove((Character) word.charAt(i));
            }
        }
        return true;
    }

    private static List<Character> charGenerate(int size) {
        List<Character> list = new ArrayList<>(12);

        for (int i = 0; i < size; i++) {
            list.add((char) (new Random().nextInt('a', 'z' + 1)));
        }
        return list;
    }
}
