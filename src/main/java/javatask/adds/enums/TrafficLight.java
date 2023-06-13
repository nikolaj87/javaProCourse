package javatask.adds.enums;

// Перечисление, представляющее цвета светофора
enum TrafficLightColor {
    RED, GREEN, YELLOW
}

// Имитация автоматизированного светофора
class TrafficLightSimulator implements Runnable {

    private TrafficLightColor tlc; // текущий цвет светофора
    boolean stop = false;          // для остановка имитации установить в true
    boolean changed = false;       // true, если светофор переключился


    TrafficLightSimulator(TrafficLightColor init) {
        tlc = init;
    }

    TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;
    }

    // Запуск имитации автоматизированного светофора
    public void run() {
        while (!stop) {
            try {
                switch (tlc) {
                    case GREEN -> Thread.sleep(1000); // зеленый на 10 секунд
                    case YELLOW -> Thread.sleep(200); // желтый на 2 секунды
                    case RED -> Thread.sleep(1200); // красный на 12 секунд
                }
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
            changeColor();
        }
    }

    // Переключение цвета светофора
    synchronized void changeColor() {
        switch (tlc) {
            case RED -> tlc = TrafficLightColor.GREEN;
            case YELLOW -> tlc = TrafficLightColor.RED;
            case GREEN -> tlc = TrafficLightColor.YELLOW;
        }

        changed = true;
        notify(); // уведомить о переключении цвета светофора
    }

    // Ожидание переключения цвета светофора
    synchronized void waitForChange() {
        try {
            while (!changed)
                wait(); // ожидать переключения цвета светофора
            changed = false;
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
    }

    // Возврат текущего цвета
    synchronized TrafficLightColor getColor() {
        return tlc;
    }

    // Прекращение имитации светофора
    synchronized void cancel() {
        stop = true;
    }
}



class TrafficLightDemo {
    public static void main(String args[]) {

        TrafficLightSimulator tl = new TrafficLightSimulator(TrafficLightColor.GREEN);
        Thread thrd = new Thread(tl);
        thrd.start();

        for (int i = 0; i < 9; i++) {
            System.out.println(tl.getColor());
            tl.waitForChange();
        }
        tl.cancel();
    }
}