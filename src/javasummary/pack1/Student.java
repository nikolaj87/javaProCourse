package javasummary.pack1;

import java.util.ArrayList;
import java.util.List;

public class Student extends Human implements Playable {

    private List<Subject> listOfFinishedSubjects;

    public Student(String name) {
        super(name);
        this.listOfFinishedSubjects = new ArrayList<>();

    }

    public List<Subject> getListOfFinishedSubjects() {
        return listOfFinishedSubjects;
    }

    public void addSubjectToList(Subject subject){
        listOfFinishedSubjects.add(subject);
    }

    @Override
    public String toString() {
        return "Student{" +
                "listOfFinishedSubjects=" + listOfFinishedSubjects +
                '}';
    }

    @Override
    public void play() {
        System.out.println("i play after lessons");
    }
}
