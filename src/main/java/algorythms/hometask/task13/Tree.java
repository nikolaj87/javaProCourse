package algorythms.hometask.task13;

import java.util.*;

// BST
public class Tree {

    private Node root = null;


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    public void add(int value) {
        Node temp = new Node();
        temp.value = value;
        // Если дерево пусто, то temp становится корнем
        if (root == null) {
            root = temp;
            return;
        }
        // Дерево не пусто - ищем место в нем для temp
        Node t = root;
        while (true) {
            if (value < t.value) {
                // Нужно двигаться влево
                if (t.leftChild != null) {
                    // Левый потомок существует - переходим на него
                    t = t.leftChild;
                } else {
                    // Левого потомка не существует, значит нашли место для temp
                    t.leftChild = temp;
                    return;
                }
            } else {
                // Нужно двигаться вправо
                if (t.rightChild != null) {
                    // Правый потомок существует - переходим на него
                    t = t.rightChild;
                } else {
                    // Правого потомка не существует, значит нашли место для temp
                    t.rightChild = temp;
                    return;
                }
            }
        }
    }

    public void print() {
        pass(root);
    }

    //найдем глубину дерева итеративно
    public int findDepth() {
        //проверю есть ли хоть 1 элемент иначе глубина дерева == 0;
        if (root == null) return 0;

        //будет список родителей а также позже будет список их детей
        List<Node> parentList = new ArrayList<>();
        //в список родителей попадает рут
        parentList.add(root);
        //если есть рут то и счетчик == 1
        int counter = 1;

        while (true) {
            //делаю список детей
            List<Node> childList = new ArrayList<>();
            //для каждого родителя из списка родителей нахожу детей и добавляю в список детей
            for (Node n : parentList) {
                if (n.leftChild != null)
                    childList.add(n.leftChild);
                if (n.rightChild != null)
                    childList.add(n.rightChild);
            }
            //если удалось найти детей то этот список не пуст и можно добавить уровень к дереву++
            if (!childList.isEmpty()) counter++;
            else break;
            //на новой итерации дети становятся родителями
            parentList = childList;
        }
        return counter;
    }


    public void passNoRecurs() {
        //проверяю есть ли рут
        if (root == null) return;

        Node temp = root;
        //чтоб запоминать обратное движение по дереву лучше всего подойдет стэк
        Stack<Node> stackForNodes = new Stack<>();

        while (temp != null || !stackForNodes.isEmpty()) {
            //будем пушить ноды в стэк пока не найдем самую левую
            while (temp != null) {
                stackForNodes.push(temp);
                temp = temp.leftChild;
            }
            //достанем из стэка и напечатаем ее
            temp = stackForNodes.pop();
            System.out.print(temp.value + " ");
            //и попробуем найти правого ребенка если такой есть -
            // а если его нету то на следующей итерации такой может быть
            temp = temp.rightChild;
        }
        System.out.println();
    }


    // Обход в глубину
    private void pass(Node t) {
        if (t.leftChild != null) {
            pass(t.leftChild);
        }
        System.out.println(t.value);
        if (t.rightChild != null) {
            pass(t.rightChild);
        }
    }


    // Обход в ширину
    public void pass() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.leftChild != null) {
                queue.add(temp.leftChild);
            }
            if (temp.rightChild != null) {
                queue.add(temp.rightChild);
            }
            System.out.println(temp.value);
        }
    }

    public Tree fixTree() {
        //по аналогии с предыдущей задачей делаем полный обход дерева
        List<Node> listForFix = new ArrayList<>();
        Node temp = root;
        Stack<Node> stackForNodes = new Stack<>();
        while (temp != null || !stackForNodes.isEmpty()) {
            while (temp != null) {
                stackForNodes.push(temp);
                temp = temp.leftChild;
            }
            temp = stackForNodes.pop();
            //превратим наше дерево в список
            listForFix.add(temp);
            temp = temp.rightChild;
        }
        //отсортируем список по значению value
        listForFix = listForFix.stream()
                .sorted((Comparator.comparingInt(o -> o.value)))
                .toList();
        //создадим дерево и добавим все элементы в упорядоченом виде
        //root будет запушен первым поэтому он и останется рутом в новом дереве
        var newTree = new Tree();
        int i = listForFix.indexOf(root);
        int j = listForFix.indexOf(root) + 1;

        while (i >= 0) newTree.add(listForFix.get(i--).value);
        while (j < listForFix.size()) newTree.add(listForFix.get(j++).value);

        return newTree;
    }


    static class Node {
        int value;
        Node leftChild, rightChild;


        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}