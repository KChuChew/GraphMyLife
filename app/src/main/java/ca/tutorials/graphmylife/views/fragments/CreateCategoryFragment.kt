package ca.tutorials.graphmylife.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import ca.tutorials.graphmylife.R
import ca.tutorials.graphmylife.databinding.FragmentCreateCategoryBinding
import ca.tutorials.graphmylife.interfaces.ICreateCategoryListener
import ca.tutorials.graphmylife.models.ListViewButtonHolder
import ca.tutorials.graphmylife.viewmodels.ChartCategoryViewModel
import ca.tutorials.graphmylife.viewmodels.CreateCategoryViewModel
import ca.tutorials.graphmylife.viewmodels.MainActivityViewModel
import ca.tutorials.graphmylife.views.adapters.ListViewArrayAdapter
import ca.tutorials.graphmylife.views.dialogs.CreateCategoryFragmentDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateCategoryFragment : Fragment(R.layout.fragment_create_category), ICreateCategoryListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : FragmentCreateCategoryBinding
    private lateinit var arrayList : ArrayList<ListViewButtonHolder>
    private lateinit var arrayAdapter : ArrayAdapter<ListViewButtonHolder>

    private val chartCategoryViewModel : ChartCategoryViewModel by activityViewModels()
    private val createCategoryViewModel : CreateCategoryViewModel by activityViewModels()
    private val mainActivityViewModel : MainActivityViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_category, container, false)

        val view = binding.root
        binding.lifecycleOwner = viewLifecycleOwner
        binding.chartCategoryViewModel = chartCategoryViewModel
        binding.createCategoryViewModel = createCategoryViewModel
        mainActivityViewModel.toolbarVisibility.value = View.VISIBLE

        //arrayList = arrayListOf()
        /*if(createCategoryViewModel.categoryList.value == null)  {
            createCategoryViewModel.categoryList.value = arrayListOf()
        }*/

        arrayAdapter = ListViewArrayAdapter(requireContext(),
            R.layout.list_view_button_item,
            createCategoryViewModel.categoryList.value!!
        )
        binding.listViewCategories.adapter = arrayAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addCategoryOnClickListeners()
    }

    private fun showCategoryDialog() {
        val dialog = CreateCategoryFragmentDialog()
        dialog.show(childFragmentManager, "Category")
    }

    override fun onDialogPositiveClick(dialog : DialogFragment, categoryName : String) {
        // add category button here
        // I think for the model for the category, we need the category name and info
        // We do not need to put the Button in the VM (bad design)
        // VM has category name -> Model for category info (category model)

        var listViewButtonHolder = ListViewButtonHolder()
        listViewButtonHolder.description = createCategoryViewModel.categoryName.value.toString()
        listViewButtonHolder.fragment = DisplayGraphFragment()
        listViewButtonHolder.supportFragmentManager = requireActivity().supportFragmentManager

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
    /*companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreateCategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateCategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}