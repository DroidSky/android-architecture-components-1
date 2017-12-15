package co.windly.aac.ui.common

import android.support.annotation.IdRes
import android.support.v4.app.FragmentManager
import co.windly.aac.R
import co.windly.aac.ui.MainActivity
import co.windly.aac.ui.authors.list.AuthorsListFragment
import co.windly.aac.ui.books.list.BooksListFragment
import co.windly.aac.ui.covers.list.CoversListFragment
import co.windly.aac.ui.publishinghouses.list.PublishingHousesListFragment
import javax.inject.Inject

class NavigationController {

  @IdRes
  private val containerId: Int
  private val fragmentManager: FragmentManager

  @Inject
  constructor(mainActivity: MainActivity) {
    this.fragmentManager = mainActivity.supportFragmentManager
    this.containerId = R.id.fragmentContainer
  }

  fun navigateToAuthorsList() {
    val authorsFragment = AuthorsListFragment.newInstance()
    this.fragmentManager.beginTransaction()
      .replace(this.containerId, authorsFragment)
      .setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_leave)
      .commitAllowingStateLoss()
  }

  fun navigateToBooksList() {
    val booksFragment = BooksListFragment.newInstance()
    this.fragmentManager.beginTransaction()
      .replace(this.containerId, booksFragment)
      .setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_leave)
      .commitAllowingStateLoss()
  }

  fun navigateToCoversList() {
    val coversFragment = CoversListFragment.newInstance()
    this.fragmentManager.beginTransaction()
      .replace(this.containerId, coversFragment)
      .setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_leave)
      .commitAllowingStateLoss()
  }

  fun navigateToPublishingHousesList() {
    val housesFragment = PublishingHousesListFragment.newInstance()
    this.fragmentManager.beginTransaction()
      .replace(this.containerId, housesFragment)
      .setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_leave)
      .commitAllowingStateLoss()
  }
}
