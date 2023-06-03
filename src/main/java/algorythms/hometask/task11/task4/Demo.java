package main.java.algorythms.hometask.task11.task4;

public class Demo {

//    Task 4. You are given the heads of two sorted linked lists list1 and list2.
//    Merge the two lists in a one sorted list. The list should be made by splicing
//    together the nodes of the first two lists. Return the head of the merged linked list.
//
//    Исспользуем для решения наш линкедлист c урока. Для слияния восспользуемся двумя указателями по аналогии
//    с сортировкой mergesort


    public static void main(String[] args) {

        LinkedListUser list1 = new LinkedListUser();
        list1.pushToTail(1);
        list1.pushToTail(4);
        list1.pushToTail(8);
        list1.pushToTail(11);
        list1.pushToTail(21);
        list1.pushToTail(33);
        list1.pushToTail(34);
        list1.pushToTail(35);
        list1.print();

        LinkedListUser list2 = new LinkedListUser();
        list2.pushToTail(2);
        list2.pushToTail(3);
        list2.pushToTail(4);
        list2.pushToTail(22);
        list2.pushToTail(23);
        list2.pushToTail(24);
        list2.print();


        System.out.println("merged list is: ");
        LinkedListUser merged = mergeLinkedListUser(list1, list2);
        merged.print();
        System.out.println("head value of the merged list is " + merged.getHead());
    }

    public static LinkedListUser mergeLinkedListUser(LinkedListUser l1, LinkedListUser l2) {

        LinkedListUser.Node pointer1 = l1.getHead();
        LinkedListUser.Node pointer2 = l2.getHead();

        LinkedListUser mergedList = new LinkedListUser();

        //меньший элемент идет в результирующий список.
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.value < pointer2.value) {
                mergedList.pushToTail(pointer1.value);
                pointer1 = pointer1.next;
            } else {
                mergedList.pushToTail(pointer2.value);
                pointer2 = pointer2.next;
            }
        }
        //проверим хвосты
        while (pointer2 != null) {
            mergedList.pushToTail(pointer2.value);
            pointer2 = pointer2.next;
        }
        while (pointer1 != null) {
            mergedList.pushToTail(pointer1.value);
            pointer1 = pointer1.next;
        }

        return mergedList;
    }
}
