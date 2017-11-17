package co.windly.aac.presentation.covers

import android.support.v4.app.Fragment
import co.windly.aac.presentation.covers.list.CoversListComponent
import co.windly.aac.presentation.covers.list.CoversListFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module
abstract class CoversFragmentProvider {

  @Binds
  @IntoMap
  @FragmentKey(value = CoversListFragment::class)
  abstract fun provideCoversListFragmentFactory(builder: CoversListComponent.Builder): AndroidInjector.Factory<out Fragment>
}