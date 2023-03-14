package javatask.hometask.task2.git;

import java.util.ArrayList;

public class Repository {

    private String repositoryName;
    private ArrayList<File> files = new ArrayList<>();

    public Repository(String repositoryName, ArrayList<File> files) {
        this.repositoryName = repositoryName;
        this.files = files;
    }

    public void addFile(){
        System.out.println("file added");
    }

    public void removeFile(){
        System.out.println("file removed");
    }


}
