package javatask.task16_home_work;

import java.sql.SQLOutput;

public class Taska {
    public static void main(String[] args) {
        Node node11 = new Node(3);
        Node node12 = new Node(2);
        Node node13 = new Node(1);
        node11.next = node12;
        node12.next = node13;

        Node node21 = new Node(3);
        Node node22 = new Node(2);
        Node node23 = new Node(1);
        node21.next = node22;
        node22.next = node23;


        System.out.println(count(node11, node21));
    }

    public static int count(Node node1, Node node2) {

        if (node1 == null || node2 == null) {
            System.out.println("input errrrrrrrrrrrrrrrror");
            return -1;
        }

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        Node temp = node1;
        while (temp != null) {
            num1.insert(0, temp.value);
            temp = temp.next;
        }

        temp = node2;
        while (temp != null) {
            num2.insert(0, temp.value);
            temp = temp.next;
        }

        return Integer.parseInt(String.valueOf(num1))
                + Integer.parseInt(String.valueOf(num2));
    }

}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
