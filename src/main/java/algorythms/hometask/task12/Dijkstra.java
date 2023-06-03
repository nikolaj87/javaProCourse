package algorythms.hometask.task12;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
// по аналогии с уроком создадим 6 нод. Дадим название а также мапу соседей
// где ключем мапы будет соседняя нода а значением - цена пути до нее
// При создании ноды Integer.MAXVALUE задается по умолчанию для максим пути

        Node n1 = new Node("1", new HashMap<>());
        Node n2 = new Node("2", new HashMap<>());
        Node n3 = new Node("3", new HashMap<>());
        Node n4 = new Node("4", new HashMap<>());
        Node n5 = new Node("5", new HashMap<>());
        Node n6 = new Node("6", new HashMap<>());

        //каждой ноде назначим список соседей а также цену пути до них
        n1.getNeighbors().put(n2, 7);
        n1.getNeighbors().put(n3, 9);
        n1.getNeighbors().put(n6, 14);

        n2.getNeighbors().put(n1, 7);
        n2.getNeighbors().put(n3, 10);
        n2.getNeighbors().put(n4, 15);

        n3.getNeighbors().put(n1, 9);
        n3.getNeighbors().put(n2, 10);
        n3.getNeighbors().put(n4, 11);
        n3.getNeighbors().put(n6, 2);

        n4.getNeighbors().put(n2, 15);
        n4.getNeighbors().put(n3, 11);
        n4.getNeighbors().put(n5, 6);

        n5.getNeighbors().put(n4, 6);
        n5.getNeighbors().put(n6, 9);

        n6.getNeighbors().put(n1, 14);
        n6.getNeighbors().put(n3, 2);
        n6.getNeighbors().put(n5, 9);

        //список всех нод
        List<Node> list = new ArrayList<>(Arrays.asList(n1, n2, n3, n4, n5, n6));

        //в метод будем передавать не список нод а его копию так как надо модифицировать лист
        findShortWay(n1, new ArrayList<>(list));
        list.forEach(System.out::println);

    }

    public static void findShortWay(Node start, List<Node> list) {
        //путь до начальной ноды должен быть 0
        start.setShortestWay(0);

        //в цикле берем начальную ноду и идем по списку соседей этой ноды
        while (!list.isEmpty()) {

            for (Map.Entry<Node, Integer> e : start.getNeighbors().entrySet()) {
                //кратчайшим путем будет минимальное значение между уже определенным значением минимального пути
                // и попыткой найти более короткий путь как суммы стоимости пути ОТ ноды start и цены уже пройденного пути
                e.getKey().setShortestWay(Math.min(e.getValue() + start.getShortestWay(), e.getKey().getShortestWay()));
            }

            //проработанная нода уже не нужна в листе
            list.remove(start);
            //проверим не пустой ли уже лист.
            if (list.isEmpty()) return;
            //положим в переменную старт ту ноду, путь к которой самый короткий на данный момент
            start = list.stream().reduce((o1, o2) ->
                    o1.getShortestWay() < o2.getShortestWay() ? o1 : o2).get();
        }
    }
}

