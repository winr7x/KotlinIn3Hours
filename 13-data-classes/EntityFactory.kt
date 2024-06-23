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
    /* Data classes are Kotlin's way of providing very concise, immutable data types.
    By defining a class as a data class it means that it is going to generate methods such
    as equals(), hashCode() and toString() automatically for you */
    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity()

    // Custom equals() and hashCode() methods
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}

fun main() {
    val entity1 = EntityFactory.create(EntityType.EASY)
    val entity2 = EntityFactory.create(EntityType.EASY)

    // They are not equal because of different id (UUID) property value
    if (entity1 == entity2) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    val entity3 = Entity.Easy("id", "name")
    val entity4 = Entity.Easy("id", "name")
    // Now they are really equal
    if (entity3 == entity4) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    // Data classes gives us effective copy constructors
    val entity5 = entity4.copy()
    if (entity5 == entity4) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    /* We can also use named arguments with the copy constructor
    to change the value */
    val entity6 = entity5.copy(name = "new name")
    if (entity6 == entity5) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    /* Kotlin referential comparison (===) example
    Whether or not it is exact same reference or not */
    if (entity3 === entity4) {
        println("they are equal")
    } else {
        println("they are not equal")
    }

    if (entity4 === entity4) {
        println("they are equal")
    } else {
        println("they are not equal")
    }
}