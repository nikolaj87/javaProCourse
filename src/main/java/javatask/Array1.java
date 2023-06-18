package javatask;

public class Array1 {

    public static void main(String[] args) {

        int[][] arr = {
                      {1, 5, 6, 8, 20},
                      {2, 7, 9, 11, 30},
                      {4, 9, 14, 18, 40},
                      {5, 16, 22, 25, 50},
                      {8, 19, 24, 29, 60}
                      };

        System.out.println(

                hasElem(arr, 16)
        );
    }

    public static boolean hasElem(int[][] arr, int elem) {
        int x = arr[0].length - 1;
        int y = 0;

        while (y < arr.length - 1 && x > 0) {
            if (arr[y][x] == elem)  return true;
            else if (arr[y][x] > elem) x--;
            else y++;
        }
        return false;
    }
}
