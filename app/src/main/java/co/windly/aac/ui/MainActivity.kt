package co.windly.aac.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import co.windly.aac.R
import co.windly.aac.ui.authors.list.AuthorsListFragment
import co.windly.aac.ui.base.DeprecatedBaseActivity
import co.windly.aac.ui.books.list.BooksListFragment
import co.windly.aac.ui.covers.list.CoversListFragment
import co.windly.aac.ui.publishinghouses.list.PublishingHousesListFragment

class MainActivity : DeprecatedBaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.setContentView(R.layout.activity_main)
    this.navigation.setOnNavigationItemSelectedListener(this.navigationListener)
    this.navigation.selectedItemId = R.id.navigation_authors
  }

  private val navigationListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    when (item.itemId) {
      R.id.navigation_authors -> {
        this.showFragment(AuthorsListFragment())
        true
      }
      R.id.navigation_publishing_houses -> {
        this.showFragment(PublishingHousesListFragment.newInstance())
        true
      }
      R.id.navigation_covers -> {
        this.showFragment(CoversListFragment.newInstance())
        true
      }
      R.id.navigation_books -> {
        this.showFragment(BooksListFragment.newInstance())
        true
      }
      else -> false
    }
  }
}
