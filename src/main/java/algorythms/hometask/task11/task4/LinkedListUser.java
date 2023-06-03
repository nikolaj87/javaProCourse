package main.java.algorythms.hometask.task11.task4;

//

public class LinkedListUser {

    private Node head;


    public Node getHead() {
        return head;
    }


    static class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    //новый метод для удаления с конца списка с отступом на n элементов
    public void removeNthFromTheEnd(int n) {
        //проверим есть ли вобще хоть 1 элемент для удаления
        if (head == null) {
            System.out.println("list is empty. No element for delete");
        }
        //если число <= 1 то просто удалим последний
        if (n <= 1) {
            removeLast();
            return;
        }
        Node start = head;
        Node step = head;

        //создадим определенное расстояние между указателями
        for (int i = 0; i < n; i++) {
            //если цикл фор еще работает а мы уже пришли в конец списка - значит расстояние
            //между элем. недостижимое и нам просто надо удалить первый из листа
            if(step.next == null) {
                removeFirst();
                return;
            }
            step = step.next;
        }
        //и двигаем указатели синхронно в конец листа
        while (step.next != null) {
            step = step.next;
            start = start.next;
        }
        //пользуемся стартовым для удаления
        start.next = start.next.next;
    }

    public void remove(int index) {
        if (head == null) {
            System.out.println("list is empty. No element for delete");
        }
        //если index <= 0 то пользуемся готовым методом
        if (index <= 0) {
            removeFirst();
            return;
        }
        //иначе смещаемся на index элементов вправо и удаляем его. При привышении списка удалится последний
        Node temp = head;
        int count = 0;
        while (temp.next.next != null) {
            if (count++ == index - 1) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void removeLast() {
        //проверим есть ли вобще элемент для удаления. И предыдущему от него присвоим next = null
        if (head == null) return;
        //если всего 1 элемент то его и удаляем
        if (head.next == null) {
            removeFirst();
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void removeFirst() {
        //проверим есть ли вобще первый элемент и присвоим ХЭДу head.next
        if (head == null) return;
        head = head.next;
    }

    public int size() {
        //создадим ссылку нодэ = хэд. Пока у нее есть next, будем повышать счетчик размера листа
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void print() {
        //создадим ссылку нодэ = хэд. И будем в цикле ее печатать потом брать next.
        Node temp = head;
        System.out.print("elements of the list: ");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void pushToIndex(int index, int data) {

        if (index <= 0) {
            pushToHead(data);
            return;
        }

        Node nodeForPush = new Node(data);
        Node temp = head;

        int count = 0;
        while (temp.next != null) {
            if (count == index - 1) {
                break;
            }
            temp = temp.next;
            count++;
        }
        nodeForPush.next = temp.next;
        temp.next = nodeForPush;
    }

    public void pushToHead(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    public void pushToTail(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return;
        }
        Node temp2 = head;

        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = temp;
    }
}
