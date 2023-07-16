package otus.gpb.hilt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(usecase: MainActivityUsecase) : ViewModel() {
    val data = MutableLiveData<String>()

    init {
        data.value = usecase.getData()
    }
}

@ViewModelScoped
class MainActivityUsecase @Inject constructor() {
    fun getData(): String = "Data from view-model"
}