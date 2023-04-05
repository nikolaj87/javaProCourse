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


    public abstract  <T extends Player> void play(T player);

}
