package Aquarium

class Fish (val friendly: Boolean = true, volumeNeeded: Int){
    val size: Int

    // in kotlin it is prefferable
    // to define only one constructor
    // with default parameters for optional values
    init {
        println ("first init block")
    }

    // secondary constructor
    // it will run after the primary constructor
    constructor() : this (true, 9) {
        println ("running secondary constructor")
    }

    //friendly or agressive
    // any init block will run before a secondary constructor
    init {
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }

    init {
        println("constructed fish of size $volumeNeeded final size ${this.size}")
    }

    init {
        println("last init block")
    }
}

// helper method instead of secondary constructor
// is prefferable than creating a secondary constructor
// creates a fish with size 50 and friendly
fun makeDefaultFish() = Fish (true, 50)

fun fishExample() {
    val fish = Fish(true, 20)
    println("Is the fish friendly? ${fish.friendly}. It needs volume ${fish.size}")
}