package co.windly.aac.ui.publishinghouses

import co.windly.aac.ui.publishinghouses.list.DeprecatedPublishingHousesListFragment
import co.windly.aac.ui.publishinghouses.list.PublishingHousesListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PublishingHousesFragmentProvider {

  @ContributesAndroidInjector(modules = [PublishingHousesListModule::class])
  abstract fun providePublishingHousesListFragmentFactory(): DeprecatedPublishingHousesListFragment
}
