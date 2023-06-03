package main.java.javasummary;

class Main {

    public static void main(String[] args) {

        B bb = new B();
        B b = new B();
        b = bb;
        boolean isOk = b instanceof Main;

        boolean check = new B() instanceof Main;

    }
}
class B extends Main {

}

/*


Выберите способы получения копии объекта, доступные в Java

с помощью клонирующего конструктора
копирование ссылки на объект
с помощью метода clone интерфейса Cloneable
с помощью родительского конструктора
прямое чтение бит из памяти

Правильный ответ
с помощью клонирующего конструктора
копирование ссылки на объект
с помощью метода clone интерфейса Cloneable

    Какой принцип ООП позволяет помещать объект типа ArrayList в переменную типа List?
    Например, List<String> lines = new ArrayList<>();

    Абстракция
    Инкапсуляция
    Наследование
    Полиморфизм

    Правильный ответ
    Полиморфизм
  */

