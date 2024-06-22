/* By default in Kotlin classes are closed
They cannot be inherited or extended
If BasicInfoProvider is not with 'open' keyword
you will get error: this type is final, so it cannot be extended. */
class FancyInfoProvider : BasicInfoProvider() {
    override val sessionIdPrefix: String
        get() = "Fancy Session"

    // Override providerInfo property example
    override val providerInfo: String
        get() = "Fancy Info Provider"

    // Override printInfo method example
    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy Info")
    }
}