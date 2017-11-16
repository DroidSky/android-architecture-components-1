package co.windly.aac.data.network.services

import co.windly.aac.data.network.models.covers.CoverApiModel
import io.reactivex.Observable
import retrofit2.http.GET

interface CoversService {

  @GET(value = "library/covers")
  fun getCovers(): Observable<List<CoverApiModel>>
}
