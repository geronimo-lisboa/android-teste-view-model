package dongeronimo.com.androidtesteviewmodel.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dongeronimo.com.androidtesteviewmodel.model.MyEntity

class MyEntityViewModel : ViewModel() {
    var models: MutableLiveData<List<MyEntity>> = MutableLiveData();
}