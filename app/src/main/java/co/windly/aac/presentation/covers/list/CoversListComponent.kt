package co.windly.aac.presentation.covers.list

import co.windly.aac.utilities.di.scopes.FragmentScoped
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScoped
@Subcomponent
interface CoversListComponent : AndroidInjector<CoversListFragment> {

  @Subcomponent.Builder
  abstract class Builder : AndroidInjector.Builder<CoversListFragment>()
}
