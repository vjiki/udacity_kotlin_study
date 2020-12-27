package Aquarium

import java.lang.ArithmeticException

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishColor {
    val color: String
}

// This means implement the interface fish color
// by deferring(give) all calls to the object, gold color.
// Every time when you call the color property on this class,
// it will actually call the color propoerty on gold color.
/*class Plecostomus(fishColor: FishColor = GoldColor): FishAction, FishColor by GoldColor {

    override fun eat() {
        println("munch on algae")
    }
}*/

// now it doesn't have a body
// all its overrides are handled by interface delegation
class Plecostomus(fishColor: FishColor = GoldColor): FishAction by PrintingFishAction("a lot of algae"), FishColor by GoldColor

class Shark: AquariumFish(), FishAction {
    override val color = "gray"

    override fun eat() {
        println("hunt and eat fish")
    }
}

object GoldColor: FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val color = "red"
}

object CurryColor: FishColor {
    override val color = "yellow"
}

// override default eat method to only print
// the food that fish eat
class PrintingFishAction (val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}

interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim() {
        println("swim")
    }
}

interface FishAction {
    fun eat()
}

abstract class AquariumFish: FishAction {
    abstract val color: String
    override fun eat() = println ("yum")
}