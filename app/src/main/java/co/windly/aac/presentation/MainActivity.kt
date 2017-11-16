package co.windly.aac.presentation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import co.windly.aac.R
import co.windly.aac.presentation.authors.list.AuthorsListFragment
import co.windly.aac.presentation.base.BaseActivity
import co.windly.aac.presentation.books.list.BooksListFragment
import co.windly.aac.presentation.covers.list.CoversListFragment
import co.windly.aac.presentation.publishinghouses.list.PublishingHousesListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

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
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_publishing_houses -> {
        this.showFragment(PublishingHousesListFragment())
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_covers -> {
        this.showFragment(CoversListFragment())
        return@OnNavigationItemSelectedListener true
      }
      R.id.navigation_books -> {
        this.showFragment(BooksListFragment())
        return@OnNavigationItemSelectedListener true
      }
    }
    false
  }
}
