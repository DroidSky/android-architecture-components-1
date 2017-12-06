package co.windly.aac.ui.publishinghouses.list

import co.windly.aac.utilities.di.scopes.FragmentScoped
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScoped
@Subcomponent
interface PublishingHousesListComponent : AndroidInjector<PublishingHousesListFragment> {

  @Subcomponent.Builder
  abstract class Builder : AndroidInjector.Builder<PublishingHousesListFragment>()
}
