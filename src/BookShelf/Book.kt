package BookShelf

import Collections.Constants
import java.util.*

const val MAX_BOOKS_PER_PERSON = 5

open class Book(val title: String, val author: String, val year: Int, var pages: Int) {
    private var currentPage: Int = 0

    companion object Constants2 {
        const val BASE_URL = "https://baseurl.com/"
    }

    private val bookUrl = Constants2.BASE_URL

    open fun readPage() {
        currentPage++
    }

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String,String,Int> {
        return Triple(title,author,year)
    }

    fun canBorrow(hasBooks: Int): Boolean {return (hasBooks < MAX_BOOKS_PER_PERSON)}

    fun printUrl(){
        println("$bookUrl$title.html")
    }
}

class eBook(title: String, author: String, year: Int, pages: Int,var format: String = "text"): Book(title,author,year,pages) {

    private var wordsRead = 0

    override fun readPage() {
        wordsRead =  wordsRead + 250
    }
}

fun Book.getWeight(): Double { return pages*1.5}

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy {
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(book.pages) + 1)
    }
}

