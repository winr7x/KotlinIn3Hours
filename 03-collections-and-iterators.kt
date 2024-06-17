fun sayHello(greeting:String, itemsToGreet:List<String>) {
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

fun main() {
    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    println(interestingThings.size)
    println(interestingThings.get(0))

    // Basic for-loop
    for (interestingThing in interestingThings) {
        println(interestingThing)
    }

    interestingThings.forEach {
        println(it) // it is the default Kotlin name for each element in the array
    }

    // Rename it to interestingThing
    // Lambda syntax within Kotlin
    // The idea behind Lambda syntax is that if you have a function and it's only
    // parameter is nother function then you can omit parentheses all together
    interestingThings.forEach { interestingThing ->
        println(interestingThing)
    }

    // forEachIndexed example
    interestingThings.forEachIndexed { index, interestingThing ->
        println("$interestingThing is at index $index")
    }

    // Kotlin listOf example
    val interestingThings_ = listOf("Kotlin", "Programming", "Comic Books")
    interestingThings_.forEach { interestingThing ->
        println(interestingThing)
    }

    // Kotlin mapOf example
    // Map takes in pairs
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { key, value -> println("$key -> $value") }

    // By default a collection type in Kotlin is immutable
    // Kotlin mutableListOf example
    val interesingThings__ = mutableListOf("Kotlin", "Programming", "Comic Books")
    interesingThings__.add("Dogs")

    // Kotlin mutableMapOf example
    val map_ = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    map_.put(4, "d")

    // Kotlin example of how you can pass collection type to a function
    sayHello("Hi", interesingThings__)
}