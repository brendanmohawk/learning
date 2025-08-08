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

        // Declares a typed List of Strings using Java style generics
        List<String> list = ["Hello", "World", "Groovy"]

        // Untyped lists can also be created with Groovys dynamic typing
        // Groovy infers the type as List<Object>
        def listOne = [1, 2, 3, 4, 5]
        def listTwo = ["Java", "Groovy", "Kotlin", "Maven"]
        // This allows for lists to contain mixed types
        def mixedList = [1, "Groovy", true, 3.14]
        def emptyList = []

        println "List: $list"
        println "List One: $listOne"
        println "List Two: $listTwo"
        println "Mixed List: $mixedList"
        println "Empty List: $emptyList"

        println "\n\nList Operations:"
        println "Size of list: ${list.size()}"
        println "First element: ${list[0]}"
        println "Last element: ${list[-1]}"
        println "Second to Last element: ${list[-2]}"
        println "Sublist from index 1 to 3: ${list[1..3]}"

        // '<<' operator is used to append a single element to the list
        list << "New Element"
        list.add("Another Element")
        println "List after adding elements: $list"

        // Demonstrates Maps in Groovy
        // Maps are key-value pairs, similar to dictionaries in Python or hashmaps in Java
        // Maps can be defined using the map literal syntax or the map constructor
        // Maps can have any type of keys and values, including mixed types
        println "=========== Maps in Groovy ==========\n"

        // Declares a typed Map with Integer keys and String values using Java style generics
        Map<Integer, String> map = [1: "One", 2: "Two", 3: "Three"]

        // Declares untyped maps with Groovys dynamic typing
        // Groovy infers the type as Map<Object, Object>
        def mapOne = [name: "Brendan", age: 30, city: "New York"]
        def mapTwo = [a: 1, b: 2, c: 3]
        def mapThree = ["key1": "value1", "key2": "value2"]

        // Creates an empty map (equivalent to Map<Object, Object>)
        def emptyMap = [:]

        println "Map: $map"
        println "Map One: $mapOne"
        println "Map Two: $mapTwo"
        println "Map Three: $mapThree"
        println "Empty Map: $emptyMap"

        // Common map operations
        println "Map Operations:"
        println "Size of map: ${map.size()}"
        println "Keys: ${map.keySet()}"
        println "Values: ${map.values()}"
        println "Map One Name: ${mapOne['name']}"
        println "Map Two Key 'b': ${mapTwo['b']}"
        println "Map Three Key 'key1': ${mapThree['key1']}"
        println "Get Method for Map One: ${mapOne.get('name')}"

        // Demonstrates nested collections in Groovy
        // Nested collections can be lists of lists, maps of lists, or any combination thereof
        // This is useful for representing complex data structures like matrices or JSON-like objects
        println "=========== Nested Collections ==========\n"

        // A list of lists (a 2D matrix) — a List containing other Lists of Integers
        def matrix = [
            [1, 2, 3],
            [4, 5, 6],
            [7, 8, 9]
        ]

        // Creates a map with simple key-value pairs, a list as a value,
        // and a nested map as another value
        def personMap = [
            name: "Brendan",
            age: 30,
            hobbies: ["coding", "reading", "gaming"],
            contacts: ["email": "example@email.com", "phone": "123-456-7890"]
        ]

        println "Matrix: $matrix"
        println "Person Map: $personMap"

        // Access elements in nested collections:
        // matrix[1][2] accesses row 1, column 2 (zero-based indices)
        println "Matrix[1][2]: ${matrix[1][2]}"

        // Access nested map values using dot notation
        println "Email: ${personMap.contacts.email}"

        // Access the first element in the hobbies list inside the map
        println "First hobby: ${personMap.hobbies[0]}"


    }
}