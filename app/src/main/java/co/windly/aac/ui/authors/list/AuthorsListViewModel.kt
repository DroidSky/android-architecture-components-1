package co.windly.aac.ui.authors.list

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableArrayList
import co.windly.aac.data.DataManager
import co.windly.aac.data.domain.models.authors.Author
import co.windly.aac.ui.base.BaseViewModel
import co.windly.aac.utilities.rx.SchedulerProvider

class AuthorsListViewModel(
  dataManager: DataManager,
  schedulerProvider: SchedulerProvider
) : BaseViewModel<AuthorsListNavigator>(dataManager, schedulerProvider) {

  private val authorsArray = ObservableArrayList<Author>()
  private val authorsData = MutableLiveData<List<Author>>()

  init {
    this.loadAuthors()
  }

  private fun loadAuthors() {
    getCompositeDisposable().add(getDataManager()
      .getAllAuthors()
      .subscribeOn(getSchedulerProvider().io())
      .observeOn(getSchedulerProvider().ui())
      .subscribe { authors -> this.authorsData.value = authors })
  }

  public fun getAuthorsData(): MutableLiveData<List<Author>>
    = this.authorsData

  fun setAuthorsDataList(authors: List<Author>) {
    authorsArray.clear()
    authorsArray.addAll(authors)
  }

  public fun getAuthorsArray(): ObservableArrayList<Author>
    = this.authorsArray
}
