package co.windly.aac.ui.publishinghouses

import co.windly.aac.ui.publishinghouses.list.PublishingHousesListFragment
import co.windly.aac.ui.publishinghouses.list.PublishingHousesListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PublishingHousesFragmentProvider {

  @ContributesAndroidInjector(modules = [PublishingHousesListModule::class])
  abstract fun providePublishingHousesListFragmentFactory(): PublishingHousesListFragment
}
