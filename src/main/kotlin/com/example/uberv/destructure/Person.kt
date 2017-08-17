package com.example.uberv.destructure

// specified primary constructor
class Person(name: String, private val lastName: String, private val age: Int) {
    /* firstName - primary constructor parameter, doesn't generate a field
       val lastName - declared and initialized field
     */

    // Note that parameters of the primary constructor can be used in the initializer blocks.
    // They can also be used in property initializers declared in the class body
    private val firstName: String get() {
        println("Called firstName's getter")
        return field
    }
    // By default  getters and setters are generated. read-only property (val types only get getter generated)

    // Primary constructor cannot contain any code
    // Initialization code can be placed in initializer blocks, prefixed with 'init' keyword
    init {
        firstName = name
        println("Person initialized with name: $firstName")
    }

    // Secondary constructor
    constructor(firstName: String, lastName: String, age: Int, parent: Person) : this(firstName, lastName, age) {
        println("Called secondary constructor: firstName=$firstName, lastName=$lastName, age=$age, parent=$parent")
//        parent.children.add(this)
    }

    // Allows destructuring like "val (name, surname, age) = person"
    operator fun component1(): String {
        return firstName;
    }

    operator fun component2(): String {
        return lastName;
    }

    operator fun component3(): Int {
        return age;
    }

    override fun toString(): String {
        return "Person(lastName='$lastName', age=$age, firstName='$firstName')"
    }

}