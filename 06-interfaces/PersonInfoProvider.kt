class Person(val firstName: String = "Peter", val lastName: String = "Parker") {
    var nickName: String? = null

    fun printInfo() {
        val nickNameToPrint = if(nickName != null) nickName else "no nickname"
        nickName = nickName ?: "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }
}

// Kotlin interface example
interface PersonInfoProvider {
    fun printInfo(person: Person)
}

/* Abstract means it doesn't need to implement all the methods
available on the interfaces that includes, but it also can't
be instantiated */
abstract class BasicInfoProvider1 : PersonInfoProvider

class BasicInfoProvider2 : PersonInfoProvider {
    // This is different than in Java where it was an override annotation @Override
    override fun printInfo(person: Person) {
        println("printInfo")
    }

    // error: 'printInfo' hides member of supertype 'PersonInfoProvider' and needs an 'override' modifier.
    // fun printInfo(person: Person) {}
}

class BasicInfoProvider3 : PersonInfoProvider {
    override fun printInfo(person: Person) {
        println("basicInfoProvider")
        person.printInfo()
    }
}

interface PersonInfoProvider2 {
    /* In Kotlin interfaces can provide default implementations
    of an interface method */
    fun printInfo(person: Person) {
        println("basicInfoProvider")
        person.printInfo()
    }
}

class BasicInfoProvider4 : PersonInfoProvider2 {
    /* default implementation of printInfo() is already
    provided by interface */
}

interface PersonInfoProvider3 {
    // We can provide properties on our interfaces as well as methods
    val providerInfo : String /* = "Default" */ // Property initializers are not allowed in interfaces
    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

class BasicInfoProvider5 : PersonInfoProvider3 {
    // BasicInfoProvider5 class can override that providerInfo property
    override val providerInfo: String
        // We have to provide the getter
        get() = "BasicInfoProvider"

    /* If we wanted to still override printInfo we could absolutely
    do that */
    override fun printInfo(person: Person) {
        // Super implementation call
        super.printInfo(person)
        println("additional print statement")
    }
}

interface  SessionInfoProvider {
    fun getSessionId() : String
}

// Implementing multiple interfaces with a single class
class BasicInfoProvider6 : PersonInfoProvider2, SessionInfoProvider {
    override fun getSessionId(): String {
        return "Session"
    }
}

fun main() {
    // error: cannot create an instance of an abstract class.
    // val provider1 = BasicInfoProvider1()

    val provider2 = BasicInfoProvider2()
    provider2.printInfo(Person())

    val provider3 = BasicInfoProvider3()
    provider3.printInfo(Person())

    val provider4 = BasicInfoProvider4()
    provider4.printInfo(Person())

    val provider5 = BasicInfoProvider5()
    provider5.printInfo(Person())

    val provider6 = BasicInfoProvider6()
    provider6.getSessionId()

    checkTypes(provider6)
}

fun checkTypes(infoProvider: PersonInfoProvider2) {
    /* We want to check whether this PersonInfoProvider2 is also
    an instance of a SessionInfoProvider */
    if (infoProvider is SessionInfoProvider) {
        println("is a session info provider")
    } else {
        println("not a session info provider")
    }

    // !is example
    if (infoProvider !is SessionInfoProvider) {
        println("not a session info provider")
    } else {
        println("is a session info provider")
        // as is the keyword to cast something to another type
        (infoProvider as SessionInfoProvider).getSessionId()

        /* Compiler is performing smart cast for us
        We don't need to cast it manually */
        infoProvider.getSessionId()
    }
}