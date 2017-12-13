package co.windly.aac.data

import co.windly.aac.data.domain.models.authors.Author
import io.reactivex.Observable

interface DataManager {

  fun getAllAuthors(): Observable<List<Author>>
}
