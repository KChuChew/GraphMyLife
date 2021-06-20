package ca.tutorials.graphmylife.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import ca.tutorials.graphmylife.databinding.ActivityMainBinding
import ca.tutorials.graphmylife.viewmodels.ChartCategoryViewModel
import ca.tutorials.graphmylife.viewmodels.CreateCategoryViewModel
import ca.tutorials.graphmylife.viewmodels.MainActivityViewModel

open class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel : MainActivityViewModel by viewModels()
    private val chartCategoryViewModel : ChartCategoryViewModel by viewModels()
    private val createCategoryViewModel : CreateCategoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.mainActivityViewModel = mainActivityViewModel

        setContentView(binding.root)
    }
}