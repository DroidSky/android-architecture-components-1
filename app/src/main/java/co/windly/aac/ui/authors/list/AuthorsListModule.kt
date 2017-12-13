package co.windly.aac.ui.authors.list

import co.windly.aac.data.DataManager
import co.windly.aac.utilities.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class AuthorsListModule {

  @Provides
  fun authorsListViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): AuthorsListViewModel
    = AuthorsListViewModel(dataManager, schedulerProvider)
}
