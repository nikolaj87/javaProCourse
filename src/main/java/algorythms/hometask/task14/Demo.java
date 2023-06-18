package algorythms.hometask.task14;

class Demo {
    public static void main(String[] args) {

        Tree2 tree = new Tree2();
        tree.add(10);
        tree.add(5);

        tree.add(2);
        tree.add(6);
        tree.add(20);
        tree.add(22);



        tree.print();
        tree.deleteNode(tree.getRoot(), 5);
        System.out.println("--------------------------------");
        tree.print();

    }
}



