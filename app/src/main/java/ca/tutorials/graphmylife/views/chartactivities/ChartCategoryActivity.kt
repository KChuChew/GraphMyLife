package ca.tutorials.graphmylife.views.chartactivities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import ca.tutorials.graphmylife.R
import ca.tutorials.graphmylife.databinding.ActivityChartCategoryBinding
import ca.tutorials.graphmylife.interfaces.ICreateCategoryListener
import ca.tutorials.graphmylife.models.ListViewButtonHolder
import ca.tutorials.graphmylife.viewmodels.ChartCategoryViewModel
import ca.tutorials.graphmylife.viewmodels.CreateCategoryViewModel
import ca.tutorials.graphmylife.views.adapters.ListViewArrayAdapter
import ca.tutorials.graphmylife.views.dialogs.CreateCategoryFragmentDialog


class ChartCategoryActivity : FragmentActivity(), ICreateCategoryListener{

    private lateinit var binding : ActivityChartCategoryBinding
    private lateinit var arrayList : ArrayList<ListViewButtonHolder>
    private lateinit var arrayAdapter : ArrayAdapter<ListViewButtonHolder>

    private val chartCategoryViewModel : ChartCategoryViewModel by viewModels()
    private val createCategoryViewModel : CreateCategoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chart_category)
        binding.lifecycleOwner = this
        binding.chartCategoryViewModel = chartCategoryViewModel
        binding.createCategoryViewModel = createCategoryViewModel


        val view = binding.root
        setContentView(view)

        arrayList = arrayListOf()
        arrayAdapter = ListViewArrayAdapter(this, R.layout.list_view_button_item, arrayList)
        binding.listViewCategories.adapter = arrayAdapter

        addCategoryOnClickListeners()
    }

    private fun showCategoryDialog() {
        val dialog = CreateCategoryFragmentDialog()
        dialog.show(supportFragmentManager, "Category")
    }

    override fun onDialogPositiveClick(dialog : DialogFragment, categoryName : String) {
        // add category button here
        // I think for the model for the category, we need the category name and info
        // We do not need to put the Button in the VM (bad design)
        // VM has category name -> Model for category info (category model)

        var listViewButtonHolder = ListViewButtonHolder()
        listViewButtonHolder.description = categoryName

        arrayAdapter.add(listViewButtonHolder)
        arrayAdapter.notifyDataSetChanged()
    }

    override fun onDialogNegativeClick(dialog : DialogFragment)  {
        Toast.makeText(dialog.context, "ON DIALOG NEGATIVE CLICK", Toast.LENGTH_SHORT).show()
    }

    private fun addCategoryOnClickListeners() {
        binding.buttonAddCategory.setOnClickListener {
            showCategoryDialog()
        }
    }
}