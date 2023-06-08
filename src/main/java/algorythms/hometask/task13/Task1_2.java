package algorythms.hometask.task13;

public class Task1_2 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(10);
        tree.add(5);
        tree.add(2);
        tree.add(6);
        tree.add(5);
        tree.add(20);
        tree.print();
        System.out.println();
        tree.pass();
        System.out.println("-------------------------");

//        Task 1. Реализуйте итерационный (не рекурсивный - мы его сделали!) алгоритм
//        обхода дерева в глубину.

        tree.passNoRecurs();
        System.out.println("--------------------------");

//        Task 2*. Реализуйте алгоритм вычисления высоты дерева.

        System.out.println("глубина дерева = " + tree.findDepth());


    }
}
