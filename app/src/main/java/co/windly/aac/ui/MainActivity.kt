package co.windly.aac.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import co.windly.aac.BR
import co.windly.aac.R
import co.windly.aac.databinding.ActivityMainBinding
import co.windly.aac.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator, HasSupportFragmentInjector {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  @Inject
  lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

  private lateinit var activityMainBinding: ActivityMainBinding
  private lateinit var mainViewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    this.activityMainBinding = this.getViewDataBinding()

//    this.navigation.setOnNavigationItemSelectedListener(this.navigationListener)
//    this.navigation.selectedItemId = R.id.navigation_authors
  }

  override fun getViewModel(): MainViewModel {
    this.mainViewModel = ViewModelProviders.of(this, this.viewModelFactory).get(MainViewModel::class.java)
    return this.mainViewModel
  }

  override fun getBindingVariable(): Int
    = BR.viewModel

  override fun getLayoutId(): Int
    = R.layout.activity_main

  override fun supportFragmentInjector(): AndroidInjector<Fragment>
    = this.fragmentDispatchingAndroidInjector

//  private val navigationListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//    when (item.itemId) {
//      R.id.navigation_authors -> {
//        this.showFragment(AuthorsListFragment())
//        true
//      }
//      R.id.navigation_publishing_houses -> {
//        this.showFragment(PublishingHousesListFragment.newInstance())
//        true
//      }
//      R.id.navigation_covers -> {
//        this.showFragment(CoversListFragment.newInstance())
//        true
//      }
//      R.id.navigation_books -> {
//        this.showFragment(BooksListFragment.newInstance())
//        true
//      }
//      else -> false
//    }
//  }
}
