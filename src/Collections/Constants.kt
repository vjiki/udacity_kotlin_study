package Collections

// assign the value in compile time
// the value is always determined at compile time
// it is not possible to assign the value from a function
// it is possible to use "const" in top level of program
// or in "object" sigltone classes. Not possible to use inside
// the common classes
const val rocks = 3

// when val, the value that is assigned can be determined
// during program execution
val number = 5

const val num = 5

fun complexFunctionCall() {}

// for val we can assign the return value from a function
// because we can set it during execution
val result = complexFunctionCall()

const val CONSTANT = "top-level constant"

object Constants {
    const val CONSTANT2 = "object constant"
}

val foo = Constants.CONSTANT2

// only possibility to use const values inside the class
// is to use companion objects
// Companion objects are initialized from static constructor of the
// containing class. They are created when the object is created
class MyClass {
    companion object {
        const val CONSTANT3 = "constant inside compation"
    }
}

// Plain objects are initialized lazily on the first access to that
// object. When they first used.