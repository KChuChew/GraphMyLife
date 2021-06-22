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


    /*private val _categoryName = MutableLiveData<String>()
        get() = _categoryName
    var categoryMap = MutableLiveData<Map<String, ChartCategory>>()

    fun setCategoryName(newCategoryName: String) {
        categoryName.value = newCategoryName
    }*/
}