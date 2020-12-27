package Spices

object MobyDickWhale {
    val author = "Herman Melville"

    fun jump () {
        // ...
    }
}

//изолированный или запечатанный класс
// этот тип похож на enum class
// но его можно наследовать но только внури класса
// Запечатанный класс не может иметь наследников
// объявленных вне класс
// NOTE: можно объявлять наследников в том же файле
// sealed позволяет
// указать все доступные варианты и
// значение по умолчанию не требуется
// Kotlin can have all name of classes statically
// at compile time
// They'are great for returning success or err
// from a network API, for example.
sealed class Seal

class SeaLion: Seal()
// морж
class Walrus: Seal()

fun matchSeak(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}

// Enum is a class.
// It is possible to add methods
// and properties
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

abstract class Spice(val name: String, val heat: Int, val spiciness: String, color: SpiceColor): SpiceColor by color {
    abstract fun prepareSpice()
}

interface Grinder {
    fun grind()
}

object Salt: Spice("salt", 1, "mild", WhiteSpiceColor) {
    override fun prepareSpice() {
        println("preparing salt")
    }
}

object YellowSpiceColor: SpiceColor {
    override val color = "yellow"
}

object WhiteSpiceColor: SpiceColor {
    override val color = "white"
}

interface SpiceColor {
    val color: String
}

class Curry(name: String, heat: Int, spiciness: String = "spicy", color: SpiceColor = YellowSpiceColor): Spice(name, heat, spiciness,color), Grinder,
        SpiceColor by color {

    override fun prepareSpice() {
        println("preparing curry")
        grind()
    }

    override fun grind() {
        println("grinding curry")
    }
}

data class SpiceContainer(var spice: Spice, val label: String = spice.name) {}