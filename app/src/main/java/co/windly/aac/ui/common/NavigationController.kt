package co.windly.aac.ui.common

import android.support.annotation.IdRes
import android.support.v4.app.FragmentManager
import co.windly.aac.R
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
  constructor(fragmentManager: FragmentManager) {
    this.fragmentManager = fragmentManager
    this.containerId = R.id.fragmentContainer
  }

  fun navigateToAuthorsList() {
    val authorsFragment = AuthorsListFragment.newInstance()
    this.fragmentManager.beginTransaction()
      .replace(this.containerId, authorsFragment)
      .commitAllowingStateLoss()
  }

  fun navigateToBooksList() {
    val booksFragment = BooksListFragment.newInstance()
    this.fragmentManager.beginTransaction()
      .replace(this.containerId, booksFragment)
      .commitAllowingStateLoss()
  }

  fun navigateToCoversList() {
    val coversFragment = CoversListFragment.newInstance()
    this.fragmentManager.beginTransaction()
      .replace(this.containerId, coversFragment)
      .commitAllowingStateLoss()
  }

  fun navigateToPublishingHousesList() {
    val housesFragment = PublishingHousesListFragment.newInstance()
    this.fragmentManager.beginTransaction()
      .replace(this.containerId, housesFragment)
      .commitAllowingStateLoss()
  }
}
