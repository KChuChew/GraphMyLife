package ca.tutorials.graphmylife.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.tutorials.graphmylife.models.ChartCategory

class ChartCategoryViewModel : ViewModel() {
    private val _categoryMap = MutableLiveData<Map<String, ChartCategory>>()

    val categoryMap : LiveData<Map<String, ChartCategory>> = _categoryMap
    //val categoryMap : Map<String, ChartCategory> = mapOf<String, ChartCategory>()
}