package javasummary.pack1;

import java.util.ArrayList;

public class Teacher extends Human{

    ArrayList<Student> students = new ArrayList<>();

    public void teachStudent(Student student){
        System.out.println("student " + student + " is listening for a Teacher " + name);
    }
}
