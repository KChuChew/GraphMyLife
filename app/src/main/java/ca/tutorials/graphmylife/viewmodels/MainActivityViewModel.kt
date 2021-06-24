package ca.tutorials.graphmylife.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var toolbarVisibility = MutableLiveData(View.VISIBLE)
    var counter = MutableLiveData(0)

    init {
        counter.value = 0
    }

    fun navigationOnClick() {
        counter.value = counter.value?.plus(1)
    }
}