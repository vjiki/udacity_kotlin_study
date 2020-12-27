package BookShelf

fun main(args: Array<String>) {

    val book = Book("New","Nick",2020)

    val bookTitleAuthor = book.getTitleAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorYear()
    println("here is your book ${bookTitleAuthorYear.first} written by ${bookTitleAuthorYear.second} in ${bookTitleAuthorYear.third}")

}
