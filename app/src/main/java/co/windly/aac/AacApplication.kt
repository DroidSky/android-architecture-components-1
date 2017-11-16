package co.windly.aac

import android.app.Application
import co.windly.aac.utilities.dependencyinjection.ApplicationModule
import co.windly.aac.utilities.dependencyinjection.DaggerApplicationComponent
import co.windly.aac.utilities.dependencyinjection.DatabaseModule

class AacApplication : Application() {

  val applicationComponent by lazy {
    DaggerApplicationComponent.builder()
      .applicationModule(ApplicationModule(this))
      .databaseModule(DatabaseModule(this))
      .build()
  }
}
