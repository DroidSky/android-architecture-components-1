package co.windly.aac.ui

import android.arch.lifecycle.ViewModelProvider
import co.windly.aac.ViewModelProviderFactory
import co.windly.aac.ui.authors.list.AuthorsListComponent
import co.windly.aac.ui.books.list.BooksListComponent
import co.windly.aac.ui.covers.list.CoversListComponent
import co.windly.aac.ui.publishinghouses.list.PublishingHousesListComponent
import co.windly.aac.utilities.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module(subcomponents = arrayOf(
  AuthorsListComponent::class,
  BooksListComponent::class,
  CoversListComponent::class,
  PublishingHousesListComponent::class
))
class MainActivityModule {

  @Provides
  fun provideMainViewModel(schedulerProvider: SchedulerProvider): MainViewModel
    = MainViewModel(schedulerProvider)

  @Provides
  fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory
    = ViewModelProviderFactory(mainViewModel)
}
