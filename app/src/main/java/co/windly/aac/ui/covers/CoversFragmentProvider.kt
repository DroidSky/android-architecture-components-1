package co.windly.aac.ui.covers

import co.windly.aac.ui.covers.list.CoversListFragment
import co.windly.aac.ui.covers.list.CoversListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CoversFragmentProvider {

  @ContributesAndroidInjector(modules = [CoversListModule::class])
  abstract fun provideCoversListFragmentFactory(): CoversListFragment
}
