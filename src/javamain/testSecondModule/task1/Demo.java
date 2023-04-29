package javamain.testSecondModule.task1;

public class Demo {
    public static void main(String[] args) {

        Vocabulary v = new Vocabulary();

        v.getVocab().put("собака", "dog");
        v.getVocab().put("птица", "bird");
        v.getVocab().put("кот", "cat");
        System.out.println("список слов в словаре до добавления " +
                v.getVocab());

        System.out.println(v.word("кот"));

        System.out.println(v.word("человек"));
        System.out.println("обновленный список " + v.getVocab());

    }
}
