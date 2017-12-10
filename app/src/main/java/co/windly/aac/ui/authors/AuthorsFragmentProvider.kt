package co.windly.aac.ui.authors

import android.support.v4.app.Fragment
import co.windly.aac.ui.authors.list.AuthorsListComponent
import co.windly.aac.ui.authors.list.AuthorsListFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module
abstract class AuthorsFragmentProvider {

  @Binds
  @IntoMap
  @FragmentKey(value = AuthorsListFragment::class)
  abstract fun provideAuthorsListFragmentFactory(builder: AuthorsListComponent.Builder): AndroidInjector.Factory<out Fragment>
}