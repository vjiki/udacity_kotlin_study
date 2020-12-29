package Aquarium.generics

// Declare a generic class with an upper bound and use it
// this class can be subclassed
open class WaterSupply(var needsProcessed: Boolean)

//  the water becomes clean when chemicals is added to the water
// after that no need to process the water
class TapWater : WaterSupply(needsProcessed = true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

// no need to process water from FishStore
class FishStoreWater: WaterSupply(needsProcessed = false)

// Lake Water needs to be filtered with filter
// but then it doesn't need to be processed any more.
class LakeWater : WaterSupply (needsProcessed = true) {
    fun filter() {
        needsProcessed = false
    }
}

// by default T stands for the nullable any type,
// the type at the top of the type hierarchy
// below the T type can be null because it is
// inherited from Any?
//class Aquarium<T>(val waterSupply: T)

// to exclude nullable of type T we can
// inherit it from class Any
//class Aquarium<T: Any>(val waterSupply: T)

// replace any with top level type class in hierarchy
// here T must be a water supply.
class Aquarium<T: WaterSupply>(val waterSupply: T) {

    fun addWater() {
        //check is a standard library function in Kotlin
        // that's convenient for checking the state of your class
        // it acts as an assertion and it will throw an
        // illegal exception if its argument is false

        // this reads like if the water supply does not need
        // to be processed go on to the next statement
        // otherwise, throw an exception with the provided error
        // message
        // You don't need parenthesis because the dot
        // has precedence over the exclamation mark.
        // this will give as exception if water not processed
        check(!waterSupply.needsProcessed) { "water supply needs processed" }

        println("adding water from $waterSupply")
    }
}

fun genericExample() {

    // create new aquarium and pass tapWater to it
    // we can pass TapWater instance as the value for the
    // WaterSupply parameter.
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    //val aquarium2 = Aquarium("string")
    //println(aquarium2.waterSupply)

    //val aquarium3 = Aquarium(null)
    //aquarium.waterSupply

    val aquarium4 = Aquarium(LakeWater())
    // we need to filter the water to not get exception
    // that water is processed
    aquarium4.waterSupply.filter()
    aquarium4.addWater()
}