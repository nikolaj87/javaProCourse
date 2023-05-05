package javatask.task2.git;

import java.util.ArrayList;

public class RepositoryGit implements Improvable{

    private String repositoryName;
    private ArrayList<FileGit> files = new ArrayList<>();

    public RepositoryGit(String repositoryName, ArrayList<FileGit> files) {
        this.repositoryName = repositoryName;
        this.files = files;
    }

    public void addFile(){
        System.out.println("file added");
    }

    public void removeFile(){
        System.out.println("file removed");
    }


    @Override
    public void improve() {
        System.out.println("наводим порядок в репозитории");
    }
}
