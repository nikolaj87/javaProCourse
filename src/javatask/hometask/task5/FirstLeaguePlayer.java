package javatask.hometask.task5;

import java.util.Random;

public class FirstLeaguePlayer extends Player{

    public FirstLeaguePlayer(String name, int age) {
        super(name, age);
    }


    @Override
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

    public static FirstLeaguePlayer randomPlayer() {
        String[] names = {"Nikalay", "Dima", "Vania", "Seruy", "Egor", "Ivan", "Michail", "Viktor", "Danik"};
        return new FirstLeaguePlayer(names[new Random().nextInt(names.length - 1)],
                new Random().nextInt(6) + 10);
    }



}
