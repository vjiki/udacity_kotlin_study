package Spices

fun main(args: Array<String>) {

    val curry = Curry("curry",1, "medium")

    println("curry color: ${curry.color}")

    val c1 = SpiceContainer (curry)
    println(c1)

    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", 2,"mild")),
            SpiceContainer(Curry("Red Curry", 3, "medium")),
            SpiceContainer(Curry("Green Curry", 4, "spicy")))

    for(element in spiceCabinet) println(element.label)
}