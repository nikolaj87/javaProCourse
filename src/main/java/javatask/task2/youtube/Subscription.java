package main.java.javatask.task2.youtube;

import java.util.ArrayList;

public class Subscription {

    private ArrayList<User> subscribeList;

    void addToSubscriptions(User newSubscribe){
        subscribeList.add(newSubscribe);
    }
    void removeFromSubscriptions(User name){
        subscribeList.remove(name);
    }
}
