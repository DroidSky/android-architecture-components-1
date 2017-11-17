package co.windly.aac.presentation

import co.windly.aac.presentation.authors.list.AuthorsListComponent
import co.windly.aac.presentation.books.list.BooksListComponent
import co.windly.aac.presentation.covers.list.CoversListComponent
import co.windly.aac.presentation.publishinghouses.list.PublishingHousesListComponent
import dagger.Module

@Module(subcomponents = arrayOf(
  AuthorsListComponent::class,
  BooksListComponent::class,
  CoversListComponent::class,
  PublishingHousesListComponent::class
))
class MainActivityModule
