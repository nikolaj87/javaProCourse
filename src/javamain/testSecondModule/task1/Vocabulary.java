package javamain.testSecondModule.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vocabulary {

    private Map<String, String> vocab = new HashMap<>();

    public Map<String, String> getVocab() {
        return vocab;
    }

    public void setVocab(Map<String, String> vocab) {
        this.vocab = vocab;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "vocab=" + vocab +
                '}';
    }

    public String word (String word) {
        if (vocab.containsKey(word)) {
            return word + " - " + vocab.get(word);
        } else {
            addNewWord(word);
        }
        return "слово успешно добавлено!";
    }

    private void addNewWord(String word) {
        Scanner s = new Scanner(System.in);
        System.out.println("Пока нет слова " + word + ".  Как оно переводится?");
        String str = s.nextLine();
        System.out.println(word + " " + str);
        vocab.put(word, str);
    }

}
