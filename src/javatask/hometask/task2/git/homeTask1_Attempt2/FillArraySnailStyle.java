package javatask.hometask.task2.git.homeTask1_Attempt2;

public class FillArraySnailStyle {

    private int[][] array;
    private int horizontalStart;
    private int horizontalEnd;
    private int verticalStart;
    private int verticalEnd;

    public FillArraySnailStyle(int[][] array, int horizontalStart, int horizontalEnd, int verticalStart, int verticalEnd) {
        this.array = array;
        this.horizontalStart = horizontalStart;
        this.horizontalEnd = horizontalEnd;
        this.verticalStart = verticalStart;
        this.verticalEnd = verticalEnd;
    }

    void fillArray() {

        while (horizontalStart < horizontalEnd && verticalStart < verticalEnd) {

            if (verticalEnd - verticalStart == 1) {
                horizontalEnd++;
                fillLeftToRight();
                break;
            }
            if (horizontalEnd - horizontalStart == 1) {
                fillTopToBottom();
                break;
            }
            fillLeftToRight();
            fillTopToBottom();
            fillRightToLeft();
            fillBottomToTop();

            horizontalStart++;
            horizontalEnd--;
            verticalStart++;
            verticalEnd--;
        }
    }

    void fillLeftToRight() {
        for (int i = horizontalStart; i < horizontalEnd - 1; i++) {
            array[verticalStart][i] = (int) (Math.random() * 9 + 1);
            printArray();
        }
    }
    void fillTopToBottom(){
        for (int j = verticalStart; j < verticalEnd; j++) {
            array[j][horizontalEnd - 1] = (int) (Math.random() * 9 + 1);
            printArray();
        }
    }
    void fillRightToLeft(){
        for (int i = horizontalEnd - 2; i >= horizontalStart; i--) {
            array[verticalEnd - 1][i] = (int) (Math.random() * 9 + 1);
            printArray();
        }
    }
    void fillBottomToTop(){
        for (int j = verticalEnd - 2; j > horizontalStart; j--) {
            array[j][horizontalStart] = (int) (Math.random() * 9 + 1);
            printArray();
        }
    }

    void printArray(){
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
        System.out.println();
        System.out.print("==============================================");
    }

}
