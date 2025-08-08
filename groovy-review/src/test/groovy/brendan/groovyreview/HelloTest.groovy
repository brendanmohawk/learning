package brendan.groovyreview

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import static org.junit.jupiter.api.Assertions.*

class HelloTest {
    
    @Test
    @DisplayName("Should create Hello instance")
    void testHelloCreation() {
        def hello = new Hello()
        assertNotNull(hello)
    }
    
    @Test
    @DisplayName("Should test Groovy list operations")
    void testGroovyFeatures() {
        def list = [1, 2, 3, 4, 5]
        def doubled = list.collect { it * 2 }
        
        assertEquals([2, 4, 6, 8, 10], doubled)
        assertEquals(5, list.size())
    }
    
    @Test
    @DisplayName("Should test string interpolation")
    void testStringInterpolation() {
        def name = "Groovy"
        def message = "Hello, ${name} World!"
        
        assertEquals("Hello, Groovy World!", message)
    }
}