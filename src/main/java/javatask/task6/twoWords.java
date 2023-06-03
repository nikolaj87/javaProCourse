package main.java.javatask.task6;

public class twoWords {

    public static void main(String[] args) {

        String word1 = "###12#java##";
        String word2 = "ja";

        System.out.println("одинаковые ли слова после модификации первого? - " + function(word1, word2));
    }

    private static boolean function(String word1, String word2) {

        int counter = 0;
        String newStrMirror = "";

        for (int i = word1.length() - 1; i >= 0; i--) {        //пойдем с конца слова так проще чем угадывать что там будет и чтото запоминать
            if (word1.charAt(i) == '#') {                      //нашли решетку? Записали ее в счетчик чтоб позже удалить символ
                counter++;
            } else if (counter > 0 && word1.charAt(i) != '#') {     //нашли символ? но его надо удалить ведь счетчик решеток положительный
                counter--;
            } else if (counter == 0 && word1.charAt(i) != '#') {   //нашли символ и счетчик решеток равен ноль? Запишем символ в новое слово
                newStrMirror += word1.charAt(i);
            }
        }

        String newStr = "";
        for (int i = newStrMirror.length() - 1; i >= 0; i--) {      //перевернем результат ведь слово записано с конца
            newStr += newStrMirror.charAt(i);
        }

        return newStr.equals(word2);                                //сравним результат со словом номер 2
    }
}
