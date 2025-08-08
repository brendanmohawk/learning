package brendan.groovyreview.basics

import java.util.Collection
/**
 *
 */
class Collections {



    static void main(String[] args) {

        // Demonstrates basic usage of the Collection interface in Groovy
        // and how it can be used to create lists, maps, and other collection types
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

        // Collection copying
        def originalCollection = [1, 2, 3, 4, 5]
        // Shallow copies the original collection by referencing the original collection
        // Any changes to the shallow copy will affect the original collection
        def shallowCopiedCollection = originalCollection

        // This creates an actual copy of the original collection by calling the clone method
        // to create a brand new collection object with the same elements as the original.
        // Changes to the this copy will not affect the original collection
        def realCopyCollection = originalCollection.clone()

        // Demonstrates Lists in Groovy
        println "=========== Lists in Groovy ==========\n"

        // 
        List<String> list = ["Hello", "World", "Groovy"]
        def listOne = [1, 2, 3, 4, 5]
        def listTwo = ["Java", "Groovy", "Kotlin", "Maven"]
        def mixedList = [1, "Groovy", true, 3.14]
        def emptyList = []

        println "List: $list"
        println "List One: $listOne"
        println "List Two: $listTwo"
        println "Mixed List: $mixedList"
        println "Empty List: $emptyList"

        println "List Operations:"
        println "Size of list: ${list.size()}"
        println "First element: ${list[0]}"
        println "Last element: ${list[-1]}"
        println "Second to Last element: ${list[-2]}"
        println "Sublist from index 1 to 3: ${list[1..3]}"

        list << "New Element"
        list.add("Another Element")
        println "List after adding elements: $list"

        println "=========== Maps in Groovy ==========\n"
        Map<Integer, String> map = [1: "One", 2: "Two", 3: "Three"]
        def mapOne = [name: "Brendan", age: 30, city: "New York"]
        def mapTwo = [a: 1, b: 2, c: 3]
        def mapThree = ["key1": "value1", "key2": "value2"]
        def emptyMap = [:]

        println "Map: $map"
        println "Map One: $mapOne"
        println "Map Two: $mapTwo"
        println "Map Three: $mapThree"
        println "Empty Map: $emptyMap"

        println "Map Operations:"
        println "Size of map: ${map.size()}"
        println "Keys: ${map.keySet()}"
        println "Values: ${map.values()}"
        println "Map One Name: ${mapOne['name']}"
        println "Map Two Key 'b': ${mapTwo['b']}"
        println "Map Three Key 'key1': ${mapThree['key1']}"
        println "Get Method for Map One: ${mapOne.get('name')}"

    







    }


    
}