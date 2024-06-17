fun getGreeting(): String { // Kotlin function returning String example
    return "Hello Kotlin"
}

fun sayHello(): Unit {      // Unit in Kotlin is absence of any useful type
    println(getGreeting())
}

fun sayHello_() {           // Unit can be omitted
    println(getGreeting())
}

fun getGreeting_(): String? { // null can be returned using String? type
    return null;
}

/* Functions support type inference as well.
This is what's known as single expression function */
fun getGreeting__(): String = "Hello Kotlin" // entire function definition is now a single expression

fun getGreeting___() = "Hello Kotlin" // Return type can be omitted

fun sayHello__(itemToGreet:String) { // Function with parameter example
    val msg = "Hello " + itemToGreet
    println(msg)
}

fun sayHello___(itemToGreet:String) {
    val msg = "Hello $itemToGreet" // String templates example
    println(msg)
}

// Single expression function example
fun sayHello____(itemToGreet: String) = println("Hello $itemToGreet")

// Function with two parameters example
fun sayHello_____(greeting:String, itemToGreet:String) = println("$greeting $itemToGreet")

// In Kotlin free functions without class are named top level functions

fun main() {
    println("Hello World")
    println(getGreeting())
    sayHello()
    sayHello_()
    println(getGreeting_())
    println(getGreeting__())
    println(getGreeting___())
    sayHello__("Kotlin")
    sayHello__("World")
    sayHello___("Kotlin")
    sayHello____("World")
    sayHello_____("Hello", "World")
}