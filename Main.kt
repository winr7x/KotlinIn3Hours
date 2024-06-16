val name__: String = "Nate" // publicly available top level variable
                            // name__ is a non-null String

//val name__: String = null // error: null cannot be a value of a non-null type 'kotlin.String'
                            // Here is a difference between Java and Kotlin

var name___: String? = null // ? indicates that now name___ is a nullable String

var greeting: String = "hello"

val name____ = "Nate"       // Type inference
var greeting_ = "hello"     // Type inference

// var greeting = null      // error: overload resolution ambiguity between candidates: ...
                            // It doesn't know what is a null type of

fun main() {
    println("Hello Kotlin")

// greeting_ = null         // error: null cannot be a value of a non-null type 'kotlin.String'.
                            // Types are non-null by default in Kotlin

    println(greeting)

    val name: String = "Nate"
    // name = "" // error: 'val' cannot be reassigned.

    var name_: String = "Nate"
    name_ = "" // OK

    println(name)

    greeting = "hi" // mutable variable can be modified

    println(greeting)

    println(name__)

    println(greeting)

    println(name___)
}