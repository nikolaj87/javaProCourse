package javatask.task13.Task1;

public class Task1 {
    // Напишите программу на Java, которая вычисляет факториал числа,
    // заданного пользователем в качестве входного параметра.
    // Если пользователь ввел отрицательное число, программа должна
    // сгенерировать исключение и вывести сообщение об ошибке "Введено
    // отрицательное число".

    public static void main(String[] args) {

        int n = -1;
        try {
            System.out.println(n + " факториал = " + task1(n));
        } catch (Task1Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static long task1(int n) throws Task1Exception{
        if(n < 0) throw new Task1Exception("n не может быть меньше 0");
        if(n == 0) return 1;
        long num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        return num;
    }


}
