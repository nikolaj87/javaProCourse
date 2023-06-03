package main.java.javatask.task3.addtask;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayGenerate {


    public static void main(String[] args) {
//// сгенерировать массив, заполнить неповторяюшимися цифрами. сделать рандомный пропуск.
////найти пропущенное число.

        ArrayGenerate task1 = new ArrayGenerate();
        int n = task1.sizeRequest("задайте размер массива от 1 до 100");
        task1.generateArray(n);
        System.out.println("сгенерированный массив: " + Arrays.toString(task1.myArray));
        System.out.println("все числа встречаются один раз. Пропущенное - " + task1.ArrayAnalize());
    }


    private int[] myArray;


    private void generateArray(int size) {                                //метод создает массив и наполняет значениями
        myArray = new int[size - 1];                              //
        boolean flag;
        for (int i = 0; i < myArray.length; i++) {                //внешний цикл отвечает за номер элемента

            while (true) {                                        //вайл пытается призначить
                int number = (int) (Math.random() * size + 1);    //случайное число
                flag = false;
                for (int j = 0; j < myArray.length; j++) {        //внутренний фор проверяет нет ли уже такого числа
                    if (myArray[j] == number) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {                                       //если нету
                    myArray[i] = number;                           //то можно его присвоить элементу из внешнего фор
                    break;
                }
            }
        }
    }

    private int sizeRequest(String message) {
        while (true) {
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (inputAnalize(str)) {
                return Integer.parseInt(str);
            } else {
                System.out.println("ошибка ввода");
            }
        }
    }

    private int ArrayAnalize() {
        int count = 0;
        for (int i = 1; i <= myArray.length; i++) {  //сложим все итерации цикла 1+2+3+4+5.....
            count = count + i - myArray[i - 1];        //и отнимем от этого числа значение всех myArray[i]
        }
        count = count + myArray.length + 1;            //добавим последнюю итерацию ведь их больше на1 чем элементов массива
        return count;
    }

    private boolean inputAnalize(String str) {   //проверим ввод пользователя

        for (int i = 1; i < 101; i++) {
            if (str.equals(String.valueOf(i))) {
                return true;
            }
        }
        return false;
    }
}
