package co.windly.aac.ui.authors

import co.windly.aac.ui.authors.list.AuthorsListFragment
import co.windly.aac.ui.authors.list.AuthorsListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthorsFragmentProvider {

  @ContributesAndroidInjector(modules = [AuthorsListModule::class])
  abstract fun provideAuthorsListFragmentFactory(): AuthorsListFragment
}
