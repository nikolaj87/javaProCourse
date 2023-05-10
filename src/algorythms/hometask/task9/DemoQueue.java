package algorythms.hometask.task9;

public class DemoQueue {
    public static void main(String[] args) {

        Queue o = new Queue(10);
        o.pushToEnd(1);
        o.pushToEnd(2);
        o.pushToEnd(3);
        System.out.println(o);
        System.out.println("пик = " + o.peek());
        System.out.println("размер = " + o.size());
        System.out.println("пустой? - " + o.isEmpty());
        o.remove();
        System.out.println(o);

    }

}
