package co.windly.aac.utilities.di

import co.windly.aac.ui.MainActivity
import co.windly.aac.ui.MainActivityModule
import co.windly.aac.ui.authors.AuthorsFragmentProvider
import co.windly.aac.ui.books.BooksFragmentProvider
import co.windly.aac.ui.covers.CoversFragmentProvider
import co.windly.aac.ui.publishinghouses.PublishingHousesFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

  @ContributesAndroidInjector(
    modules = [
      MainActivityModule::class,
      AuthorsFragmentProvider::class,
      BooksFragmentProvider::class,
      CoversFragmentProvider::class,
      PublishingHousesFragmentProvider::class
    ])
  abstract fun bindMainActivity(): MainActivity
}
