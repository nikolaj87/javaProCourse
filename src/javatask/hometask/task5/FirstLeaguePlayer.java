package javatask.hometask.task5;

import java.util.Random;

public class FirstLeaguePlayer extends Player{

    public FirstLeaguePlayer(String name, int age) {
        super(name, age);
    }

    public static FirstLeaguePlayer randomPlayer() {
        String[] names = {"Nikalay", "Dima", "Vania", "Seruy", "Egor", "Ivan", "Michail", "Viktor", "Danik"};
        return new FirstLeaguePlayer(names[new Random().nextInt(names.length - 1)],
                new Random().nextInt(6) + 10);
    }
}
