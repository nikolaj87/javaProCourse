package javatask.hometask.task2;

import javatasks.march_13_2023.User;

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
