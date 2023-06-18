package javasummary.lesson06_09;

public class Demo {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(20000);

        Wife wife = new Wife(account);
        wife.getThrd().setName("Wife");

        Husband husband = new Husband(account);
        husband.getThrd().setName("Husband");

        husband.getThrd().start();
        wife.getThrd().start();


//        while(true) {
//
//        }

    }
}
