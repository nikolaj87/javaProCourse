package javatask.hometask.task5;

import java.util.Random;

public abstract class Player {

    private final String name;
    private final int age;
    private double score;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }


    public  <T extends Player> void play(T player) {
        int play = new Random().nextInt(3);

        switch (play) {
            case (1) -> this.setScore(this.getScore() + 1);
            case (2) -> player.setScore(player.getScore() + 1);
            case (0) -> {
                this.setScore(this.getScore() + 0.5);
                player.setScore(player.getScore() + 0.5);
            }
        }
    }

}
