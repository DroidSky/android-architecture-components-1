package co.windly.aac.data.network.services

import co.windly.aac.data.network.models.authors.AuthorApiModel
import io.reactivex.Observable
import retrofit2.http.GET

interface AuthorsService {

  @GET(value = "library/authors")
  fun getAuthors(): Observable<List<AuthorApiModel>>
}
