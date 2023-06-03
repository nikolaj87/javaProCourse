package main.java.javamain.testSecondModule.task2;

import java.util.Set;
import java.util.TreeSet;

public class DoctorQueue {

    private Set<Visit> visits = new TreeSet<>(
            (o1, o2) ->o1.getTime().compareTo(o2.getTime()));

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(TreeSet<Visit> visits) {
        this.visits = visits;
    }
}
