package javatask.task14thread.task5;

class Thread5 implements Runnable {
    private final String name;

    public Thread5(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name);
        }
    }
}

class Task {

    public static void main(String[] args) {
//    Создайте 3 потока, каждый из которых выводит свое имя 5 раз.
//    Каждый поток должен использовать метод run() для вывода имени.

        Thread th1 = new Thread(new Thread5("поток1"));
        Thread th2 = new Thread(new Thread5("поток2"));
        Thread th3 = new Thread(new Thread5("поток3"));

        th1.start();
        th2.start();
        th3.start();
    }
}
