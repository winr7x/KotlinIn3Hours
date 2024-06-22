class Person(val firstName: String = "Peter", val lastName: String = "Parker") {
    var nickName: String? = null

    fun printInfo() {
        val nickNameToPrint = if(nickName != null) nickName else "no nickname"
        nickName = nickName ?: "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }
}

interface PersonInfoProvider {
    val providerInfo : String
    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface  SessionInfoProvider {
    fun getSessionId() : String
}

// We need to add 'open' keyword. Now you can inherit from this class
open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "BasicInfoProvider"

    /* Without 'open' keyword you will get error
    error: 'sessionIdPrefix' in 'BasicInfoProvider' is final and cannot be overridden.
    Kotlin forces you to mark both your classes, your properties
    and your methods as being explicitly open for extension. But with open keyword
    the property is available from the main(). If we want it to be available in out
    child classes but not to the public API, we could add protected modifier */
    protected open val sessionIdPrefix = "Session"

    override fun getSessionId(): String {
        return sessionIdPrefix
    }

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }
}

fun main() {
    val provider = FancyInfoProvider()
    provider.printInfo(Person())
    // provider.sessionIdPrefix // error: cannot access 'val sessionIdPrefix: String': it is protected in '/FancyInfoProvider'.
}
