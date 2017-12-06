package co.windly.aac.ui.base

import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable

@Deprecated("Rewrite to MVVM.")
abstract class DeprecatedBaseFragment : DaggerFragment() {

  protected val disposables = CompositeDisposable()

  override fun onStop() {
    super.onStop()

    if (!this.disposables.isDisposed) {
      this.disposables.clear()
    }
  }
}
