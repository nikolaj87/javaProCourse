package javasummary.lesson06_09;

public class Chernovik {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount(20_000);

        Runnable husband = ()->{
            while (bankAccount.getSum() > 1000) {
                bankAccount.depositMoney(1_000);
//                System.out.println("Я заработал 1000, на счету теперь: " + bankAccount.getSum());
            }
        };

        Runnable wife = ()->{
            while (bankAccount.getSum() > 0) {
                bankAccount.withdrawalMoney(2_000);
//                System.out.println("Я потратила 2000, на счету теперь: " + bankAccount.getSum());
            }
        };

//        Runnable kids = ()->{
//            while (bankAccount.getSum() > 0) {
//
//                bankAccount.withdrawalMoney(2_000);
//                System.out.println("ДЕТИ потратили 2000, на счету теперь: " + bankAccount.getSum());
//
//            }
//        };

        Thread husbandThread = new Thread(husband);
        husbandThread.setName("Husband");


        Thread wifeThread = new Thread(wife);
        wifeThread.setName("Wife");
//        Thread kidsThread = new Thread(kids);
//        kidsThread.setName("Kids");

        husbandThread.start();
        wifeThread.start();
//        kidsThread.start();

        husbandThread.join();
        wifeThread.join();
//        kidsThread.join();

    }
}