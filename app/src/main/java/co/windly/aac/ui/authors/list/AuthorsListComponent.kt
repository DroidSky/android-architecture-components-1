package co.windly.aac.ui.authors.list

import co.windly.aac.utilities.di.scopes.FragmentScoped
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScoped
@Subcomponent
interface AuthorsListComponent : AndroidInjector<AuthorsListFragment> {

  @Subcomponent.Builder
  abstract class Builder : AndroidInjector.Builder<AuthorsListFragment>()
}
