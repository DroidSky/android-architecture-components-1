package co.windly.aac.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import co.windly.aac.utilities.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<N> : ViewModel {

  private val schedulerProvider: SchedulerProvider
  private val compositeDisposable: CompositeDisposable
  private val isLoading = ObservableBoolean(false)

  constructor(schedulerProvider: SchedulerProvider) {
    this.schedulerProvider = schedulerProvider
    this.compositeDisposable = CompositeDisposable()
  }

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
