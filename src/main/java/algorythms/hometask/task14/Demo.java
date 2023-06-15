package algorythms.hometask.task14;

import java.util.concurrent.Exchanger;

class Demo {
    public static void main(String[] args) {

        Tree tree = new Tree();
        tree = tree.createInvalidTree();
        System.out.println(
        tree.getRoot()
        );

//        //создадим поломанное дерево
//        Tree.Node n1 = new Tree.Node(12);
//        Tree.Node n2 = new Tree.Node(9);
//        Tree.Node n3 = new Tree.Node(7);
//        Tree.Node n4 = new Tree.Node(30);
//        Tree.Node n5 = new Tree.Node(3);
//        Tree.Node n6 = new Tree.Node(8);
//        Tree.Node n7 = new Tree.Node(15);
//        Tree.Node n8 = new Tree.Node(14);
//        Tree.Node n9 = new Tree.Node(11);
//
//        Tree tree = new Tree();
//        tree.setRoot(n1);
//
//        n1.rightChild = n7;
//        n1.leftChild = n2;
//
//        n2.rightChild = n4;
//        n2.leftChild = n3;
//
//        n3.rightChild = n6;
//        n3.leftChild = n5;
//
//        n7.rightChild = n9;
//        n7.leftChild = n8;
//
//
//        System.out.println("поломанное дерево");
//
//        tree.print();
//
//        long t = System.currentTimeMillis();

//        tree = tree.fixTree();




//        Exchanger<Integer> exchanger = new Exchanger<>();
//        LeftTree thread1 = LeftTree.createAndStart(exchanger, tree.getRoot().leftChild, 0 , tree.getRoot().value);
//        RightTree thread2 = RightTree.createAndStart(exchanger, tree.getRoot().rightChild, tree.getRoot().value, Integer.MAX_VALUE);
//
//        try {
//            thread1.getThrd().join();
//            thread2.getThrd().join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        System.out.println("time needed " + (System.currentTimeMillis() - t));
//        System.out.println("--------------------------------------");
//        tree.print();

//        tree.print();

    }
}



