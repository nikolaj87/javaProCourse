package javatask.adds.enums;

public class EnumExamples {
    private String name;
    private Transport tr;

    @Override
    public String toString() {
        return "EnumExamples{" +
                "name='" + name + '\'' +
                ", tr=" + tr +
                '}';
    }

    public static void main(String[] args) {

        var ex1 = new EnumExamples();
        ex1.tr = Transport.ELECTROBIKE;
        ex1.name = "Kolia";


        int a = Transport.BUS.ordinal();
        System.out.println(a);

        for (Transport t : Transport.values()) {
            if(t.ordinal() > 1) System.out.println("more");
            else System.out.println("less");
        }



        ex1.tr =       Transport.valueOf("CAR");

        Transport[] tr = Transport.values();



        System.out.println(ex1);


        var ex2 = new EnumExamples();
        ex2.tr = Transport.CAR;
        ex2.name = "Sasha";

        EnumExamples[] e = new EnumExamples[2];
        e[0] = ex1;
        e[1] = ex2;

        for (int i = 0; i < e.length; i++) {

            switch (e[i].tr) {
                case CAR -> System.out.println(e[i].name + "sasha");
                case ELECTROBIKE -> System.out.println(e[i].name + "koli");
            }

        }


    }

}
