
fun main() {
    val person = Person()
    val person1 = Person1()
    val person2 = Person2()
    val person3 = Person3()
    val person4 = Person4("Nate", "Ebel")
    val person5 = Person5("Nate", "Ebel")
    val person6 = Person6("Nate", "Ebel")
    /* Example of class property access
       In Kotlin this is known as property access syntax
       You can reference properties directly by their name without having to
       worry about the getter or the setter */
    person6.firstName
    person6.lastName
    val person7 = Person7("Nate", "Ebel")
    person7.firstName
    person7.lastName
    /* We are using the primary constructor. Secondary constructor is not called
       Both init 1 and init 2 are called */
    val person8 = Person8("Nate", "Ebel")
    person8.lastName
    person8.firstName
    // We are using the secondary constructor without parameters
    // Both init 1 and init 2 are called and secondary constructor as well
    val person82 = Person8()

    val person9 = Person9() // OK
    val person92 = Person9("A") // OK
    val person93 = Person9("A", "B") // OK

    val person10 = Person10()
    person10.nickName = "Shades" // We can assign a value to mutable property

    val person11 = Person11()
    person11.nickName = "Shades" // Custom setter is called
    person11.nickName = "New nickname" // Custom setter is called
    println(person11.nickName) // Custom getter is called
    person11.printInfo() // Call method example

    val person11b = Person11()
    person11b.printInfo() // You will see 'no nickname' in output

    // val person14 = Person14() // error: cannot access 'class Person14 : Any': it is private in file.

    val person15 = Person15()
    // We still access internal property
    person15.nickName

    val person16 = Person16()
    // error: cannot access 'var nickName: String?': it is protected in '/Person16
    // person16.nickName

    val person17 = Person17()
    // error: cannot access 'var nickName: String?': it is private in '/Person17
    // person17.nickName

    // error: cannot access 'fun printInfo(): Unit': it is private in '/Person17
    // person17.printInfo()
}