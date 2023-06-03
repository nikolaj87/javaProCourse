package main.java.javatask.task12.task1;


public class Task {
    public static void main(String[] args) {


//Задача 1: Уровень сложности 6/10
//
//        Создайте пользовательское исключение InvalidDataException,
//        которое наследуется от RuntimeException. Напишите метод, который принимает строку и выбрасывает InvalidDataException,
//        если длина строки превышает 10 символов. Поместите вызов этого метода в блок try-catch и обработайте исключение,
//        выводя сообщение об ошибке.
        String str = "some string my";
        try {
            task1(str);
        } catch (InvalidDataException e) {
            System.out.println("ошибка");
        }

        //        Задача 2: Уровень сложности 5/10
//
//        Имеется список объектов. Каждый объект имеет метод process(),
//        который может выбросить исключение ProcessFailedException. Вам нужно написать код,
//        который обрабатывает каждый объект в списке. Если при обработке какого-либо объекта возникает ProcessFailedException,
//        ваш код должен продолжить обработку остальных объектов и после обработки всех объектов выбросить исключение,
//        сообщающее, какие объекты не удалось обработать.


    }

    public static void task1(String str) {
        InvalidDataException invalidDataException = new InvalidDataException();

        if (str.length() > 10) {
            throw invalidDataException;
        }
    }

}
