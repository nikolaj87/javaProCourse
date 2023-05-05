package javatask.task3.addtask;

import java.util.Scanner;

public class IntConverter {

    public static void main(String[] args) {
        //конвертировать без привлечения стринг
        // 123 в 321, -123 в -321, 120 в 21
        int num = requestNum("введите число от -999 до 999");
        System.out.println(converter(num));

    }

    static int converter(int num){

        int x = num % 10;       //достаем единицы
        int y = num % 100 - x;  //достаем десятки
        int z = (num - x - y);  //достаем сотни

        return x * 100 + y + z/100; //меняем местами единицы и сотни
    }

    private static int requestNum(String message) {
        while (true) {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (inputAnalize(str)) {
                return Integer.parseInt(str);
            } else {
                System.out.println("ошибка ввода");
            }
        }
    }

    private static boolean inputAnalize(String str) {   //проверим ввод пользователя

        for (int i = -1000; i < 1000; i++) {
            if (str.equals(String.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

}
