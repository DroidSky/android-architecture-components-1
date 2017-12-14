package co.windly.aac.ui.authors.list

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import co.windly.aac.data.DataManager
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.ui.base.BaseViewModel
import co.windly.aac.utilities.AacLogger
import co.windly.aac.utilities.rx.SchedulerProvider

class AuthorsListViewModel(
  dataManager: DataManager,
  schedulerProvider: SchedulerProvider
) : BaseViewModel<AuthorsListNavigator>(dataManager, schedulerProvider) {

  private val authorsObservableArrayList = ObservableArrayList<Author>()
  private val authorsListLiveData = MutableLiveData<List<Author>>()

  init {
    this.loadAuthors()
  }

  private fun loadAuthors() {
    this.setLoading(true)
    getCompositeDisposable().add(getDataManager()
      .getAllAuthors()
      .subscribeOn(getSchedulerProvider().io())
      .observeOn(getSchedulerProvider().ui())
      .subscribe(
        { this.authorsListLiveData.value = it },
        { AacLogger.e(it.localizedMessage) }
      ))
  }

  fun getAuthorsListLiveData(): MutableLiveData<List<Author>>
    = this.authorsListLiveData

  fun addAuthorItemsToList(authors: List<Author>) {
    this.authorsObservableArrayList.clear()
    this.authorsObservableArrayList.addAll(authors)
  }

  fun getAuthorsObservableArrayList(): ObservableArrayList<Author>
    = this.authorsObservableArrayList
}
