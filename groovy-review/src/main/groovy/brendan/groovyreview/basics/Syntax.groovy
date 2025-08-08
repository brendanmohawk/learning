package brendan.groovyreview.basics

/**
 * This class demonstrates basic Groovy syntax fundamentals such as 
 * variable declarations, types, operators, and core language features.
 */
class Syntax {


    // By default, if no access modifier is specified, Groovy defaults to public
    static void main(String[] args) {

        variableDelcarations()
        elvisOperator()
        safeNavigationOperator()
        ranges()
    }


    /**
     * This method demonstrates 
     */
    static void variableDelcarations() {
        // Can use def identifier for dynamic typing
        def name = "Brendan"

        // Can also specify types explicitly
        String string = "Brendan"

        // Can use other types like in Java
        def age = 25
        def isLearning = true
        def nothing = null

        // To print to standard output, use println
        println "Name: $name, Age: $age, Learning: $isLearning, Nothing: $nothing"
    }

    /**
     * This method demonstrates the use of the safe navigation operator (?.) in groovy.
     * This operator allows you to safely access properties or methods of an object that might be null
     * without throwing a NullPointerException.
     */
    static void elvisOperator() {

        def nullableValue = null

        // Uses the Elvis operator '?:' to provide a default value if the left side is null
        // If left side is not null, it returns that value
        def result = nullableValue ?: "Default Value"
        println "null ?: 'default': $result"

        // Since value is not null, it returns the actual value
        def actualValue = "Actual Value"
        def actualResult = actualValue ?: "Default Value"
        println "'Actual Value' ?: 'default': $actualResult"
    }

    /**
     * This method demonstrates the use of the safe navigation operator (?.) in groovy.
     * This operator allows you to safely access properties or methods of an object that might be null
     * without throwing a NullPointerException.
     */
    static void safeNavigationOperator() {
        // Here we try to access the 'name' property of a potentially null object
        // If 'person' is null, it will return null instead of throwing an exception
        def person = null
        def name = person?.name
        println "Safe navigation operator result: $name"

        // If 'person' is not null, it will return the value of 'name'
        person = [name: "Brendan", role: "Developer"]
        name = person?.name
        println "Safe navigation operator result: $name"

        // You can also chain safe navigation operators to navigate through multiple levels
        def role = person?.role?.toUpperCase()
        println "Role in uppercase: $role"
    }


    /**
     * Demonstrates Groovys range syntax and common operations that can be performed with ranges.
     * Ranges represent a sequence of values defined by a start and an end, and can be numeric 
     * or characters.
     */
    static void ranges() {
        // Define inclusive range from 1 to 5 using '..' operator (Includes 1 and 5)
        def range = 1..5

        // Range from 1 up to (but excluding) 5 using '..<' operator
        def rangeExclusiveEnd = 1..<5

        // Reverse inclusive range from 5 to 1
        def reverseRange = 5..1

        // Character range from 'a' to 'e' inclusive
        def charRange = 'a'..'e'

        println "Range: $range"
        println "Range Exclusive Start: $rangeExclusiveStart"
        println "Range Exclusive End: $rangeExclusiveEnd"
        println "Reverse Range: $reverseRange"
        println "Character Range: $charRange"

        // Iterate over numeric range and print each element
        range.each { println it }

        // Iterate over character range and print each character
        charRange.each { println it }

        // Can check if a value is within a range
        def isInRange = 3 in range
        println "Is 3 in range 1..5? $isInRange"

        // Use range in a for loop
        for (i in range) {
            println "Looping through range: $i"
        }

        // Ranges can also be used with collections
        def list = [1, 2, 3, 4, 5]
        // Uses range as a subscript to get a sublist (1 to 3 inclusive)
        def subList = list[1..3]
        println "Sublist from index 1 to 3: $subList"

        // Ranges can be used with strings as well
        def str = "Hello, Groovy!"
        // Uses range as a substring index (chars 0 to 4 inclusive)
        def subStr = str[0..4]
        println "Substring from index 0 to 4: $subStr"
    }

    /**
     * 
     */
    static void truthiness() {
    }

    /**
     * 
     */
    static void instanceAndTypeChecking() {
    }








}
