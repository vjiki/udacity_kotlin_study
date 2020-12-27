package Cooking

fun main(args: Array<String>) {
    val mySpice: SimpleSpice = SimpleSpice()
    println("name: ${mySpice.name} heat: ${mySpice.heat}")

    val spiceList: List<Spice> = listOf(
            Spice("pepper", "spicy"),
            Spice("salt","medium"),
            Spice("tabasco", "very spicy"),
            Spice("ketchup", "mild")
    )


    var spiceListSpicy = spiceList.filter{it.heat <= 5}

    for (element in spiceListSpicy) {
        println(element.name)
    }

    val spice: Spice = Spice("green")


    var salt = makeSalt()
}