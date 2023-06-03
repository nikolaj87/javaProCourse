import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyClassTest {

    @Test
    public void myFunctionTest(){
        MyClass cl = new MyClass();
        int expected = 10;

        assertEquals(expected, MyClass.sum(5,5));

    }
}
