package BookShelf

open class Book(val title: String, val author: String, val year: Int) {
    private var currentPage: Int = 0

    open fun readPage() {
        currentPage++
    }

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String,String,Int> {
        return Triple(title,author,year)
    }
}

class eBook(title: String, author: String, year: Int,var format: String = "text"): Book(title,author,year) {

    private var wordsRead = 0

    override fun readPage() {
        wordsRead =  wordsRead + 250
    }
}