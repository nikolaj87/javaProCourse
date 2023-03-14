package javatask.hometask.task2.git.homeTask1_Attempt2;

public class FillArraySnailDemo {
    public static void main(String[] args) {

        int[][] array = new int[3][5];
        int horizontalStart = 0;
        int horizontalEnd = array[0].length;
        int verticalStart = 0;
        int verticalEnd = array.length;

        FillArraySnailStyle obj = new FillArraySnailStyle(array, horizontalStart,
                horizontalEnd, verticalStart, verticalEnd);
        obj.fillArray();

    }
}
