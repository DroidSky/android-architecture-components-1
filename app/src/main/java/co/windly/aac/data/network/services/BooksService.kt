package co.windly.aac.data.network.services

import co.windly.aac.data.network.models.books.BookApiModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksService {

  @GET(value = "library/books/")
  fun getBooks(): Observable<List<BookApiModel>>

  @DELETE(value = "library/books/{pk}/")
  fun deleteBook(@Path("pk") bookId: Long): Observable<Response<Void>>
}
