package main.java.algorythms.hometask.task8;

public class labyrinth {
    public static void main(String[] args) {

        //представим задачу в виде двумерного массива. Будем заполнять его
        //если элемент имеет индекс 0 то у нас только 1 способ дойти до него - от левого
        //или от верхнего. Остальные элементы будут суммой верхнего и левого элемента.
        //последним расчитается нижний правый. Он нам и нужен. Тоесть O (n*n)
        int n = 3, m = 4;
        System.out.println("кол-во вариантов - " + wayNumber(n, m));
    }

    private static int wayNumber (int n, int m) {
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[--n][--m];
    }





}
