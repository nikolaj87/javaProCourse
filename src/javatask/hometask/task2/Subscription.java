package javatask.hometask.task2;

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
