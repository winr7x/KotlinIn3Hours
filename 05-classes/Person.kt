// Kotlin class definition example
class Person {
}

// Kotlin class definition short example
class Person1

// Kotlin class definition with constructor example
class Person2 constructor()

// Kotlin class definition example with parentheses
class Person3()

// Kotlin class definition example with arguments
class Person4(_firstName: String, _lastName: String)

// Kotlin class definition example with properties and init-block
class Person5(_firstName: String, _lastName: String) {
    val firstName: String
    val lastName: String

    /* init block - piece of code that is run anytime an instance of this class
       is run and you can actually have multiple init-blocks that will be
       processed in the order in which they are defined within your class body */
    init {
        firstName = _firstName
        lastName = _lastName
    }
}

/* Kotlin class definition example with properties
   and immediate initializing properties */
class Person6(_firstName: String, _lastName: String) {
    val firstName: String = _firstName
    val lastName: String = _lastName
}

// We can actually declare the property directly in the primary constructor
class Person7(val firstName: String, val lastName: String) {
}

/* So far we've been working with the primary constructor
   but it also possible to define what are known as secondary constructors */
class Person8(val firstName: String, val lastName: String) {
    init {
        println("init 1")
    }

    constructor(): this("Peter", "Parker") {
        println("secondary constructor")
    }

    init {
        println("init 2")
    }
}

// Kotlin class definition example with default parameter values
class Person9(val firstName: String = "Peter", val lastName: String = "Parker") {
}

class Person10(val firstName: String = "Peter", val lastName: String = "Parker") {
    // Unlike firstName and lastName properties nickName property is mutable
    var nickName: String? = null
}

/* For val-properties only getter is generated. For var-properties getter and setter is generated
   You can provide your own implementation of getter/setter */
class Person11(val firstName: String = "Peter", val lastName: String = "Parker") {
    // Unlike firstName and lastName properties nickName property is mutable
    var nickName: String? = null
        // Setter example
        set(value) {
            field = value // We use special keyword field to set nickName value
            println("the new nickname is $value")
        }
        // Getter example
        get() {
            println("the returned value is $field")
            return field
        }

    // Method example
    fun printInfo() {
        val nickNameToPrint = if(nickName != null) nickName else "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")

        /* Kotlin question-mark-colon ?: example - "Elvis operator"
           It will return the nickname if it is not null, and "no nickname" otherwise */
        nickName = nickName ?: "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }
}

/* Visibility modifiers within Kotlin
   In Kotlin classes, properties, methods really visibility in general
   is public by default

   We could add one of four visibility modifiers */

// Example of public visibility modifier. By default
public class Person12

/* Internal means this class is public within the module
   Because we are in single module this doesn't change anything */
internal class Person13

// Private class is only available within the file in which it is implemented
private class Person14 // error: cannot access 'class Person14 : Any': it is private in file.

class Person15() {
    // Example of internal property
    internal var nickName: String? = null
}

class Person16() {
    // Example of protected property
    // It will only be available within that class or within any subclasses
    protected var nickName: String? = null
}

class Person17() {
    // Example of private property
    // It will only be available within that class
    private var nickName: String? = null

    // Example of private method
    private fun printInfo() {
    }
}