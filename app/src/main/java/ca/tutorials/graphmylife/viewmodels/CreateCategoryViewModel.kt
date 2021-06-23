package ca.tutorials.graphmylife.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tutorials.graphmylife.models.ListViewButtonHolder

class CreateCategoryViewModel : ViewModel() {

    var categoryName = MutableLiveData<String>()
    var categoryList : MutableLiveData<ArrayList<ListViewButtonHolder>> = MutableLiveData()

    init {
        categoryList.value = arrayListOf()
    }
}