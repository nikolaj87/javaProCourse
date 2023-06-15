package javatask.adds.threads.practice2;

import java.util.concurrent.Exchanger;

public class Demo {
    public static void main(String[] args) {




        Exchanger<String> ex = new Exchanger<>();

        MyRnbl r1 = new MyRnbl(ex);
        MyRnbl r2 = new MyRnbl(ex);
        MyRnbl r3 = new MyRnbl(ex);
        MyRnbl r4 = new MyRnbl(ex);

        r1.getThrd().start();
        r2.getThrd().start();
        r3.getThrd().start();
        r4.getThrd().start();

        try {
            r1.getThrd().join();
            r2.getThrd().join();
            r3.getThrd().join();
            r4.getThrd().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }
}
