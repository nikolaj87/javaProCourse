package javasummary.lesson06_09;

public class Wife implements Runnable {

    private Thread thrd;
    private final BankAccount account;

    public Wife(BankAccount account) {
        this.account = account;
        thrd = new Thread(this);
    }

    public Thread getThrd() {
        return thrd;
    }

    @Override
    public void run() {
        while (account.getSum() >= 0) {
            account.withdrawalMoney(2000);
//            System.out.println("ЖЕНА потратила 1111 осталось " + account.getSum());
//            try {
//                Thread.sleep(0);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
