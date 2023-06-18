package javatask;

import java.util.Comparator;

public class Number {
    public static void main(String[] args) {
        int n = 8925;


        m1(n);
    }

    public static void m1(int num) {


        int x =
                String.valueOf(num).chars()
                        .mapToObj(el -> (char) el)
                        .sorted()
                        .map(String::valueOf)
                        .map(Integer::valueOf)
                        .reduce((o1,o2)-> o1 * 10 + o2).orElse(0);

        System.out.println(x);

        int y =
                String.valueOf(num).chars()
                        .mapToObj(el -> (char) el)
                        .sorted(Comparator.reverseOrder())
                        .map(String::valueOf)
                        .map(Integer::valueOf)
                        .reduce((o1,o2)-> o1 * 10 + o2).orElse(0);

        System.out.println(x);
        System.out.println(y);
    }


}
