package brendanddev;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * This class makes use of JUnit, a popular testing framework for Java, to define and run unit tests.
 * The JUnit framework provides annotations and assertions to run tests and verify the correctness of code.
 * 
 * JUnit annotations like @Test allow for defining different test methods, while @BeforeEach, @AfterEach,
 * @BeforeAll, and @AfterAll allow for setup and teardown operations that run before or after tests. These 
 * lifecycle methods help ensure that tests are isolated and repeatable.
 * 
 * Assertions such as assertEquals are used to compare the expected and actual outcomes of a method,
 * making it clear when a test has passed or failed. If the assertion fails, JUnit reports the mismatch,
 * helping quickly identify and fix issues.
 * 
 * In this example, a simple class is defined with a method to be tested, and a test method is created to verify its functionality.
 */
public class Testing {

    // Class to be tested
    static class Calculator {
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

    /** Tests and verifies the add method */
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

    @Test
    void testSubtract() {
        int a = 5;
        int b = 3;
        int expected = 2;

        int result = calculator.subtract(a, b);
        assertEquals(expected, result, "Subtraction should work correctly");
        System.out.println("testSubtract: " + a + " - " + b + " = " + result);
    }

    @Test
    void testMultiply() {
        int a = 4;
        int b = 5;
        int expected = 20;

        int result = calculator.multiply(a, b);
        assertEquals(expected, result, "Multiplication should work correctly");
        System.out.println("testMultiply: " + a + " * " + b + " = " + result);
    }

    @Test
    void testAddNegativeNumbers() {
        int a = -2, b = -2;
        int expected = -4;

        int result = calculator.add(a, b);
        assertEquals(expected, result, "Addition of negative numbers should work correctly");
        System.out.println("testAddNegativeNumbers: " + a + " + " + b + " = " + result);
    }

    /**
     * A single test method can contain multiple assertions to verify different aspects of the code.
     */
    @Test
    void testMultipleAssertions() {
        // Multiple assertions grouped together
       assertAll("Multiple calculations",
            () -> assertEquals(4, calculator.add(2, 2), "2 + 2 should equal 4"),
            () -> assertEquals(0, calculator.subtract(5, 5), "5 - 5 should equal 0"),
            () -> assertEquals(9, calculator.multiply(3, 3), "3 * 3 should equal 9")
        );
        System.out.println("testMultipleAssertions: All assertions passed");
    }

    /**
     * Uses the @DisplayName annotation to provide a custom name for the test that is displayed
     * in the test report.
     */
    @Test
    @DisplayName("Test with custom display name")
    void testWithCustomDisplayName() {
        assertTrue(calculator.add(1, 1) > 0, "Sum should be positive");
        System.out.println("customDisplayNameTest: Custom name displayed");
    }




}
