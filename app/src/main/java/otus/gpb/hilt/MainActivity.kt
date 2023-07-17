package otus.gpb.hilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
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

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        with(view) {
            numView.text = "Num: $num"
            nextNumView.text = "NextNum: $nextNum"
            strView.text = "Str: $str"
            viewModel.data.observe(this@MainActivity) {
                viewModelView.text = it
            }

            button.setOnClickListener {
                startActivity(ParamsActivity.getStartIntent(this@MainActivity, str))
            }
        }
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NextNum

@Module
@InstallIn(ActivityRetainedComponent::class)
class ActivityModule {

    private var nextNum = 1

    @Provides
    @ActivityRetainedScoped
    fun str(): String = "String"

    @NextNum
    @Provides
    fun nextNum(): Int = nextNum++
}

