
import static java.lang.Math.max;
import static java.lang.System.out;



public class Main {
    public static void main(String[] args) {

        Thread thrd = new Thread();
        thrd.setPriority(1);

        max(2,3);

        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        out.println("Количество ядер процессора: " + numberOfProcessors);

    }
}
