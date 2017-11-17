package co.windly.aac.presentation.books

import android.support.v4.app.Fragment
import co.windly.aac.presentation.books.list.BooksListComponent
import co.windly.aac.presentation.books.list.BooksListFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module
abstract class BooksFragmentProvider {

  @Binds
  @IntoMap
  @FragmentKey(value = BooksListFragment::class)
  abstract fun provideBooksListFragmentFactory(builder: BooksListComponent.Builder): AndroidInjector.Factory<out Fragment>
}
