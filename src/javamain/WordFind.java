package javamain;

public class WordFind {

    //    Дана строка с текстом.
//    Написать метод, который найдёт слово,
//    которое в тексте встречается больше всего раз.
//
//    Если несколько слов в тексте встречаются одинаково
//    максимальное число раз, то возвращаем то слово,
//    которое встречается в тексте первым.
    public static void main(String[] args) {

        String text = "" +
                "Песня елочка. В лесу родилась елочка, В лесу она росла. Зимой и летом стройная, Зеленая была. " +
                "Метель ей пела песенку: «Спи, елочка, бай-бай! Мороз снежком укутывал: «Смотри, не замерзай!» " +
                "Трусишка зайка серенький Под елочкой скакал. Порою волк, сердитый волк, Рысцою  пробегал.";

        System.out.println("повторяющееся слово в тексте:");
        System.out.println(wordFind(text));

    }

    private static String wordFind(String text){
        //превратим текст в массив слов
        String[] array = textToArray(text);

        int wordCount = 0;
        int counter = 0;
        //проверим повторение слова в массиве. Внешний цикл берет слово 0. Второй For сравнивает
        //его с оставшимися. Если новое слово встречается чаще - поставим его на нолевое место.
        //и вернем array[0] в return.
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    counter++;
                }
            }
            if (counter > wordCount) {
                wordCount = counter;
                array[0] = array[i];
            }
            counter = 0;
        }
        return array[0];
    }

    private static String[] textToArray (String text) {
        String[] array;
        String charsToRemove = ",.<>:!-«»";
        text = text.toLowerCase();
        // убираем лишние символы
        for (char c: charsToRemove.toCharArray()) {
            text = text.replace(String.valueOf(c), "");
        }
        //приводим к массиву методом split
        array = text.split(" ");
        return array;
    }
}
