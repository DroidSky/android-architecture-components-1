package co.windly.aac.presentation.authors.list

import co.windly.aac.utilities.di.scopes.FragmentScoped
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScoped
@Subcomponent(modules = arrayOf(
  AuthorsListModule::class
))
interface AuthorsListComponent : AndroidInjector<AuthorsListFragment> {

  @Subcomponent.Builder
  abstract class Builder : AndroidInjector.Builder<AuthorsListFragment>()
}
