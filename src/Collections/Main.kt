package Collections

import kotlin.math.sign

fun main(args: Array<String>) {

    val testList = listOf(11,12,13,14,15,16,17,18,19,20)

    println(testList)
    println(reverseList(testList))
    println(reverseListAgain(testList))
    println(testList.reversed())

    //it is preferable to use ListOf
    //ListOf gives us a list that we can't change
    //mutableListOf gives us a list that we can change
    val symptoms = mutableListOf("white spots", "red spots", "not eating","bloated", "belly up")

    symptoms.add("white fungus")
    symptoms.remove("white fungus")

    symptoms.contains("red") // false
    symptoms.contains("red spots") // true

    //creates a list from first argument index
    // till the second argument index
    println(symptoms.subList(4,symptoms.size)) //belly up

    listOf(1, 5, 3).sum() // 9

    //SumBy takes a lambda that specifies what property of
    //elements to summarize
    //it default name for lambda arguments
    listOf("a", "b", "cc").sumBy {it.length  } // 4

    //symptoms. lists all functions for list

    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")

    println(cures.get("white spots"))
    println(cures["white spots"])

    // if the key is not found then provide default value
    println(cures.getOrDefault("bloating", "sorry I don't know"))

    cures.getOrElse("bloating") {"No cure for this"}

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory.remove("fish net")

    //ListOf and mapOf make immutable collections.
    //MutableListOf and mutableMapOf make collections you can modify.
    //immutable maps and list are useful in multithreading
    //applications when several threads touch the same collection
}

fun reverseList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 0..list.size-1) {
        result.add(list[list.size-i-1])
    }
    return result
}

fun reverseListAgain(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0) {
        result.add(list.get(i))
    }
    return result
}
