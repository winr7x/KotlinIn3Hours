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

fun main() {
    /* Creating an instance of an anonymous class using an Object expression
    Object expression example. So you don't need to create a new named class
    <anonymous object> : <class we want to extend> */
    val provider = object : PersonInfoProvider {
        override val providerInfo: String
            get() = "New Info Provider"

        fun getSessionId() = "id"
    }

    provider.printInfo(Person())
    println(provider.getSessionId())
}
