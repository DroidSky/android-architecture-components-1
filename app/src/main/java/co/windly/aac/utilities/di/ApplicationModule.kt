package co.windly.aac.utilities.di

import co.windly.aac.presentation.MainActivityComponent
import dagger.Module
import dagger.Provides
import org.modelmapper.ModelMapper
import javax.inject.Singleton

@Module(
  subcomponents = arrayOf(
    MainActivityComponent::class
  ),
  includes = arrayOf(
    ApiModule::class,
    DatabaseModule::class
  )
)
class ApplicationModule {

  @Provides
  @Singleton
  fun provideModelMapper(): ModelMapper {
    return ModelMapper().apply {
      this.configuration.isAmbiguityIgnored = true
    }
  }
}
