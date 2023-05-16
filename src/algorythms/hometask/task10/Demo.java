package algorythms.hometask.task10;

public class Demo {
    public static void main(String[] args) {

        LinkedListUser list = new LinkedListUser();


        list.pushToHead(3);
        list.pushToHead(2);
        list.pushToHead(1);
        list.pushToHead(0);

        list.pushToTail(0);
        list.pushToIndex(0, 99);

        list.print();

        System.out.println();
        System.out.println("size of the list - " + list.size());

        list.removeFirst();
        list.print();

        list.removeLast();
        list.print();

        list.remove(4);
        list.print();
    }
}
