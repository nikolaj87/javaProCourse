package javatask.hometask.task5;

import java.util.ArrayList;
import java.util.List;

public class Competition<T extends Player>{

    private String name;
    private final List<T> participants = new ArrayList<>();


    public Competition(String name) {
        this.name = name;
    }

    public List<T> getParticipants() {
        return participants;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "name='" + name + '\'' +
                ", participants=" + participants +
                '}';
    }

    public void addParticipant (T player) {
        participants.add(player);
    }


    public Player findWinner (List<T> list) {

        double maxScore = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                list.get(i).play(list.get(j));
            }
            if (list.get(i).getScore() > maxScore) {
                maxScore = list.get(i).getScore();
            }
        }

        List<T> champions = new ArrayList<>();
        for (T player: participants) {
            if (player.getScore() == maxScore) {
                champions.add(player);
            }
        }

        if (champions.size() == 1) {
            return champions.get(0);
        } else {
            findWinner(champions);
        }
        return champions.get(0);
    }

}
