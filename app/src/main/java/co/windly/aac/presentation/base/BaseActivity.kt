package co.windly.aac.presentation.base

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import co.windly.aac.R
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

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
