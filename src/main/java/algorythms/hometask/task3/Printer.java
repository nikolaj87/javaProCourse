package main.java.algorythms.hometask.task3;

public class Printer {

    static void print(){
        for (int i = 0; i < 1; i++) {
            System.out.println("          x                    x                    x ");
        }

        for (int i = Tower.sizeGame; i >= 0; i--) {
            prepareNumbersForPrint(i);
        }

        System.out.print("==================== "  + " построение башни " + Tower.counterIteration + " ======================");
        System.out.println();
        System.out.println();
    }

    //этот метод нужен для распечатки результата. При обращении к пустому элементу списка метод возвращает единицу.
    //это надо чтоб не вылетать за пределы списка. Избегаю ошибки.
    private static void prepareNumbersForPrint(int counter){
        int firstElement;
        int secondElement;
        int thirdElement;

        if (counter > Tower.first.size()-1) {
            firstElement = 1;
        } else {
            firstElement = Tower.first.get(counter);
        }

        if (counter > Tower.second.size()-1) {
            secondElement = 1;
        } else {
            secondElement = Tower.second.get(counter);
        }

        if (counter > Tower.third.size()-1) {
            thirdElement = 1;
        } else {
            thirdElement = Tower.third.get(counter);
        }
        printBody(firstElement, secondElement, thirdElement);
    }

    private static void printBody(int x, int y, int z) {
//-----------------------------------------
        for (int i = 0; i < 10 - x / 2; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < x; i++) {
            System.out.print("x");
        }
        for (int i = 0; i < 10 - x / 2; i++) {
            System.out.print(" ");
        }
//-----------------------------------------
        for (int i = 0; i < 10 - y / 2; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < y; i++) {
            System.out.print("x");
        }
        for (int i = 0; i < 10 - y / 2; i++) {
            System.out.print(" ");
        }
//---------------------------------------------
        for (int i = 0; i < 10 - z / 2; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < z; i++) {
            System.out.print("x");
        }
        for (int i = 0; i < 10 - z / 2; i++) {
            System.out.print(" ");
        }
        System.out.println();
    }
}
