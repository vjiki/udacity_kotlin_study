fun main(args: Array<String>) {
    println (whatShouldIDoToday ("happy"))
    println (whatShouldIDoToday ("sad", "rainy", 0))
    println (whatShouldIDoToday("xz",temperature = 36))

    eagerExample ()

    println (whatShouldIDoToday(readLine()!!))
}

fun isHappyAndSunny (mood: String, weather: String) = mood == "happy" && weather == "Sunny"
fun isSadAndRainyAndZero (mood: String, weather: String, temperature: Int) =
        mood == "sad" && weather == "rainy" && temperature == 0
fun isHot (temperature: Int) = temperature > 35

fun whatShouldIDoToday (
        mood: String,
        weather: String = "Sunny",
        temperature: Int = 24 //Celsius
) : String
{
    return when  {
        isHappyAndSunny(mood, weather) -> "go for a walk"
        isSadAndRainyAndZero(mood,weather,temperature) -> "stay in bed"
        isHot(temperature) -> "go swimming"
        else -> "Stay home and read"
    }
}

fun eagerExample () {
    val decorations = listOf ("rock", "padoga", "plastic plant", "alligator", "flowerpot")

    val eager = decorations.filter { it[0] == 'p' }
    println(eager)

    // new list with all elements that are match with filter
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    //apply map lazily
    //when the sequence is accessed the filter is applied on it
    // lazyMap will not hold all new elements but just would keep
    // the result of how the elements shall be filtered when accessed
    val lazyMap = decorations.asSequence().map {
        println("map: $it")
        it
    }
    println(lazyMap)
    //when the element in row below is accessed then the sequence function will be called
    println("first ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")
}