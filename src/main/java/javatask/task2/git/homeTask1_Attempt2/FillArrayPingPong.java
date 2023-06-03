package main.java.javatask.task2.git.homeTask1_Attempt2;

public class FillArrayPingPong {


    private final int[][] array;
    private  int x;
    private  int y;
    private int method = 0;

    public FillArrayPingPong(int[][] array, int x, int y) {
        this.array = array;
        this.x = x;
        this.y = y;
    }

    void fillArrayPingPongStyle() {

        rightTop();
        for (int i = 0; i < 100; i++) {
//===========================касание Top============
            if (x == 0){
                if (method == 1) {
                    rightBottom();
                } else if (method == 4){
                    leftBottom();
                }
            }
            if (check2()) break;
//==============================касание Right========
            if (y == array[0].length - 1){
                if (method == 2){
                    leftBottom();
                } else {
                    leftTop();
                }
            }
            if (check2()) break;
//===============================касаие Bottom========
            if (x == array.length - 1) {
                if (method == 3) {
                    leftTop();
                } else {
                    rightTop();
                }
            }
            if (check2()) break;
//================================касание Left=======
            if (y == 0) {
                if (method == 4) {
                    rightTop();
                } else {
                    rightBottom();
                }
            }
            if (check2()) break;
//=====================================================
            if(i == 99) {
                System.out.println("получился бесконечный цикл\n" +
                        "попробуйте другие параметры");
                break;
            }
        }
        array[x][y] = (int) (Math.random() * 8 + 1);
        printArray();
    }

    private boolean check2(){
        return ((x == array.length - 1 && y == array[0].length - 1) ||
                (x == 0 && y == array[0].length - 1) ||
                (x == array.length - 1 && y == 0) ||
                (x == 0 && y == 0));
    }

    void printArray(){
        for (int[] ints : array) {
            System.out.println();
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
        }
        System.out.println();
        System.out.print("===================================================");
    }

    private void rightTop(){
        while (x > 0 && y < array[0].length - 1) {
            array[x][y] = (int) (Math.random() * 8 + 1);
            printArray();
            x--;
            y++;
        }
        method = 1;
    }

    private void rightBottom(){
        while (x < array.length - 1 && y < array[0].length - 1) {
            array[x][y] = (int) (Math.random() * 8 + 1);
            printArray();
            x++; y++;
        }
        method = 2;
    }

    private void leftBottom(){
        while (x < array.length - 1 && y > 0) {
            array[x][y] = (int) (Math.random() * 8 + 1);
            printArray();
            x++; y--;
        }
        method = 3;
    }
    private void leftTop(){
        while (x > 0 && y > 0) {
            array[x][y] = (int) (Math.random() * 8 + 1);
            printArray();
            x--;  y--;
        }
        method = 4;
    }

}

