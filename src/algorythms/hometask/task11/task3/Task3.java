package algorythms.hometask.task11.task3;

import algorythms.hometask.task11.task4.LinkedListUser;

public class Task3 {

    //Task 3. Given the head of a linked list,
    // remove the n-th node from the end of the list and return its head.

    //для решения исспольз самодельный линкедлист. Создадим новый метод removeNthFromTheEnd().
    public static void main(String[] args) {

        LinkedListUser list1 = new LinkedListUser();

        list1.pushToTail(10);
        list1.pushToTail(9);
        list1.pushToTail(8);
        list1.pushToTail(7);
        list1.pushToTail(6);
        list1.pushToTail(5);
        list1.pushToTail(4);
        list1.pushToTail(3);
        list1.pushToTail(2);
        list1.pushToTail(1);
        list1.print();

        int n = 3;
        System.out.println("удалим " + n + "-й c конца элемент");
        list1.removeNthFromTheEnd(n);
        list1.print();
    }
}
