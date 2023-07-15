package otus.gpb.hilt

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject
import javax.inject.Scope

class MainActivity : ComponentActivity() {

    @set:Inject
    var num: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerMainActivityComponent
            .factory()
            .create((application as DaggerApp).appComponent, this)
            .inject(this)

    }
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class
ActivityScope

@ActivityScope
@Component(dependencies = [AppComponent::class])
interface MainActivityComponent {
    fun activity(): Activity

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance activity: Activity
        ) : MainActivityComponent
    }
}
