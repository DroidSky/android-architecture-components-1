package co.windly.aac.data.network.services

import co.windly.aac.data.network.models.publishinghouses.PublishingHouseApiModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface PublishingHousesService {

  @GET(value = "library/publishing_houses/")
  fun getPublishingHouses(): Observable<List<PublishingHouseApiModel>>

  @DELETE(value = "library/publishing_houses/{pk}/")
  fun deletePublishingHouse(@Path("pk") publishingHouseId: Long): Observable<Response<Void>>
}
