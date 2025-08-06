package brendanddev;

import org.junit.jupiter.api.Test;


/**
 * 
 */
public class Testing {

    // Class to be tested
    class Calculator {
        public int add(int a, int b) { return a + b; }
    }

    @Test 
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assert result == 5 : "Expected 5 but got " + result;
    }






}
