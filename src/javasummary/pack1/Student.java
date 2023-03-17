package javasummary.pack1;

public class Student extends Human implements Playable {

    @Override
    public void play() {
        System.out.println("i play after lessons");
    }
}
