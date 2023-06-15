package algorythms.hometask.task14;

import java.util.Stack;
import java.util.concurrent.Exchanger;

class LeftTree implements Runnable {
    private final Thread thrd;
    private final Exchanger<Integer> ex;
    private final Tree.Node root;
    private int x;
    private final int y;

    public LeftTree(Exchanger<Integer> ex, Tree.Node root, int x, int y) {
        this.ex = ex;
        this.thrd = new Thread(this);
        this.root = root;
        this.x = x;
        this.y = y;

    }

    public static LeftTree createAndStart(Exchanger<Integer> ex, Tree.Node root, int x, int y) {
        LeftTree t = new LeftTree(ex, root, x, y);
        t.thrd.start();
        return t;
    }

    public Thread getThrd() {
        return thrd;
    }

    @Override
    public void run() {

        Tree.Node temp = root;
        Stack<Tree.Node> stackForNodes = new Stack<>();

        while (temp != null || !stackForNodes.isEmpty()) {

            while (temp != null) {
                stackForNodes.push(temp);
                temp = temp.leftChild;
            }

            temp = stackForNodes.pop();

            if (x < temp.value && temp.value < y) {
                x = temp.value;
                System.out.println("ifffffff " + temp.value + thrd.getName());
            } else {
                try {
                    temp.value = ex.exchange(temp.value);
                    return;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            temp = temp.rightChild;
        }
    }

}