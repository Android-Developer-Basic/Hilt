package otus.gpb.hilt

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

class DaggerApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun num(): Int

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application) : AppComponent
    }
}

@Module
class AppModule {
    @Provides
    @Singleton
    fun num(): Int = 5
}
