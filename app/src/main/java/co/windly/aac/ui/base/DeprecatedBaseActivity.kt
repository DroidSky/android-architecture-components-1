package co.windly.aac.ui.base

import android.databinding.ViewDataBinding
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import co.windly.aac.R
import dagger.android.support.DaggerAppCompatActivity

@Deprecated("Rewrite to MVVM.")
abstract class DeprecatedBaseActivity<out T : ViewDataBinding, out V : BaseViewModel<*>> : DaggerAppCompatActivity() {

  companion object {

    fun addFragment(manager: FragmentManager, fragment: Fragment, @IdRes fragmentContainerId: Int) {
      val transaction = manager.beginTransaction()
      transaction.setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_leave)
      transaction.replace(fragmentContainerId, fragment)
      transaction.commit()
    }
  }

  @IdRes open var fragmentContainerId = R.id.fragmentContainer

  fun showFragment(fragment: Fragment) {
    addFragment(this.supportFragmentManager, fragment, this.fragmentContainerId)
  }
}
