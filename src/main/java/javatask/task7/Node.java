package main.java.javatask.task7;

public class Node {
    public Node left;
    public Node right;
    public Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }

    public static boolean isNodeExist(Node node) {
        return node != null && node.value != null;
    }

    public static Node getMin(Node node) {
        if (!isNodeExist(node)) {
            return null;
        }

        if (!isNodeExist(node.left)) {
            return node;
        }
        return getMin(node.left);
    }


    public static Node getMax(Node node) {
        if (!isNodeExist(node)) {
            return null;
        }
        if (!isNodeExist(node.right)) {
            return node;
        }
        return getMax(node.right);
    }


    private static Node search(Node node, int value) {
        if (!isNodeExist(node)) {
            return null;
        }
        if(node.value == value) {
            return node;
        }
        if(value < node.value) {
            return search(node.left, value);
        }
        return search(node.right, value);
    }

    public static void inOrderTraversal(Node node) {
        if (!isNodeExist(node)) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.println("[ " + node.value + " ]");
        inOrderTraversal(node.right);
    }

    //todo
    private static void postOrderTraversal(Node node) {

    }

    //todo
    private static void directOrderTraversal(Node node) {

    }

    private static int getChildrenCount(Node node) {
        int count = 0;
        if(isNodeExist(node.left)) {
            count += 1;
        }

        if(isNodeExist(node.right)) {
            count += 1;
        }

        return count;
    }

    //todo mikhail
    private static Node getChildOrNull(Node node) {
        return isNodeExist(node.left) ? node.left : node.right;
    }

    //todo
    private static boolean remove(Node root, int value) {
        return false;
    }

    //todo mikhail
    private static int getDepth(Node root) {
        int count = 0;

        return count;
    }
}