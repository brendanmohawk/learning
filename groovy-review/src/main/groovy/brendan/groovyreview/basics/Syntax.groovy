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
     * 
     */
    static void ranges() {
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
