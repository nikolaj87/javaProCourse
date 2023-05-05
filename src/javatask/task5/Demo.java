package javatask.task5;

public class Demo {

    public static void main(String[] args) {

        Competition<SecondLeaguePlayer> leagueSecond = new Competition<>("league2");

        leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());
        leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());
        leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());
        leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());
        leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());

        System.out.println("участники лиги : " + leagueSecond);

        System.out.println("winner of " + leagueSecond.getName() + " is " +
                leagueSecond.findWinner(leagueSecond.getParticipants()));

        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        SecondLeaguePlayer.randomPlayer().play(FirstLeaguePlayer.randomPlayer());
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }
}
