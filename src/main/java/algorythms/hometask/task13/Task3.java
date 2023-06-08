package algorythms.hometask.task13;

public class Task3 {
    public static void main(String[] args) {

        //создадим поломанное дерево
        Tree.Node n1 = new Tree.Node(13);
        Tree.Node n2 = new Tree.Node(5);
        Tree.Node n3 = new Tree.Node(8);
        Tree.Node n4 = new Tree.Node(1);
        Tree.Node n5 = new Tree.Node(30);

        Tree tree = new Tree();
        tree.setRoot(n1);

        n1.rightChild = n3;
        n1.leftChild = n2;
        n2.rightChild = n5;
        n2.leftChild = n4;

        System.out.println("поломанное дерево");

        tree.print();

        System.out.println("отремонтированное дерево");
        tree = tree.fixTree();

        tree.print();
    }
}
