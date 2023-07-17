package otus.gpb.hilt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import otus.gpb.hilt.ParamsActivity.Companion.PARAM
import javax.inject.Inject

@HiltViewModel
class ParamsActivityViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    val data = MutableLiveData<String>(savedStateHandle[PARAM])
}