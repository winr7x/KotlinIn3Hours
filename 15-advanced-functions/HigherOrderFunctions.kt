/* Higher order functions and how to work with functional data types.
Higher order functions - functions that either return another function or
that take functions as parameter values. */

// Kotlin function example that takes a function parameter
fun printFilteredString1(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach {
        if (predicate(it)) {
            println(it)
        }
    }
}

/*  Kotlin function example that takes a nullable function parameter
error: reference has a nullable type 'kotlin.Function1<kotlin.String, kotlin.Boolean>?'.
Use explicit '?.invoke' to make a function-like call instead. */
fun printFilteredString2(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        // Kotlin safe invoke call on the predicate function example
        if (predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

// Store function as variable example
val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

// Kotlin function returning function example
fun getPrintPredicate(): (String) -> Boolean {
    return { it.startsWith("J") }
}

/* This standard library function is extension function because type '<T> Iterable<T>'
is extended with '.forEach(...)' method. And this is a higher order function because it takes
another function 'action: (T) -> Unit' as a parameter */
public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit {
    for (element in this) action(element)
}

/* Similarly for 'forEachIndexed()'. But this one takes an Int to represent the index
as well as the generic type T */
// public inline fun <T> Iterable<T>.forEachIndexed(action: (index: Int, T) -> Unit): Unit {
//     var index = 0
//     for (item in this) action(checkIndexOverflow(index++), item)
// }

fun main() {
    val list1 = listOf("Kotlin", "Java", "C++","Javascript")
    // Lambda example
    printFilteredString1(list1, { it.startsWith("J")})

    /* We can take use of lambda syntax, which says that if the last
    parameter of a function is a function, you can specify that as a
    Lambda outside the function body */
    printFilteredString1(list1) { it.startsWith("J")}

    // Example with null argument as predicate
    printFilteredString2(list1, null)

    // Pass in our predicate variable
    printFilteredString1(list1, predicate)

    printFilteredString1(list1, getPrintPredicate())

    val list2 = listOf("Kotlin", "Java", null, "C++","Javascript", null)

    // filterNotNull(), filter(), map() examples
    list2
        .filterNotNull()
        .filter { it.startsWith("J") }
        .map {
            it.length
        }
        .forEach {
        println(it)
    }

    // take() example. Takes the 1st 3 items from that collection
    list2
        .filterNotNull()
        .take(3)
        .forEach {
            println(it)
        }

    // takeLast() example.
    list2
        .filterNotNull()
        .takeLast(3)
        .forEach {
            println(it)
        }

    // associate() example
    list2
        .filterNotNull()
        .associate { it to it.length }
        .forEach {
            println("${it.value}, ${it.key}")
        }

    // If we just want to hold map in variable
    val map = list2
        .filterNotNull()
        .associate { it to it.length }

    // first() example
    var language = list2.first()
    println(language)

    // last example
    language = list2.last()
    println(language)

    // .filterNotNull().last() example
    language = list2.filterNotNull().last()
    println(language)

    // find() example
    language = list2.filterNotNull().find { it.startsWith("Java") }
    println(language)

    // findLast() example
    language = list2.filterNotNull().findLast { it.startsWith("Java") }
    println(language)

    // finding not existing item example
    language = list2.filterNotNull().findLast { it.startsWith("foo") }
    println(language)

    // orEmpty() example. If we want to use an empty string as the placeholder
    language = list2.filterNotNull().findLast { it.startsWith("foo") }.orEmpty()
    println("'$language'")
}