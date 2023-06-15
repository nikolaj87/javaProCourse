package algorythms.hometask.task14;

import java.util.Stack;
import java.util.concurrent.Exchanger;

class RightTree implements Runnable {
    private final Thread thrd;
    private final Exchanger<Integer> ex;
    private final Tree.Node root;
    private int start;
    private final int finish;

    public RightTree(Exchanger<Integer> ex, Tree.Node root, int x, int y) {
        this.ex = ex;
        this.thrd = new Thread(this);
        this.root = root;
        this.start = x;
        this.finish = y;

    }

    public static RightTree createAndStart(Exchanger<Integer> ex, Tree.Node root, int x, int y) {
        RightTree t = new RightTree(ex, root, x, y);
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

            if (start < temp.value && temp.value < finish) {
                start = temp.value;
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