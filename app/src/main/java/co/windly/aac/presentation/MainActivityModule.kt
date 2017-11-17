package co.windly.aac.presentation

import co.windly.aac.presentation.authors.list.AuthorsListComponent
import dagger.Module

@Module(subcomponents = arrayOf(
  AuthorsListComponent::class
))
class MainActivityModule
