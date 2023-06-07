import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyClassTest {

    @Test
    void taxTest () {
        MyClass myClass = new MyClass();
        double expected = 0;
        double actual = myClass.tax(0);
        assertEquals(expected, actual);
    }

    @Test
    void taxTest2 () {
        MyClass myClass = new MyClass();
        double expected = 250;
        double actual = myClass.tax(1000);
        assertEquals(expected, actual);
    }

    @Test
    void taxBelowZero () {
        MyClass myClass = new MyClass();

        double income = myClass.tax(-100);

        assertThrows(MyClass.NegativeIncomeException.class, () -> myClass.tax(income));
    }
}