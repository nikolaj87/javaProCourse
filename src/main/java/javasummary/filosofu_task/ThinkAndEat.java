package javasummary.filosofu_task;

public class ThinkAndEat {
    public static void main(String[] args) {

        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        Fork fork3 = new Fork();

         new Filosof(fork1, fork2);
         new Filosof(fork2, fork3);
         new Filosof(fork3, fork1);
    }
}
