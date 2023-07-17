package otus.gpb.hilt

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import otus.gpb.hilt.databinding.ActivityParamsBinding

@AndroidEntryPoint
class ParamsActivity : ComponentActivity() {

    private val viewModel: ParamsActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = ActivityParamsBinding.inflate(layoutInflater)
        setContentView(view.root)

        with(view) {
            viewModel.data.observe(this@ParamsActivity) {
                paramView.text = "Passed param: $it"
            }
        }
    }

    companion object {

        const val PARAM = "param"

        fun getStartIntent(context: Context, param: String): Intent {
            val intent =  Intent(
                context,
                ParamsActivity::class.java
            )
            intent.putExtra(PARAM, param)

            return intent
        }
    }
}