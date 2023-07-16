package otus.gpb.hilt

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@HiltAndroidApp
class HiltApp : Application()

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Num

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Num
    @Provides
    @Singleton
    fun num(): Int = 5
}

