package main.java.javatask.adds.threads.thread_book;

// Демонстрация потоков с разными приоритетами
class Priority implements Runnable {
    int count;
    Thread thrd;

    static boolean stop = false;
    static String currentName;

    // Конструктор нового потока
    Priority(String name) {
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    // Точка входа для потока
    public void run() {
        System.out.println(thrd.getName() + " - запуск.");

        do {
            count++;

            if (currentName.compareTo(thrd.getName()) != 0) {
                currentName = thrd.getName();
                System.out.println("В " + currentName);
            }
        } while (stop == false && count < 10_000_000);


        stop = true;
        System.out.println("\n" + thrd.getName() + " - прерывание.");
    }
}

class PriorityDemo {
    public static void main(String args[]) {
        Priority mt1 = new Priority("Высокий приоритет");
        Priority mt2 = new Priority("Низкий приоритет");
        Priority mt3 = new Priority("Обычный приоритет #1");
        Priority mt4 = new Priority("Обычный приоритет #2");
        Priority mt5 = new Priority("Обычный приоритет #3");

// Присваивание приоритетов
        mt1.thrd.setPriority(Thread.NORM_PRIORITY + 4);
        mt2.thrd.setPriority(Thread.NORM_PRIORITY - 4);
// Потоки mt3, mt4 и mt5 имеют обычный приоритет,
// заданный по умолчанию
// Запуск потоков
        mt1.thrd.start();
        mt2.thrd.start();
        mt3.thrd.start();
        mt4.thrd.start();
        mt5.thrd.start();

        try {
            mt1.thrd.join();
            mt2.thrd.join();
            mt3.thrd.join();
            mt4.thrd.join();
            mt5.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Прерван основной поток.");
        }
        System.out.println("\nСчетчик потока с высоким приоритетом: " + mt1.count / 100000);
        System.out.println("Счетчик потока с низким приоритетом: " + mt2.count / 100000);
        System.out.println("Счетчик 1-го потока с обычным приоритетом: " + mt3.count / 100000);
        System.out.println("Счетчик 2-го потока с обычным приоритетом: " + mt4.count / 100000);
        System.out.println("Счетчик 3-го потока с обычным приоритетом: " + mt5.count / 100000);
    }
}

