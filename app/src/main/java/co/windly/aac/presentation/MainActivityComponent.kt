package co.windly.aac.presentation

import co.windly.aac.presentation.authors.AuthorsFragmentProvider
import co.windly.aac.presentation.books.BooksFragmentProvider
import co.windly.aac.presentation.covers.CoversFragmentProvider
import co.windly.aac.presentation.publishinghouses.PublishingHousesFragmentProvider
import co.windly.aac.utilities.di.scopes.ActivityScoped
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScoped
@Subcomponent(modules = arrayOf(
  MainActivityModule::class,
  AuthorsFragmentProvider::class,
  BooksFragmentProvider::class,
  CoversFragmentProvider::class,
  PublishingHousesFragmentProvider::class
))
interface MainActivityComponent : AndroidInjector<MainActivity> {

  @Subcomponent.Builder
  abstract class Builder : AndroidInjector.Builder<MainActivity>()
}
