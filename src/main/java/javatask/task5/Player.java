package javatask.task5;

import java.util.Random;

public class Player<T> {

    private final String name;
    private final int age;
    private double score;
    private final T league;


    public Player(String name, int age, T l) {
        this.name = name;
        this.age = age;
        this.league = l;
    }


    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public T getLeague() {
        return league;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", league=" + league +
                '}';
    }

    public static Player<League> randomPlayer(League l) {

        String[] names = {"Nikalay", "Dima", "Vania", "Seruy",
                "Egor", "Ivan", "Michail", "Viktor", "Danik"};
        int age = 0;



        return new Player<>(names[new Random().nextInt(names.length - 1)],
                age, l);
    }

    public void play(Player<T> player) {
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
