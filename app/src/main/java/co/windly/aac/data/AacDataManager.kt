package co.windly.aac.data

import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.data.domain.models.books.Book
import co.windly.aac.data.domain.models.covers.Cover
import co.windly.aac.data.network.managers.authors.AuthorsNetworkManager
import co.windly.aac.data.network.managers.books.BooksNetworkManager
import co.windly.aac.data.network.managers.covers.CoversNetworkManager
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AacDataManager @Inject constructor() : DataManager {

  @Inject
  lateinit var authorsNetworkManager: AuthorsNetworkManager

  @Inject
  lateinit var booksNetworkManager: BooksNetworkManager

  @Inject
  lateinit var coversNetworkManager: CoversNetworkManager

  override fun getAuthors(active: Boolean?): Observable<List<Author>>
    = this.authorsNetworkManager.getAuthors(active)

  override fun deleteAuthor(authorId: Long): Observable<Boolean>
    = this.authorsNetworkManager.deleteAuthor(authorId)

  override fun getBooks(active: Boolean?): Observable<List<Book>>
    = this.booksNetworkManager.getBooks(active)

  override fun deleteBook(bookId: Long): Observable<Boolean>
    = this.booksNetworkManager.deleteBook(bookId)

  override fun getCovers(active: Boolean?): Observable<List<Cover>>
    = this.coversNetworkManager.getCovers(active)

  override fun deleteCover(coverId: Long): Observable<Boolean>
    = this.coversNetworkManager.deleteCover(coverId)
}
