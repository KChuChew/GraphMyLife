package ca.tutorials.graphmylife.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.tutorials.graphmylife.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
    }
}