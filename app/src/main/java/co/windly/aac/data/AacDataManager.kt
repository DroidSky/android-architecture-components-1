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

  override fun getAuthors(active: Boolean?): Observable<List<Author>>
    = this.networkManager.getAuthors(active)

  override fun deleteAuthor(authorId: Long): Observable<Boolean>
    = this.networkManager.deleteAuthor(authorId)
}
