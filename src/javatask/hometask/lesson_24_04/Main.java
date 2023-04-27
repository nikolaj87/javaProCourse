package javatask.hometask.lesson_24_04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /*
    1  Создать коллекцию Person
    2  У персонов должен быть имя и возраст
    3  Пройтись по коллекции персонов и если возраст больше чем
       35 то сделать имя заглавными буквами
     */
    public static void main(String[] args) {


        List<Person> list = new ArrayList<>();

        Person person1 = new Person("sfg", 22);
        Person person2 = new Person("fghjfk", 22);
        Person person3 = new Person("fhjhjf", 22);
        Person person4 = new Person("gjkjg", 22);
        Person person5 = new Person("gjkjkg", 22);
        Person person6 = new Person("tutiutiu", 11);
        Person person7 = new Person("tyuitit", 66);
        Person person8 = new Person("gjhkgk", 55);
        Person person9 = new Person("gjkgkg", 44);
        Person person10 = new Person("ghkjgk", 37);
        Person person11 = new Person("ghjkgkg", 22);

        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);
        list.add(person7);
        list.add(person8);
        list.add(person9);
        list.add(person11);
        list.add(person10);


        list.stream()
                .map(el -> {
                    if (el.getAge() > 35) {
                        el.setName(el.getName().toUpperCase());
                    }
                    return el;
                })
                .forEach(System.out::println);
    }
}
