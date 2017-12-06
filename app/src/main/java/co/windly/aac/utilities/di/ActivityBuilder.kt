package co.windly.aac.utilities.di

import android.app.Activity
import co.windly.aac.ui.MainActivity
import co.windly.aac.ui.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

  @Binds
  @IntoMap
  @ActivityKey(value = MainActivity::class)
  abstract fun bindMainActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}
