package main.java.javatask.task12.task2;


import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
//        Задача 2: Уровень сложности 5/10
//        Имеется список объектов. Каждый объект имеет метод process(),
//        который может выбросить исключение ProcessFailedException. Вам нужно написать код,
//        который обрабатывает каждый объект в списке. Если при обработке какого-либо объекта возникает ProcessFailedException,
//        ваш код должен продолжить обработку остальных объектов и после обработки всех объектов выбросить исключение,
//        сообщающее, какие объекты не удалось обработать.

        Task2 t = new Task2();
        t.workWithO(new ArrayList<>());
    }

    public void workWithO(List<O> list) {
        List<O> fail = new ArrayList<>();
        for (O o : list) {
            try {
                o.process();
            } catch (ProcessFailedException e) {
                fail.add(o);
            }
        }
        System.out.println("обьекты которые выкинули исключение: " + fail);
    }
}

class ProcessFailedException extends Exception {
    public ProcessFailedException(String message) {
        super(message);
    }
}

class O {
    public void process() throws ProcessFailedException {
        //doing smth
    }
}





