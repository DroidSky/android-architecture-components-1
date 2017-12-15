package co.windly.aac.data

import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.data.domain.models.books.Book
import io.reactivex.Observable

interface DataManager {

  fun getAuthors(active: Boolean? = null): Observable<List<Author>>

  fun deleteAuthor(authorId: Long): Observable<Boolean>

  fun getBooks(active: Boolean? = null): Observable<List<Book>>

  fun deleteBook(bookId: Long): Observable<Boolean>
}
