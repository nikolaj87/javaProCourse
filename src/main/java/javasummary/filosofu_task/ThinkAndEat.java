package javasummary.filosofu_task;

public class ThinkAndEat {
    public static void main(String[] args) {

        Fork fork1 = new Fork();
        Fork fork2 = new Fork();
        Fork fork3 = new Fork();

        Filosof Sakrat = new Filosof(fork1, fork2);
        Filosof Aristotel = new Filosof(fork2, fork3);
        Filosof Nikalay = new Filosof(fork3, fork1);

        Sakrat.getThrd().start();
        Aristotel.getThrd().start();
        Nikalay.getThrd().start();

    }
}
