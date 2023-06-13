package javasummary.lesson06_09;

public class Acc {

    private int sum;

    public int getSum() {
        return sum;
    }

    public synchronized void deposit(int amount){
        sum += amount;
    }

    public synchronized void withdraw(int amount){
        sum -= amount;
    }

//    Имеется счет BankAccount, на котором хранится определенная сумма денег (int sum).
//    Реализовать с помощью synchronized потокобезопасный метод пополнения счета -
//    deposit(int amount), снятия со счета - withdraw(int amount).

}
