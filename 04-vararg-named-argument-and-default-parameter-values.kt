// Kotlin vararg parameter example
// vararg represents a variable number of arguments
// func will support zero, one or any other number of arguments values to be passed in
fun sayHello(greeting:String, vararg itemsToGreet:String) {
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

fun greetPerson(greeting: String, name: String) = println("$greeting $name")

// Default parameters values example
fun greetPerson_(greeting: String = "Hello", name: String = "Kotlin") = println("$greeting $name")

fun main() {
    sayHello("Hi") // second parameter is empty
    sayHello("Hi", "Kotlin") // An array of size 1: ["Kotlin"]
    sayHello("Hi", "Kotlin", "Programming", "Comic Books") // An array of size 3

    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    // sayHello("Hi", interestingThings)
    // error: argument type mismatch: actual type is 'kotlin.Array<kotlin.String>', but 'kotlin.String' was expected.

    // To avoid the error use spread operator *
     sayHello("Hi", *interestingThings)

    // Named arguments Kotlin example
    greetPerson(greeting = "hi", name = "Nate")
    greetPerson(name = "Nate", greeting = "hi")  // Arguments order is not important in this case
    greetPerson_(name = "Nate") // Default 1st parameter value "Hello" is used
    greetPerson_() // Both defeault parameter values are used: "Hello" nad "Kotlin

    // Named argument and normal argument at the same time example
    sayHello(greeting = "Hello", *interestingThings)
}