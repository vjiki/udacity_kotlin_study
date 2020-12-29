package Aquarium

import Aquarium.generics.genericExample

fun main (args: Array<String>) {
    genericExample()
    buildAquarium()
    makeFish()
}

// only classes that implements the FishAction
// can call this function
fun feedFish (fish: FishAction) {
    //make some food then
    fish.eat()
}


fun makeFish () {
    val shark = Shark()
    val plecostomus = Plecostomus ()
    println("shark color is  ${shark.color} \n plecostomus color ${plecostomus.color} \n")

    feedFish(shark)
    feedFish(plecostomus)
}

private fun buildAquarium() {
    val myAquarium = Aquarium()

    // Kotlin calls the get() method even
    // when we access the property of the class
    println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} " +
            "Height: ${myAquarium.height} "
    )

    myAquarium.height = 80
    println("Height: ${myAquarium.height} cm")

    println("Volume ${myAquarium.volume} liters")

    val smallAquarium = Aquarium (length = 20, width = 15, height = 30)
    println("Volume small Aquarium ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish = 9)

    println("Volume small Aquarium ${myAquarium2.volume} liters" +
            "Length: ${myAquarium2.length} " +
            "Width: ${myAquarium2.width} " +
            "Height: ${myAquarium2.height} "
    )

    val myfish = Fish()
    val mydfish = makeDefaultFish()
}