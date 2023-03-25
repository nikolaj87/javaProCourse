package algorythms.hometask.task3;

import java.util.Scanner;

public class Request {

    public static int sizeRequest() {
        while (true) {
            System.out.println("Введите размер башни от 2 до 10 деталей");
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

        for (int i = 2; i < 11; i++) {
            if (str.equals(String.valueOf(i))) {
                return true;
            }
        }
        return false;
    }

}
