package javatask.hometask.task5;

import java.util.Random;

public class SecondLeaguePlayer extends Player{

    public SecondLeaguePlayer(String name, int age) {
        super(name, age);
    }

    public static SecondLeaguePlayer randomPlayer() {
        String[] names = {"Nikalay", "Dima", "Vania", "Seruy", "Egor", "Ivan", "Michail", "Viktor", "Danik"};
        return new SecondLeaguePlayer(names[new Random().nextInt(names.length - 1)],
                new Random().nextInt(15) + 16);
    }

}