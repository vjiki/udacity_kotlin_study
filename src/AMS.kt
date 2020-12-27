import java.security.KeyStore
import java.util.*

fun main(args: Array<String>) {

    println("Hello, ${args[0]}!")

    val isUnit = println ("This is an expression")
    println (isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val message = "You are ${if (temperature > 50) "fried" else "safe"} fish \n"
    println(message)
    feedTheFish ()

    repeat(10 ) {
        var mes = getFortuneCookie()
        println("Your fortune is: $mes \n")
        if (mes.contains("Take it easy")) return@main
        //if (mes.contains("Take it easy"))  //break
    }

    var mess = getFortune (getBirthday())
    println("Your fortune is: $mess \n")

    /*while (!mess.contains("Enjoy a wonderful day of success"))
    {
        println(" fortune is: $mess $i \n")
        var mess = getFortune (getBirthday())
    }*/

    println(canAddFish(10, listOf(3,3,3))) // ---> false
    println(canAddFish(8, listOf(2,2,2), hasDecorations = false)) // ---> true
    println(canAddFish(9, listOf(1,1,3), 3)) // ---> false
    println(canAddFish(10, listOf(), 7, true)) // ---> true

    println(canAddFish(10.0, listOf(3,3,3))) // ---> false
    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false)) // ---> true
    println(canAddFish(9.0, listOf(1,1,3), 3)) // ---> false
    println(canAddFish(10.0, listOf(), 7, true)) // ---> true


}

fun feedTheFish () {
    val day = randomDay ()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")

    swim(50, speed="slow")
    shouldChangeWater(day, 20,50)
    shouldChangeWater(day)
    shouldChangeWater(day,50)
    shouldChangeWater2(day = "Monday")
    shouldChangeWater3(day = "Sunday")

    if (shouldChangeWater(day)){
        println ("Change the water today")
    }
}

fun swim (time: Int, speed: String = "fast") {
    println("swimming $speed")
}

fun fishFood(day : String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}


fun randomDay() : String {
    val week = listOf ("Monday", "Tuesday", "Wendsday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun getFortuneCookie() : String {
    val fortune = listOf ("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.",
            "Take it easy"
    )
    print("Enter your birthday")

    //val birthday = readLine()?.toIntOrNull() ?: 1

    val birthday = Random().nextInt(31)
    return fortune[birthday.rem(fortune.size)]
}

fun getFortune(birthday : Int) : String {
    val fortune = listOf ("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.",
            "Take it easy"
    )

    return when (birthday) {
        28,31 -> fortune[4]
        in 1..7 -> fortune[2]
        else -> fortune[birthday.rem(fortune.size)]
    }
}

fun getBirthday() : Int {
    print("Enter your birthday: ")
    return Random().nextInt(31)//readLine()?.toIntOrNull() ?: 1
}

fun getDirtySensorReading() = 20

fun makeNewAquarium() = println("Building a new aquarium .......")
// bad approach: allocates a lot of memory because each time new aquirium is created
fun aquariumStatusReport(aquarium: Any = makeNewAquarium()){
}

fun shouldChangeWater (
        day: String,
        temperature: Int = 22,
        dirty: Int = getDirtySensorReading()) : Boolean {

    fun isTooHot(temperature: Int) = temperature > 30
    fun isDirty(dirty: Int) = dirty > 30
    fun isSunday(day: String) = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }



}

fun shouldChangeWater2 (
        temperature: Int = 22,
        dirty: Int = 20,
        day: String) : Boolean {
    return true
}

fun shouldChangeWater3 (
        day: String,
        temperature: Int = 22,
        dirty: Int = 20) : Boolean {

    val isTooHot = temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

// 1 inch fish / 1 gallon -- no decoration
// 6 x 1 inch fish + 2 x 2 / 20 gallon
// 0.8 inch fish / 1 gallon -- decoration
// 4 x 2 inch fish / 10 gallons
fun canAddFish (
        tankSize: Int,
        currentFish: List<Int> = listOf(0),
        fishSize: Int = 2,
        hasDecorations: Boolean = true
) : Boolean {

    if (hasDecorations) {
        var sum = 0
        for(element in currentFish) sum += element

        return (0.8 * tankSize) >= (sum + fishSize)
    }
    else {
        var sum = 0
        for(element in currentFish) sum += element

        return tankSize >= (sum + fishSize)
    }
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}