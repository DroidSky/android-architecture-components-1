package co.windly.aac.utilities.dependencyinjection

import android.app.Application
import co.windly.aac.AacApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: AacApplication) {

  @Provides
  fun provideAacApplication(): AacApplication = this.application

  @Provides
  fun provideApplication(): Application = this.application
}
