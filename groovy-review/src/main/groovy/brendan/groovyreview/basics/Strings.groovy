package brendan.groovyreview.basics

/**
 * This class is a placeholder for string-related operations in Groovy.
 */
class Strings {

    static void main(String[] args) {

        // Shows the difference between GString and String in Groovy
        // GString allows for string interpolation, while Strings do not
        println "\nGString vs String:"
        def gString = "Hello $name"
        def string = 'Hello $name'
        println "GString: $gString"
        println "String: $string"
        println "GString class: ${gString.class}"
        println "String class: ${string.class}"

        // Demonstrates multiline strings in Groovy
        // 
        println "Multiline Strings:"
        def multilineGString = """
            This is a multiline GString.
            It can span multiple lines and still interpolate variables like $name.
        """
        println "Multiline GString: $multilineGString"

        def multilineString = '''
            This is a multiline String.
            It does not interpolate variables like $name.
        '''
        println "Multiline String: $multilineString"

        // Demonstrates the use of slashy strings in Groovy
        // Slashy strings are useful for regular expressions and paths
        // They do not require escaping of backslashes or dollar signs
        println "\nSlashy Strings:"
        def slashedString = /This is a slashed string with no interpolation: $name/
        println "Slashed String: $slashedString"
        def regex = /\d+\.\d+/
        def windowsPath = /C:\Users\$name\Documents/

        println "Slashy: $slashy"
        println "Regex pattern: $regex"
        println "Windows path: $windowsPath"

        // Demonstrates various common string methods in Groovy
        println "\nString Methods:"
        def text = " Hello Groovy World! "

        println "Original: '$text'"
        println "Length: ${text.length()}"
        println "Trimmed: '${text.trim()}'"
        println "Uppercase: ${text.toUpperCase()}"
        println "Lowercase: ${text.toLowerCase()}"
        println "Contains 'Groovy': ${text.contains('Groovy')}"
        println "Starts with '  Hello': ${text.startsWith('  Hello')}"
        println "Ends with 'World  ': ${text.endsWith('World  ')}"
        println "Index of 'Groovy': ${text.indexOf('Groovy')}"
        println "Last index of 'o': ${text.lastIndexOf('o')}"
        println "Substring (7, 13): ${text.substring(7, 13)}"
        println "Replace 'World' with 'Universe': ${text.replace('World', 'Universe')}"
        println "Split by space: ${text.split(' ')}"
        println "Join with hyphen: ${['Hello', 'Groovy', 'World'].join('-')}"
        println "Formatted: ${String.format('Hello %s, you are %d years old.', name, 25)}"
        println "Character at index 1: ${text.charAt(1)}"
        println "Code point at index 1: ${text.codePointAt(1)}"
        println "Is empty: ${text.isEmpty()}"
        println "Is blank: ${text.isBlank()}"
        println "Repeat 3 times: ${text.repeat(3)}"

        // Demonstrates string manipulation methods
        println "\nString Manipulation:"
        def sentence = "The quick brown fox"

        println "Original: $sentence"
        println "Split by space: ${sentence.split(' ')}"
        println "Replace 'quick' with 'slow': ${sentence.replace('quick', 'slow')}"
        println "Substring 4-9: ${sentence.substring(4, 9)}"
        println "Reverse: ${sentence.reverse()}"











    }
}