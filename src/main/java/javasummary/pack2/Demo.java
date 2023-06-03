package main.java.javasummary.pack2;

public class Demo {
    public static void main(String[] args) {
        Car bmw = new BMW("1");
        Car bmw2 = new BMW2("2");
        Mechanic joe = new Mechanic();

        joe.service(bmw);
        joe.service(bmw2);

    }
}
