package co.windly.aac.data.network.services

import co.windly.aac.data.network.models.books.BookApiModel
import io.reactivex.Observable
import retrofit2.http.GET

interface BooksService {

  @GET(value = "library/books")
  fun getBooks(): Observable<List<BookApiModel>>
}
