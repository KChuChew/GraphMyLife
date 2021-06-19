package ca.tutorials.graphmylife.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var toolbarVisibility = MutableLiveData(View.VISIBLE)
}