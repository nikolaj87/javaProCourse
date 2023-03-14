package javatask.hometask.task2;

public class Video {
    private String videoName;
    private int id;
    static int idCounter = 12345678;


    public Video(String videoName) {
        this.videoName = videoName;
        this.id = idCounter;
        idCounter++;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoName='" + videoName + '\'' +
                ", id=" + id +
                '}';
    }
}
