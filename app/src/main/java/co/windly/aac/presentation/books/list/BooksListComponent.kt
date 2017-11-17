package co.windly.aac.presentation.books.list

import co.windly.aac.utilities.di.scopes.FragmentScoped
import dagger.Subcomponent
import dagger.android.AndroidInjector

@FragmentScoped
@Subcomponent
interface BooksListComponent : AndroidInjector<BooksListFragment> {

  @Subcomponent.Builder
  abstract class Builder : AndroidInjector.Builder<BooksListFragment>()
}
