package co.windly.aac.utilities.dependencyinjection

import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
  ApplicationModule::class,
  DatabaseModule::class,
  ApiModule::class
))
interface ApplicationComponent {

  // TODO: Inject methods.

  fun application(): Application
}
