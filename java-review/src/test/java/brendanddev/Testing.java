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

        // Call the the add method
        int result = calculator.add(2, 3);

        System.out.println("Running testAdd: result = " + result);
        
        // Asser that the result should be 5
        // If the assertion fails, it will throw an AssertionError
        // with the message "Expected 5 but got <result>"
        assert result == 5 : "Expected 5 but got " + result;
    }






}
