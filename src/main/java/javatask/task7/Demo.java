package main.java.javatask.task7;

public class Demo {

    public static void main(String[] args) {

        Node nod13 = new Node(13);
        Node nod7 = new Node(7);
        Node nod20 = new Node(20);
        Node nod3 = new Node(3);
        Node nod9 = new Node(9);
        Node nod2 = new Node(2);
        Node nod5 = new Node(5);
        Node nod4 = new Node(4);
        Node nod6 = new Node(6);
        Node nod25 = new Node(25);
        Node nod22 = new Node(22);
        Node nod30 = new Node(30);

        Node nod50 = new Node(6);
        nod50.value = null;




        nod13.left = nod7;
        nod13.right = nod20;

        nod7.left = nod3;
        nod7.right = nod9;

        nod3.left = nod2;
        nod3.right = nod5;

        nod5.left = nod4;
        nod5.right = nod6;

        nod20.right = nod25;

        nod25.left = nod22;
        nod25.right = nod30;

        System.out.println(Node.isNodeExist(nod50));
        System.out.println(Node.getMin(nod7));
        System.out.println(Node.getMax(nod7));

        Node.inOrderTraversal(nod13);


    }



}
