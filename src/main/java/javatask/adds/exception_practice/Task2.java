package main.java.javatask.adds.exception_practice;

import java.io.IOException;

// Использование ключевого слова throws
class ThrowsDemo {
    public static char prompt(String str) throws IOException {
        System.out.print(str + ": ");
        return (char) System.in.read();
    }


    public static void main(String args[]) {
        char ch;
        try {
            ch = prompt("Введите букву");
        } catch (java.io.IOException exc) {
            System.out.println("Произошло исключение");
            ch = 'X';
        }
        System.out.println("Вы нажали клавишу " + ch);
    }
}
