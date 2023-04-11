package algorythms.hometask.task5;


public class Task1 {

    public static void main(String[] args) {
        int N = 120345;
        System.out.println("сумма цифр числа = " + function(N, 10, 0));
        System.out.println("число в перевернутом виде: ");
        function2(N, 10);

    }

    static int function(int n, int multiplier, int sum) {
        if (multiplier / 10 > n) {   //условие проверяет разряды числа n (есть ли еще цифры в числе)
            return sum;
        }
        sum += (n % multiplier) / (multiplier / 10);         //собственно находим цифру и добавляем в сумму
        return function(n, multiplier * 10, sum);    //вызываем рекурсивно
    }


    static int function2(int n, int multiplier) {
        if (multiplier / 10 > n) {
            return -1;
        }
        System.out.print(((n % multiplier) / (multiplier / 10)) + " ");
        function2(n, multiplier * 10);
        return -1;
    }

}



