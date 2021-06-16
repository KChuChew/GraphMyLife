package ca.tutorials.graphmylife.viewmodels

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tutorials.graphmylife.models.ListViewButtonHolder

class CreateCategoryViewModel : ViewModel() {

    var categoryName = MutableLiveData<String>()
    var categoryList = MutableLiveData<ArrayList<ListViewButtonHolder>>()

    /*private val _categoryName = MutableLiveData<String>()
        get() = _categoryName
    var categoryMap = MutableLiveData<Map<String, ChartCategory>>()

    fun setCategoryName(newCategoryName: String) {
        categoryName.value = newCategoryName
    }*/
}