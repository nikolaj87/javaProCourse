package main.java.javatask.adds;

import java.util.ArrayList;
import java.util.List;

public class ListNode {

    int value;
    ListNode next;

    public ListNode() {}


    public static boolean hasCycle(ListNode head) {
/* первый элемент идет в список. Берем второй. Он ссылается на любой из списка? Нет.
Ага список пока не зациклен. Помещаем второй элемент в список, берем третий. Третий ссылается
на любой из списка? Нет. Помешаем его в список и берем четвертый. И так пока не найдем Null или
не зациклимся, тоесть не сошлемся на любой из ростущего списка. Конечно не так красиво, но это
хоть понять можно.
 */

        List<ListNode> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head);
            head = head.next;
            if (list.contains(head)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        ListNode l5 = new ListNode();
        ListNode l4 = new ListNode();
        ListNode l3 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode l1 = new ListNode();

        l5.next = l3;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println("список зацикленный??? " +
                hasCycle(l1));

    }

}
