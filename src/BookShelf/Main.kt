package BookShelf

import kotlin.math.sign

fun main(args: Array<String>) {

    val book = Book("New","Nick",2020)

    val bookTitleAuthor = book.getTitleAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorYear()
    println("here is your book ${bookTitleAuthorYear.first} written by ${bookTitleAuthorYear.second} in ${bookTitleAuthorYear.third}")

    book.printUrl()

    val allBooks: Set<String> = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")

    val library = mapOf("Shakespeare" to allBooks)


    println(allBooks)
    println(library)
    println(library.any { it.value.contains("Hamlet")})

    val moreBooks = mutableMapOf<String,String>("Wilhelm Tell" to "Schiller" )

    moreBooks.getOrPut("Jungle Book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    //getOrPut() is a handy function that
    // will check whether a key is in a map,
    // and if it is, will return the value.
    // Otherwise, it will add the key with the supplied value to the map.
    println(moreBooks.getOrPut("title 3") {"title 2"})

    println(moreBooks)

    println(book.canBorrow(3))
    println(book.canBorrow(6))


}
