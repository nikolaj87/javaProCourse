package javatask.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        //сгенерировать 20 чисел диапазона от 0 до 20
        //получить число Х
        //найти все последовательности чисел даюшие в  сумме Х.
        //эти числа должны идти последовательно

        int x = 20;
        List<Integer> list = new ArrayList<>(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(21));
        }
        System.out.println("сгенерированный список 20 чисел в диапазоне 0 - 20:");
        System.out.println(list);
        System.out.println("искомая сумма " + x);
        System.out.println("=================================================================");

        System.out.println("число " + x + " составляют следующие списки " +
                "последовательных чисел: ");

        List <List<Integer>> BigList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = new ArrayList<>();

            int sum = list.get(i);
            temp.add(list.get(i));

            for (int j = i + 1; j < list.size(); j++) {
                sum = sum + list.get(j);
                temp.add(list.get(j));
                if (sum > x) {
                    break;
                } else if (sum == x) {
                    System.out.println(temp);
                    addTempToBigList(temp, BigList);
                    break;
                }
            }
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Это полный список списков: ");
        System.out.println(BigList);
    }

    private static void addTempToBigList(List<Integer> tempList, List<List<Integer>> BigList) {
        BigList.add(tempList);
    }


}
