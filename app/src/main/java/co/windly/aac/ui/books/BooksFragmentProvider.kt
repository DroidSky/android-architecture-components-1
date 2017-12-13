package co.windly.aac.ui.books

import co.windly.aac.ui.books.list.BooksListFragment
import co.windly.aac.ui.books.list.BooksListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BooksFragmentProvider {

  @ContributesAndroidInjector(modules = [BooksListModule::class])
  abstract fun provideBooksListFragmentFactory(): BooksListFragment
}
