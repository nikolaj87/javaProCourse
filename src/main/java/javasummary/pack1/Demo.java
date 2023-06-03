package main.java.javasummary.pack1;

public class Demo {
    public static void main(String[] args) {


        Student student1 = new Student("Nik");
        Teacher teacher1 = new Teacher("Joe", Subject.IT);
        teacher1.teachStudent(student1);
        teacher1.teachStudent(student1);

        System.out.println(student1);

    }
}
