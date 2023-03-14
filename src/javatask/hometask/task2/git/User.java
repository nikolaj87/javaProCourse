package javatask.hometask.task2.git;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Repository> repositories = new ArrayList<>();
    private ArrayList<Setting> settings = new ArrayList<>();

    public User(String name, ArrayList<Repository> repositories) {
        this.name = name;
        this.repositories = repositories;
    }

    public void addNewRepository(){
        //создаем новые репозитории
    }

    public void removeRepository(){
        System.out.println("repository delited");
    }

}
