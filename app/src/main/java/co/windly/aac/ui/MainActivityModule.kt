package co.windly.aac.ui

import co.windly.aac.ui.authors.list.AuthorsListComponent
import co.windly.aac.ui.books.list.BooksListComponent
import co.windly.aac.ui.covers.list.CoversListComponent
import co.windly.aac.ui.publishinghouses.list.PublishingHousesListComponent
import dagger.Module

@Module(subcomponents = arrayOf(
  AuthorsListComponent::class,
  BooksListComponent::class,
  CoversListComponent::class,
  PublishingHousesListComponent::class
))
class MainActivityModule
