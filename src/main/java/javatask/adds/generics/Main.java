package main.java.javatask.adds.generics;

public class Main {
    public static void main(String[] args) {

        NumericFns<Double> dOb = new NumericFns<Double>(1.25);
        NumericFns<Float> fOb = new NumericFns<Float>(-1.24F);
        if (dOb.absEqual(fOb)) System.out.println("Абсолютные значения совпадают");
        else System.out.println("Абсолютные значения отличаются");

    }
}


class NumericFns<T extends Number> {
    T num;

    NumericFns(T n) {
        num = n;
    }

    double reciprocal() {
        return 1 / num.doubleValue();
    }

    double fraction() {
        return num.doubleValue() - num.intValue();
    }

    // Проверить равенство абсолютных значений двух объектов
    boolean  absEqual(NumericFns<?> ob) {
        return Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue());
    }
}

