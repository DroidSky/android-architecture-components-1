package co.windly.aac.ui.publishinghouses

import android.support.v4.app.Fragment
import co.windly.aac.ui.publishinghouses.list.PublishingHousesListComponent
import co.windly.aac.ui.publishinghouses.list.PublishingHousesListFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module
abstract class PublishingHousesFragmentProvider {

  @Binds
  @IntoMap
  @FragmentKey(value = PublishingHousesListFragment::class)
  abstract fun providePublishingHousesFragmentFactory(builder: PublishingHousesListComponent.Builder): AndroidInjector.Factory<out Fragment>
}
