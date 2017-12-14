package co.windly.aac.ui

import co.windly.aac.data.DataManager
import co.windly.aac.utilities.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

  @Provides
  fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): MainViewModel
    = MainViewModel(dataManager, schedulerProvider)
}
