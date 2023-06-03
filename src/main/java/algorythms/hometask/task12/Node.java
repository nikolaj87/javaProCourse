package algorythms.hometask.task12;

import java.util.Map;

public class Node {

    private final String name;
    private final Map<Node, Integer> neighbors;
    private int shortestWay;


    public Node(String name, Map<Node, Integer> neighbors) {
        this.name = name;
        this.neighbors = neighbors;
        shortestWay = Integer.MAX_VALUE;
    }


    public Map<Node, Integer> getNeighbors() {
        return neighbors;
    }
    public int getShortestWay() {
        return shortestWay;
    }
    public void setShortestWay(int shortestWay) {
        this.shortestWay = shortestWay;
    }


    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", shortestWay=" + shortestWay +
                '}';
    }
}
