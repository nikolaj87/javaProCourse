package javamain.threads.hometask;

public class Taska {
    public static void main(String[] args) throws InterruptedException {

//    1. Дан массив n-элементов. Вычислить колличество заданного символа K.
//    Выполнить обработку массива двумя способами: без потоков и с потоками.

        char[] chars = {'a', 'b', 'k', 'k', 'k', 'k', 'k', 'k', 'k', 'k', 'k', 'k', 'f', 'd', 's', 'k'};
        CharCount cc1 = new CharCount(0, chars.length / 4, chars, 'k');
        CharCount cc2 = new CharCount(chars.length / 4, chars.length / 2, chars, 'k');
        CharCount cc3 = new CharCount(chars.length / 2, (int) (chars.length * 0.75), chars, 'k');
        CharCount cc4 = new CharCount((int) (chars.length * 0.75), chars.length, chars, 'k');
        cc1.getThrd().join();
        cc2.getThrd().join();
        cc3.getThrd().join();
        cc4.getThrd().join();
        System.out.println("в массиве найдено элементов = " +
                (cc1.getCounter() + cc2.getCounter() + cc3.getCounter() + cc4.getCounter()));

//2. Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз,
//    порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.

        new Thread(new ABC(), "A").start();
        new Thread(new ABC(), "B").start();
        new Thread(new ABC(), "C").start();

//3. Написать класс МФУ на котором возможны одновременная печать и сканирование документов,
//при этом нельзя одновременно печатать два документа или сканировать (при печати
//в консоль выводится сообщения "отпечатано 1, 2, 3,... страницы", при сканировании
//то же самое только "отсканировано...", вывод в консоль с периодом в 50 мс.)


    }


//

//
//4. Написать метод, в котором 3 потока построчно пишут данные в файл (штук по 10 записей, с периодом в 20 мс)
//
//5. Написать класс Counter, в котором есть одно целочисленное поле count (инициализировано нулем).
//    В классе реализовать два метода add и sub. Первый метод увеличивает значение count на 1,
//    второй - уменьшает на 1. Запустить два потока: в первом в цикле (можно 100 раз) вызвать
//    метод add, во втором потоке столько же раз вызвать метод sub. В цикле, после каждой итерации,
//    лучше поставить Thread.sleap, чтобы лучше смоделировать ситуацию. Добиться синхронизацией потоков,
//    чтобы значение count после всех операций было равно 0. Пример, одного потока:
//    Thread thread1 = new Thread(() -> {
//        for (int i = 0; i < 10; i++) {
//            count.add();
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    });
//
//6. Написать программу, моделирующую работу порта. Корабли могут заходить в порт
//    для разгрузки / загрузки контейнеров. Количество контейнеров, находящихся в текущий
//    момент в порту и на корабле, не должно превышать заданную грузоподъемность судна и
//    емкость порта. В порту работает несколько причалов. В одном причале может стоять
//    только один корабль. Корабль может загружаться у причала, разгружаться или выполнять оба действия.
//    Нужны любые Ваши идеи. Можете даже менять условие задачи (упростить, например), но
//    модель многопоточной системы должна работать.
//
//7. Написать программу, моделирующую работу библиотеки. В библиотеке доступны к
//    чтению несколько книг. Некоторые из них можно выдавать на руки некоторые только
//    в читальный зал. Посетители могут брать одновременно по несколько книг на руки
//    и в читальный зал. Использовать можно все знания из Java, включая многопоточность.


}

class CharCount implements Runnable {

    private int counter;
    private int start;
    private final int finish;
    private final char[] chars;
    private final char elem;
    private Thread thrd;

    public int getStart() {
        return start;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Thread getThrd() {
        return thrd;
    }

    public void setThrd(Thread thrd) {
        this.thrd = thrd;
    }

    public CharCount(int start, int finish, char[] chars, char elem) {
        this.counter = 0;
        this.start = start;
        this.finish = finish;
        this.chars = chars;
        this.elem = elem;
        this.thrd = new Thread(this);
        thrd.start();
    }


    @Override
    public void run() {
        for (int i = start; i < finish; i++)
            if (chars[i] == elem) counter++;
    }
}

//-----------------------------------------------------------------------------

class ABC implements Runnable {

    static volatile char ch = 'A';
    static final Object lock = new Object();

    private void changeChar() {
        if (ch == 'A') ch = 'B';
        else if (ch == 'B') ch = 'C';
        else if (ch == 'C') ch = 'A';
    }

    @Override
    public void run() {

        synchronized (lock) {
            try {
                for (int i = 0; i < 5; i++) {

                    while (!Thread.currentThread().getName().equals(String.valueOf(ch))) lock.wait();

                    System.out.print(Thread.currentThread().getName() + " ");
                    changeChar();
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


