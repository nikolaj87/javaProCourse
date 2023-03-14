package javatask.hometask.task2.youtube;

import java.util.ArrayList;

public class User {

    private String userName;
    private ArrayList<Video> videoList = new ArrayList<>();
    private Settings settings;
    private Subscription subscriptionList;

    private User(String userName, Settings settings) {
        this.userName = userName;
        this.settings = settings;
    }

    static class Settings {
        String language;
        String country;
        int userId;
        double amount;
        static int idCounter = 12345;


        @Override
        public String toString() {
            return "Settings{" +
                    "language='" + language + '\'' +
                    ", country='" + country + '\'' +
                    ", userId=" + userId +
                    ", amount=" + amount +
                    '}';
        }

        private Settings(String language, String country) {
            this.language = language;
            this.country = country;
            this.userId = idCounter;
            idCounter++;

        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", videoList=" + videoList +
                ", settings=" + settings +
                '}';
    }

    public static User userCreate(String userName, String language, String country){
        User newUser = new User(userName, new Settings(language, country));
        YouTubeData.users.add(newUser);
        return newUser;
    }

    public void addVideoToUserList(String name){
        Video userVideo = new Video(name);
        videoList.add(userVideo);
        YouTubeData.videos.add(userVideo);
    }

    public void removeVideoFromUserList(String name){
        videoList.remove(name);
        YouTubeData.videos.remove(name);
    }

    private void createUsersContent(){
        //создаем главную страничку,
        //подгружаем рекомендуемые видео
        //список подписок
        //историю
    }


}
