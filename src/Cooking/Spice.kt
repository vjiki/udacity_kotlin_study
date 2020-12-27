package Cooking

class SimpleSpice {
    val name: String = "curry"
    val spiciness: String = "mild"
    val heat: Int
        get() = when {
            spiciness.contains("hell") -> 6
            spiciness.contains("fiery") -> 5
            spiciness.contains("spicy") -> 4
            spiciness.contains("hot") -> 3
            spiciness.contains("medium") -> 2
            spiciness.contains("mild") -> 1
            else -> 0
        }
}

class Spice (val name: String, val spiciness: String = "mild") {

    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }

    init{
        println("name: $name, spiciness: $spiciness, heat: $heat")
    }
}

fun makeSalt() =  Spice("salt")