/* An object declarations is an convenient way of creating
thread-safe singletons within Kotlin */

object EntityFactory {
    fun create() = Entity("id", "name")
}

class Entity (val id: String, val name: String) {
    override fun toString(): String {
        return "id:$id name:$name"
    }
}

fun main() {
    val entity = EntityFactory.create()
    println(entity)
}