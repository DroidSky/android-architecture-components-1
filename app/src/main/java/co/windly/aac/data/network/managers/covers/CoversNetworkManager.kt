package co.windly.aac.data.network.managers.covers

import co.windly.aac.data.domain.models.covers.Cover
import co.windly.aac.data.network.services.CoversService
import io.reactivex.Observable
import org.modelmapper.ModelMapper
import javax.inject.Inject

@Suppress("MemberVisibilityCanPrivate")
class CoversNetworkManager @Inject constructor() {

  @Inject lateinit var service: CoversService
  @Inject lateinit var mapper: ModelMapper

  fun getCovers(): Observable<List<Cover>> {
    return this.service.getCovers()
      .flatMapIterable { it }
      .map { this.mapper.map(it, Cover::class.java) }
      .toList()
      .toObservable()
  }
}