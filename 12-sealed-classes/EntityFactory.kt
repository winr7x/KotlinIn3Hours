import java.util.UUID

enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase().capitalize()
}

object EntityFactory {
    fun create(type: EntityType) : Entity {
        val id = UUID.randomUUID().toString()
        // Kotling when example
        val name = when(type) {
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        return when(type) {
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2f)
            EntityType.HELP -> Entity.Help
        }
    }
}

// Kotlin sealed class example
sealed class Entity () {
    object Help : Entity() { // object to represent some generic static help entity within our program
        val name = "Help"
    }
    // This is now where we will create each type within out sealed class hierarchy
    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()
    /* Notice that all of these types within the sealed class all extend from Entity
    but have different types of properties. This is one of the key differentiators between
    sealed classes and enum classes. With sealed classes you can have different properties
    and methods on each of these type and the compiler can perform smart casting to allow you
    to use these different properties and methods as you like
    We can also use different types of classes itself within our sealed class: */
    //class Hard2(val id: String, val name: String, val multiplier: Float): Entity()
}

fun main() {
    val entity:Entity = EntityFactory.create(EntityType.HELP)
    val msg = when(entity) {
        Entity.Help -> "help class"
        is Entity.Easy -> "easy class"
        is Entity.Medium -> "medium class"
        is Entity.Hard -> "hard class"
    }

    println(msg)
}