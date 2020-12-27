import java.util.*

fun dayOfWeek() {
    println("What day is it today? ")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println ( when (day){
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Time has stopped"
    })
}

fun main(args: Array<String>) {
    dayOfWeek()

    val decorations = listOf("rock", "pagoda", "plastic planet", "alligator", "flowerpot")

    println(decorations.filter { true })
    println(decorations.filter { it[0] == 'p' })

    //apply filter lazily
    //it will contain a sequence instead of full list of elements
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
    println(filtered.toList())

    //apply map lazily
    val lazyMap = decorations.asSequence().map {
        println("map: $it")
    }

    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")

    val spices = listOf(
            "curry",
            "pepper",
            "cayenne",
            "ginger",
            "red curry",
            "green curry",
            "red pepper" )

    println(spices.filter { it.contains("curry") }.sortedBy { it.length })
    println(spices.filter {  it[0] == 'c'}.filter { it.last() == 'e' })
    spices.filter{it.startsWith('c')}.filter{it.endsWith('e')}
    spices.filter { it.startsWith('c') && it.endsWith('e') }
    println(spices.take(3).filter {  it.startsWith('c')} )

        //println(spices.take(3))
                //spices.take(3).filter{it.startsWith('c')}

    swim()

    gamePlay(4, rollDice2)
    gamePlay2(rollDice2(4))
}

var dirty = 20
val waterFilter: (Int) -> Int = {dirty : Int -> dirty/2}


fun swim() {
    // swim!
    { println("Hello") }()
    println(waterFilter(dirty))
    val swimming = { println("Hello\n") }

    swimming()

    dirtyProcessor()

    val rollDice = {Random().nextInt(12) + 1}


    val rollDice3 = { sides: Int ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }
    val rollDice4: (Int) -> Int = { sides ->
        if (sides == 0) 0
        else Random().nextInt(sides) + 1
    }


}

fun feedFish(dirty: Int) = dirty + 10

// it is possible to pass the function as a parameter
// kotlin prefers to have  a function as last parameter
fun updateDirty(dirty:Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun dirtyProcessor(){
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty, {dirty ->
        dirty + 50
    })
}

val rollDice2= { sides: Int ->
    Random().nextInt(sides) + 1
}


fun gamePlay(diceRoll: Int, operation: (Int) -> Int){
    // do something with the dice roll
    //println("operation ${operation(diceRoll)}")
    operation(diceRoll)
}

fun gamePlay2(diceRoll: Int){
    // do something with the dice roll
    println(diceRoll)
}
