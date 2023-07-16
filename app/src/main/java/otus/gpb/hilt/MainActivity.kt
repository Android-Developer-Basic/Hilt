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
import javax.inject.Qualifier

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Num
    @Inject
    @JvmField
    var num: Int? = null

    @NextNum
    @Inject
    @JvmField
    var nextNum: Int = 0

    @Inject
    @JvmField
    var str: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        with(view) {
            numView.text = "Num: $num"
            nextNumView.text = "NextNum: $nextNum"
            strView.text = "Str: $str"
        }
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NextNum

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    private var nextNum = 1

    @Provides
    @ActivityScoped
    fun str(): String = "String"

    @NextNum
    @Provides
    fun nextNum(): Int = nextNum++
}

