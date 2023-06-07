public class MyClass {

    public double tax(double income) {
        double tax = 0;

        if (income < 0)
            throw new NegativeIncomeException("not negative!");

        if (income <= 20000)
            return income * 0.25;

        return tax;
    }

    public static class NegativeIncomeException extends RuntimeException {
        public NegativeIncomeException(String message) {
            super(message);
        }
    }
}
