package javasummary.lesson06_09;

public class Husband implements Runnable {

    private final Thread thrd;
    private final BankAccount account;

    public Husband(BankAccount account) {
        this.account = account;
        thrd = new Thread(this);
    }

    public Thread getThrd() {
        return thrd;
    }

    @Override
    public void run() {
        while (account.getSum() >= 2000) {
            account.depositMoney(1000);
//            System.out.println("муж заработал 1000 осталось " + account.getSum());
//            try {
//                Thread.sleep(0);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
