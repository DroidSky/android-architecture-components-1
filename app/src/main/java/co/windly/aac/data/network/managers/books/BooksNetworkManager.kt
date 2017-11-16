package co.windly.aac.data.network.managers.books

import co.windly.aac.data.domain.models.books.Book
import co.windly.aac.data.network.services.BooksService
import io.reactivex.Observable
import org.modelmapper.ModelMapper
import javax.inject.Inject

@Suppress("MemberVisibilityCanPrivate")
class BooksNetworkManager @Inject constructor() {

  @Inject lateinit var service: BooksService
  @Inject lateinit var mapper: ModelMapper

  fun getBooks(): Observable<List<Book>> {
    return this.service.getBooks()
      .flatMapIterable { it }
      .map { this.mapper.map(it, Book::class.java) }
      .toList()
      .toObservable()
  }
}
