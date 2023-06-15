package javasummary.lesson06_09;

public class Demo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000);

        Wife wife = new Wife(account);
        Husband husband = new Husband(account);

        wife.getThrd().start();
        husband.getThrd().start();

//        while(true) {
//
//        }

    }
}
