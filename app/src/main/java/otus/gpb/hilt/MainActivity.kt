package otus.gpb.hilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import otus.gpb.hilt.databinding.ActivityMainBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @set:Inject
    var num: Int = 0

    @set:Inject
    var str: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        with(view) {
            numView.text = num.toString()
            strView.text = str
        }
    }
}

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {
    @Provides
    @ActivityScoped
    fun str(): String = "String"
}

