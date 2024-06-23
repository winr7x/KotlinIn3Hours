import java.util.UUID

// Kotling enum class example
enum class EntityType {
    EASY, MEDIUM, HARD;

    // Kotlin enum class method example
    fun getFormattedName() = name.lowercase().capitalize()
}

object EntityFactory {
    fun create(type: EntityType) : Entity {
        val id = UUID.randomUUID().toString()
        // Kotling when example
        val name = when(type) {
            // Kotlin name property example
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
        }
        return Entity(id, name)
    }
}

class Entity (val id: String, val name: String) {
    override fun toString(): String {
        return "id:$id name:$name"
    }
}

fun main() {
    val entity = EntityFactory.create(EntityType.EASY)
    println(entity)

    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
    println(mediumEntity)
}