package javatask.task5;

public class Demo {

    public static void main(String[] args) {

//        Competition<> leagueSecond = new Competition<>("league2");


        FirstLeague f = new FirstLeague();
        SecondLeague s = new SecondLeague();

        Player<FirstLeague> p1 = new Player<>("1", 12, f);
        Player<FirstLeague> p2 = new Player<>("1", 12, f);
        Player<SecondLeague> p3 = new Player<>("1", 12, s);
//        Player<Integer> p4 = new Player<>("1", 12, s);

        System.out.println(p1);
        System.out.println(p2);
        p1.play(p2);
        System.out.println(p1);
        System.out.println(p2);

        System.out.println("===============================================");
        Competition<FirstLeague> fl = new Competition<>("first");
        fl.addParticipant(p1);
        fl.addParticipant(p2);
        System.out.println(fl);





//        leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());
////        leagueSecond.addParticipant(FirstLeaguePlayer.randomPlayer());
//        leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());
//        leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());
//        leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());
//        leagueSecond.addParticipant(SecondLeaguePlayer.randomPlayer());
//
//        System.out.println("участники лиги : " + leagueSecond);
//
//        System.out.println("winner of " + leagueSecond.getName() + " is " +
//                leagueSecond.findWinner(leagueSecond.getParticipants()));
//
//        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        SecondLeaguePlayer.randomPlayer().play(FirstLeaguePlayer.randomPlayer());
//        SecondLeaguePlayer.randomPlayer().play(SecondLeaguePlayer.randomPlayer());
//        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }
}
