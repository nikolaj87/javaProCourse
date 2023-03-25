package javasummary.pack1;

import java.util.ArrayList;

public class Teacher extends Human{

    private Subject subject;
    private ArrayList<Student> students = new ArrayList<>();

    public Teacher(String name, Subject subject) {
        super(name);
        this.subject = subject;
    }

    public void teachStudent(Student student){
        System.out.println("student " + student + " is listening for a Teacher " + name +
                " subject " + this.subject);

        if(!student.getListOfFinishedSubjects().contains(this.subject)){
            student.getListOfFinishedSubjects().add(this.subject);
        }

    }
}
