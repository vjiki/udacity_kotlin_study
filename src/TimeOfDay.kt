fun main(args: Array<String>) {
    println("${if (args[0].toInt() in 0..11) "Good morning, Kotlin" else if ( args[0].toInt() in 12..23 ) "Good night, Kotlin" else "error time"}")
}