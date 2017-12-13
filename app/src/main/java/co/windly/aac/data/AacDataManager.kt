package co.windly.aac.data

import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.data.network.managers.authors.AuthorsNetworkManager
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AacDataManager @Inject constructor() : DataManager {

  @Inject
  lateinit var networkManager: AuthorsNetworkManager

  override fun getAllAuthors(): Observable<List<Author>>
    = this.networkManager.getAuthors()
}
