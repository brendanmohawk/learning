package brendan.groovyreview.core.closures


/**
 * This class demonstrates the basics of closures in Groovy, and how they can be used with collections.
 *
 * A Closure is a reusable block of code that can be assigned to a variable, passed as an argument,
 * returned from a method, or executed at a later time. Closures can accept parameters, return values,
 * and implicitly refer to a single parameter via the 'it' keyword if no parameters are defined.
 *
 * Closures in groovy are similar to lambdas or anonymous functions in other languages, but they are 
 * more powerful and flexible due to Groovy's dynamic nature. Groovy closures are implemented as 
 * instances of the Closure class, which allows them to capture variables from their surrounding context
 * (lexical scoping), similar to anonymous inner classes in Java.
 */
class ClosuresAndCollections {

    static void main(String[] args) {


        // Defines a simple closure that prints a message
        def simpleClosure = { println "Hello from the closure!" }
        simpleClosure()

        // Closure with a parameter
        def greetName = { name -> println "Hello, $name!" }
        greetName("Brendan")

        // Closure with implicit 'it' parameter (only when one or no parameters are defined)
        def shoutClosure = { println it.toUpperCase() }
        shoutClosure("hello world")

        // Closure that returns a value
        // Notice that the second closure does not use the return keyword
        // since Groovy closures return the last evaluated expression by default
        def square = { int x -> return x * x }
        def square2 = { int x -> x * x }
        println "Square of 5 v1: ${square(5)}"
        println "Square of 5 v2: ${square2(5)}"







       
    }
}