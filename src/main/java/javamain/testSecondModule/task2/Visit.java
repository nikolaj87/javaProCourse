package main.java.javamain.testSecondModule.task2;

public class Visit{

    private String time;
    private String name;

    public Visit(String time, String name) {
        this.time = time;
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "time='" + time + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
