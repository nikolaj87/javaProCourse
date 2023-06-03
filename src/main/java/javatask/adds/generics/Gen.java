package main.java.javatask.adds.generics;

class Gen<T> {

    T ob;

    Gen(T o) {
        ob = o;
    };

    T getOb() {
        return ob;
    }

    void showType(){
        System.out.println("тип - " + ob.getClass().getName());
    }
}

class GenDemo{
    public static void main(String[] args) {
        Gen<Integer> iOb;
        iOb = new Gen<Integer>(88);
        iOb.showType();

        int v = iOb.getOb();
        System.out.println("значение" + v);

        Gen<String> s = new Gen<>("test");
        s.showType();
        System.out.println(s.getOb());

    }
}
