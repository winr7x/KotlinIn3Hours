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

sealed class Entity () {
    object Help : Entity() {
        val name = "Help"
    }
    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}

// Kotlin extension method example
fun Entity.Medium.printInfo() {
    println("Medium class $id")
}

// Kotlin extension property example
val Entity.Medium.info: String
    get() = "some info"

fun main() {
    // Case when we know direct type
    val entitiy1 = Entity.Medium("id", "name").printInfo()

    // If we don't know direct type we can rely on smart casting
    val entitiy2 = EntityFactory.create(EntityType.MEDIUM)
    if (entitiy2 is Entity.Medium) {
        entitiy2.printInfo()
        println(entitiy2.info)
    }
}