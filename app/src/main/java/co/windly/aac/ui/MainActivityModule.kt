package co.windly.aac.ui

import android.arch.lifecycle.ViewModelProvider
import co.windly.aac.ViewModelProviderFactory
import co.windly.aac.utilities.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

  @Provides
  fun provideMainViewModel(schedulerProvider: SchedulerProvider): MainViewModel
    = MainViewModel(schedulerProvider)

  @Provides
  fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory
    = ViewModelProviderFactory(mainViewModel)
}
