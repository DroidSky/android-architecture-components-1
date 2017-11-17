package co.windly.aac.presentation.base

import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : DaggerFragment() {

  protected val disposables = CompositeDisposable()

  override fun onStop() {
    super.onStop()

    if (!this.disposables.isDisposed) {
      this.disposables.clear()
    }
  }
}
