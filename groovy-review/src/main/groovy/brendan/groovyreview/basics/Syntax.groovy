package brendan.groovyreview.basics

/**
 * This class demonstrates basic Groovy syntax fundamentals such as 
 * variable declarations, types, operators, and core language features.
 */
class Syntax {


    // By default, if no access modifier is specified, Groovy defaults to public
    static void main(String[] args) {

        variableDelcarations()
    }


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

    static void elvisOperator() {
    }

    static void safeNavigationOperator() {
    }

    static void ranges() {
    }


    static void truthiness() {
    }

    static void instanceAndTypeChecking() {
    }








}
