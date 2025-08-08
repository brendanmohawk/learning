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
        truthiness()
        instanceAndTypeChecking()
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
     * Shows Groovys truthiness rules, which determines how different values are evaluated in boolean
     * context. In Groovy, many types have implicit boolean interpretations. For example, empty collections,
     * empty strings, zero numbers, and null are considered "falsey" (treated as false), while non-empty 
     * collections, non-empty strings, non-zero numbers, and true boolean values are "truthy" (treated as true).
     */
    static void truthiness() {
        def emptyList = []                  // Falsy
        def nonEmptyList = [1, 2, 3]        // Truthy
        def nullValue = null                // Falsy
        def nonNullValue = "Hello"          // Truthy
        def zeroValue = 0                   // Falsy (zero is considered falsey)    
        def nonZeroValue = 42               // Truthy (non-zero is considered truthy)    
        def emptyString = ""                // Falsy (empty string is considered falsey)
        def nonEmptyString = "Groovy"       // Truthy (non-empty string is considered truthy)
        def falseValue = false              // Falsy (explicit false is considered falsey)
        def trueValue = true                // Truthy (explicit true is considered truthy)

        println "Is empty list truthy? ${emptyList ? 'Yes' : 'No'}"
        println "Is non-empty list truthy? ${nonEmptyList ? 'Yes' : 'No'}"
        println "Is null value truthy? ${nullValue ? 'Yes' : 'No'}"
        println "Is non-null value truthy? ${nonNullValue ? 'Yes' : 'No'}"
        println "Is zero value truthy? ${zeroValue ? 'Yes' : 'No'}"
        println "Is non-zero value truthy? ${nonZeroValue ? 'Yes' : 'No'}"
        println "Is empty string truthy? ${emptyString ? 'Yes' : 'No'}"
        println "Is non-empty string truthy? ${nonEmptyString ? 'Yes' : 'No'}"
        println "Is false value truthy? ${falseValue ? 'Yes' : 'No'}"
        println "Is true value truthy? ${trueValue ? 'Yes' : 'No'}"
    }

    /**
     * Demonstrates how to check object types and instances in Groovy.
     * Uses the 'instanceof' operator to check if an object is an instance of a specific class or interface.
     * Also shows how to retrieve the class of an object using the '.class' property and '.getClass()' method.
     */
    static void instanceAndTypeChecking() {
        def strObject = "Hello, Groovy!"
        def listObject = [1, 2, 3]
        def mapObject = [key: "value"]
        def numberObject = 42
        def booleanObject = true
        def nullObject = null
        def customObject = new CustomClass()

        println "Is strObject an instance of String? ${strObject instanceof String}"
        println "strObject.class: ${strObject.class}"
        println "strObject.getClass().getName(): ${strObject.getClass().getName()}"

        println "Is listObject an instance of List? ${listObject instanceof List}"
        println "listObject.class: ${listObject.class}"
        println "listObject.getClass().getName(): ${listObject.getClass().getName()}"

        println "Is mapObject an instance of Map? ${mapObject instanceof Map}"
        println "mapObject.class: ${mapObject.class}"
        println "mapObject.getClass().getName(): ${mapObject.getClass().getName()}"

        println "Is numberObject an instance of Number? ${numberObject instanceof Number}"
        println "numberObject.class: ${numberObject.class}"
        println "numberObject.getClass().getName(): ${numberObject.getClass().getName()}"

        println "Is booleanObject an instance of Boolean? ${booleanObject instanceof Boolean}"
        println "booleanObject.class: ${booleanObject.class}"
        println "booleanObject.getClass().getName(): ${booleanObject.getClass().getName()}"

        println "Is nullObject an instance of Object? ${nullObject instanceof Object}"
        println "nullObject.class: ${nullObject?.class}"
        println "nullObject.getClass().getName(): ${nullObject?.getClass()?.getName()}"

        println "Is customObject an instance of CustomClass? ${customObject instanceof CustomClass}"
        println "customObject.class: ${customObject.class}"
        println "customObject.getClass().getName(): ${customObject.getClass().getName()}"
    }



}
