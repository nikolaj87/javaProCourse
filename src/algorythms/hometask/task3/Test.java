package algorythms.hometask.task3;

public class Test {
    public static void main(String[] args) {
        System.out.println(recurs(7));

    }

    static int recurs (int n) {
        if (n==1) return 1;
        return   (2 * recurs(n - 1) + 1);
    }

}
