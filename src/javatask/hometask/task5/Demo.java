package javatask.hometask.task5;

public class Demo {

    public static void main(String[] args) {

        Competition<SecondLeaguePlayer> leagueSecond = new Competition<>("league2");

        for (int i = 0; i < 5; i++) {
            leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());
        }
        System.out.println(leagueSecond);
        System.out.println("winner of " + leagueSecond.getName() + " is " +
                leagueSecond.findWinner(leagueSecond.getParticipants()));

        System.out.println("==================================================================");

        Competition<FirstLeaguePlayer> leagueFirst = new Competition<>("league1");

        for (int i = 0; i < 5; i++) {
            leagueFirst.addParticipant(FirstLeaguePlayer.randomPlayer());
        }
        System.out.println(leagueFirst);
        System.out.println("winner of " + leagueFirst.getName() + " is " +
                leagueFirst.findWinner(leagueFirst.getParticipants()));

    }
}
