package main.java.javatask.adds.generics;

class Gen2<T> {
    T ob;

    Gen2(T o) {
        ob = o;
    }

    static void test(Gen2<? super B> o) {
        //---
    }
}

class Demo {
    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();


        Gen2<A> w1 = new Gen2<>(a);
        Gen2<B> w2 = new Gen2<>(b);
        Gen2<C> w3 = new Gen2<>(c);
        Gen2<D> w4 = new Gen2<>(d);
        Gen2.test(w1);
        Gen2.test(w2);
//        Gen2.test(w3);
//        Gen2.test(w4);




    }

}

class A {
}

class B extends A {
}

class C extends A {
}

class D {
}


