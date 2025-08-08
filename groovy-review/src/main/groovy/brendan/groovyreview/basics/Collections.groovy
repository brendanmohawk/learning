package brendan.groovyreview.basics

import java.util.Collection
/**
 *
 */
class Collections {



    static void main(String[] args) {


        println "=========== Collection Class ===========\n"

        // Creates a list but can define reference type as Collection
        // since List implements Collection
        Collection<String> collection = ["Groovy", "Java", "Kotlin"]
        println "Collection: $collection"
        println "Collection class: ${collection.class}"

        // Iterate over the collection
        collection.each { item ->
            println "Item: $item"
        }

        // Shorthand for iteration
        collection.each { println "Item: $it" }


    }


    
}