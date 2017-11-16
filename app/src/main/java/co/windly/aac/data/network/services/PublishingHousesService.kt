package co.windly.aac.data.network.services

import co.windly.aac.data.network.models.publishinghouses.PublishingHouseApiModel
import io.reactivex.Observable
import retrofit2.http.GET

interface PublishingHousesService {

  @GET(value = "library/publishing_houses")
  fun getPublishingHouses(): Observable<List<PublishingHouseApiModel>>
}
