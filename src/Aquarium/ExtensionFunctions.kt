package Aquarium

// Extension functions allow you to add
// functions to an existing class without
// having access to its source code

// we can create a new function callable with
// dot-notation on variable of this type.
fun String.hasSpaces(): Boolean {
    val found: Char? = this.find { it == ' '}
    return found != null
}

// Kotlinize the hasSpaces() function
fun String.hasSpaces2() = find {it == ' '} != null

fun extensionExample() {
    "Does it have spaces".hasSpaces() //true
}

open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int): AquariumPlant("Green", size)

//helper
fun AquariumPlant.isRed() = color == "Red"

// extension function can't have access to the private members
// the line below will give us an compilation error
//fun AquariumPlant.isBig() = size > 50

// Extension functions are always resolved statically
// based on the variable they'are applied to

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreanLeafyPlant")

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print() //GreenLeafyPlant

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print() //AquariumPlant
}

// Extension variables
val AquariumPlant.isGreen: Boolean
    get() = color =="Green"

fun propertyExample() {
    val plant = AquariumPlant("Green", 50)
    plant.isGreen // true
}

// receiver nullable
// You can also make the class you're extending,
// which is sometimes called the receiver nullable.


// this can be null
fun AquariumPlant?.pull() {
    this?.apply {
            println("removing $this")
            }
}

// that is the object on which the extension
// function is called can be null
fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull() //ok
}