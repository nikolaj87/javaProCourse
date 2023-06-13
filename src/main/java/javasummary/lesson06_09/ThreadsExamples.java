package javasummary.lesson06_09;

public class ThreadsExamples {
    public static void main(String[] args) {



        Runnable r = new Runnable() {
            @Override
            public void run() {
                int count = 0;

                for (int i = 2; i < 500000; i++) {
                    boolean isPrime = true;

                    for (int j=2; j < i; j++) {
                        if (i % j == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime)
                        count++;
                }
                System.out.println("Total numbers of prime: " + count);
            }
        };
        Thread thrd1 = new Thread(r);
        thrd1.start();

        int count = 0;

        for (int i = 500000; i < 1000000; i++) {
            boolean isPrime = true;

            for (int j=2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                count++;
        }
        System.out.println("Total numbers of prime: " + count);
    }
}
