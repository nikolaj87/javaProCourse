package javasummary.lesson06_09;

public class BankAccount {

    private int sum;

    private void print() {
        System.out.println("поток " + Thread.currentThread().getName() +
                " остаток на счету " + sum);
    }

    public BankAccount(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public synchronized void depositMoney(int amount){
        sum += amount;
        print();
    }

    public synchronized void withdrawalMoney(int amount){
        sum -= amount;
        print();
    }

//    Имеется счет BankAccount, на котором хранится определенная сумма денег (int sum).
//    Реализовать с помощью synchronized потокобезопасный метод пополнения счета -
//    deposit(int amount), снятия со счета - withdraw(int amount).

}
