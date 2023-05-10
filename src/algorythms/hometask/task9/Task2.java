package algorythms.hometask.task9;

import java.util.Arrays;

public class Task2 {
    /**
     * Задача "Кузнечик и кувшинки"
     * Есть определённое количество кувшинок, расположенных в ряд, кузнечик стоит на первой из них.
     * Он может прыгнуть на следующую кувшинку, либо перепрыгнуть через одну. Сколько существует разных
     * способов (путей) добраться до последней кувшинки? Это задача на динамическое программирование.
     */
    //задача не сложная. Практически копия предыдущей про лабиринт. До кувшинки можна добраться
    //c двух педидуших а значит формула это сумма двух предыдуших. Сложность O(n)
    public static void main(String[] args) {
        int n = 8; // n > 1
        System.out.println("у кузнечика есть " + grasshopper(n)
                + " вариантов как добраться до кувшинки " + n);
    }

    public static int grasshopper(int n) {

        int[] arr = new int[n];
        arr[0] = 1; //задам явно ведь у них нету двух соседов слева
        arr[1] = 3;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(Arrays.toString(arr));
        return arr[--n];
    }

}