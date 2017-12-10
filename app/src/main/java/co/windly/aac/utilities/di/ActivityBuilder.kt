package co.windly.aac.utilities.di

import co.windly.aac.ui.MainActivity
import co.windly.aac.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

  @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
  abstract fun bindMainActivity(): MainActivity
}
