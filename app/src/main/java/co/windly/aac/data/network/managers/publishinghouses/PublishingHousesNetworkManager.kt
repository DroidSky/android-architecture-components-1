package co.windly.aac.data.network.managers.publishinghouses

import co.windly.aac.data.domain.models.publishinghouses.PublishingHouse
import io.reactivex.Observable
import org.modelmapper.ModelMapper
import javax.inject.Inject

@Suppress("MemberVisibilityCanPrivate")
class PublishingHousesNetworkManager @Inject constructor() {

  @Inject lateinit var service: PublishingHousesNetworkManager
  @Inject lateinit var mapper: ModelMapper

  fun getPublishingHouses(): Observable<List<PublishingHouse>> {
    return this.service.getPublishingHouses()
      .flatMapIterable { it }
      .map { this.mapper.map(it, PublishingHouse::class.java) }
      .toList()
      .toObservable()
  }
}
