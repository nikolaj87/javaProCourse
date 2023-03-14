package javatask.hometask.task2.git;

import java.util.ArrayList;

public class UserGit {
    private String name;
    private ArrayList<RepositoryGit> repositories = new ArrayList<>();
    private ArrayList<SettingGit> settings = new ArrayList<>();

    public UserGit(String name, ArrayList<RepositoryGit> repositories) {
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
