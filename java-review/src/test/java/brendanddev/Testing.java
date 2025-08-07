package brendanddev;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * This class makes use of JUnit, a popular testing framework for Java, to define and run unit tests.
 * The JUnit framework provides annotations and assertions to run tests and verify the correctness of code.
 * 
 * JUnit annotations like @Test allow for defining different test methods, @BeforeEach and @AfterAll that allow for setup
 * and teardown 
 * 
 * In this example, a simple class is defined with a method to be tested, and a test method is created to verify its functionality.
 * The test method testAdd() uses the @Test annotation to indicate that the method is a test case.
 */
public class Testing {

    // Class to be tested
    class Calculator {
        public int add(int a, int b) { return a + b; }
        public int subtract(int a, int b) { return a - b; }
        public int multiply(int a, int b) { return a * b; }
    }

    // Instance of the Calculator class to test
    Calculator calculator = new Calculator();

    // Runs before each test method
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up test...");
    }

    // Runs after each test method
    @AfterEach
    void tearDown() {
        System.out.println("Test completed.\n");
    }

    // Runs once before all test methods
    @BeforeAll
    static void setUpAll() {
        System.out.println("Starting tests...\n");
        System.out.println("=========================");
    }

    // Runs once after all test methods
    @AfterAll
    static void tearDownAll() {
        System.out.println("=========================");
        System.out.println("All tests completed.");
    }

    @Test 
    void testAdd() {

        // Arrange
        int a = 2;
        int b = 3;
        int expected = 5;

        // Act 
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result, "Addition should work correctly");
        System.out.println("testAdd: " + a + " + " + b + " = " + result);
    }






}
