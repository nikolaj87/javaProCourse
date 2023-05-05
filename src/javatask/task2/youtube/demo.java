package javatask.task2.youtube;


//  сорян за лютую дичь

public class demo {
    public static void main(String[] args) {

        User user1 = User.userCreate("Nikalay","rus", "Poland");
        user1.addVideoToUserList("more about cats");

        User user2 = User.userCreate("Victor","esp", "Spain");
        user2.addVideoToUserList("funny");
        user2.addVideoToUserList("scary");
        user2.removeVideoFromUserList("scary");

        System.out.println(user1);
        System.out.println(user2);

    }
}
