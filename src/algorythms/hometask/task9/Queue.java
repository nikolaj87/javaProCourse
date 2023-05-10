package algorythms.hometask.task9;

import lombok.ToString;

@ToString

public class Queue {

    private int[] arr;      // массив для хранения элементов queue
//    private int head;       // head указывает на первый элемент в queue
// тут не понял зачем на хэад ведь в основе лежит массив. Хэад всегда arr[0]

//    private int tail;       // tail часть указывает на последний элемент в queue
// тоже самое с тэйл. Он элементарно высчитавается с помощью count

//    private final int capacity;   // максимальная емкость queue
//  можно определить через arr.length тоже лишний параметр

    private int count;      // текущий размер queue

    public Queue(int size) {
        arr = new int[size];
        count = -1;
    }

    public void pushToEnd(int data) {
        if (count == arr.length - 1) {
            System.out.println("очередь переполнена, невозможно добавить");
            return;
        }
        count++;
        arr[count] = data;

    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("очередь пуста. Невозможно удалить");
        }
        for (int i = 0; i < count; i++) {
            arr[i] = arr[i + 1];
        }
        arr[count] = 0;
        count--;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("очередь пуста");
            return 0;
        }
        return arr[0];
    }

    public boolean isEmpty() {
        return count == -1;
    }

    public int size() {
        return count + 1;
    }
}
