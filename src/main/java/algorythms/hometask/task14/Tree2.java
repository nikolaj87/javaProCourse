package algorythms.hometask.task14;

import java.util.*;

// BST
class Tree2 {

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

    public Tree2 fixTree() {
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
        var newTree = new Tree2();
        int i = listForFix.indexOf(root);
        int j = listForFix.indexOf(root) + 1;

        while (i >= 0) newTree.add(listForFix.get(i--).value);
        while (j < listForFix.size()) newTree.add(listForFix.get(j++).value);

        return newTree;
    }


    //--------------------------------------------------------------------------
    public Node deleteNode(Node temp, int value) {
        if (temp == null) {
            System.out.println("нет элемента для удаления");
            return null;
        }

        //ищем элемент для удаления. Если меньше рута то рекурсивно двигаемся влево
        if (value < temp.value) {
            temp.leftChild = deleteNode(temp.leftChild, value);
        //иначе двигаемся рекурсивно вправо
        } else if (value > temp.value) {
            temp.rightChild = deleteNode(temp.rightChild, value);
        } else {
            // третий вариант - элемент найден и будем его удалять

            // случай без детей или с 1 ребенком прост - просто присвоим найденной ноде
            // ссылку на найденного ребенка, код вернет leftChild или rightChild или НАЛ. конец.
            if (temp.leftChild == null) return temp.rightChild;
            else if (temp.rightChild == null) return temp.leftChild;

            // НО если у ноды 2 ребенка то ситуация сложнее и будет исполняться следующий код

            //будем изменять дерево за счет правого поддерева. Минимальное значение поднимем
            temp.value = findMinValue(temp.rightChild);
            //на уровень текущей НОДЫ а в самом поддереве удалим ноду с этим значением.
            temp.rightChild = deleteNode(temp.rightChild, temp.value);
        }




        return temp;
    }
    // минимальное значение будет самой левой НОДОЙ в правом подддереве
    private int findMinValue(Node node) {
        int minValue = node.value;
        while (node.leftChild != null) {
            minValue = node.leftChild.value;
            node = node.leftChild;
        }
        return minValue;
    }

//------------------------------------------------------------------------------------

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