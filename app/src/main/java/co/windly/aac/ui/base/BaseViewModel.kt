package co.windly.aac.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import co.windly.aac.data.DataManager
import co.windly.aac.utilities.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<N> : ViewModel {

  private val dataManager: DataManager
  private val schedulerProvider: SchedulerProvider
  private val compositeDisposable: CompositeDisposable
  private val isLoading = ObservableBoolean(false)

  constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) {
    this.dataManager = dataManager
    this.schedulerProvider = schedulerProvider
    this.compositeDisposable = CompositeDisposable()
  }

  fun getDataManager() = this.dataManager

  fun getSchedulerProvider() = this.schedulerProvider

  fun getCompositeDisposable() = this.compositeDisposable

  fun isLoading() = this.isLoading

  fun setLoading(isLoading: Boolean) {
    this.isLoading.set(isLoading)
  }

  override fun onCleared() {
    this.compositeDisposable.dispose()
    super.onCleared()
  }
}
