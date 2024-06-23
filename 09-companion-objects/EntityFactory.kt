// A companion object is an object scoped to an instance of another class

interface  IdProvider {
    fun getId(): String
}

class Entity1 private constructor(val id: String) {
    companion object {
        fun create() = Entity1("id")
    }
}

class Entity2 private constructor(val id: String) {
    // Companion object with explicit name. It can be referenced
    companion object Factory : IdProvider {
        override fun getId(): String {
            return "123"
        }

        // We can also store properties without our companion objects as well
        const val id = "id"
        fun create() = Entity2(/* id */ getId())
    }
}

fun main() {
    // error: cannot access 'constructor(id: String): Entity1': it is private in '/Entity1'.
    // val entity = Entity1("id")

    /* This works because companion objects have access to private properties and methods
    of that enclosing class */
    val entity1 = Entity1.Companion.create()

    /* Can be shortened. The new companion is implicit and if you're using it from Kotlin
    you can leave it off */
    val entity2 = Entity1.create()

    val entity3 = Entity2.Factory.create()
    println(Entity2.id)
}