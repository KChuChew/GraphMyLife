package ca.tutorials.graphmylife.views.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import ca.tutorials.graphmylife.R
import ca.tutorials.graphmylife.databinding.CreateCategoryViewBinding
import ca.tutorials.graphmylife.interfaces.ICreateCategoryListener
import ca.tutorials.graphmylife.viewmodels.CreateCategoryViewModel

class CreateCategoryFragmentDialog : DialogFragment() {

    private lateinit var listener : ICreateCategoryListener
    private val createCategoryViewModel : CreateCategoryViewModel by activityViewModels()
    private lateinit var binding : CreateCategoryViewBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        binding = DataBindingUtil.inflate(LayoutInflater.from(requireActivity()), R.layout.create_category_view, null, false)
        binding.lifecycleOwner = requireActivity()
        binding.createCategoryViewModel = createCategoryViewModel

        try {
            listener =
                requireActivity().supportFragmentManager.findFragmentById(R.id.mainActivityFragment) as ICreateCategoryListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() +
                    " must implement ICreateCategoryListener interface"))
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let { it ->
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setView(binding.root)
                .setTitle("Add Category")
                .setPositiveButton("Add"
                ) { _, _ ->
                    listener.onDialogPositiveClick(this, binding.categoryInputText.text.toString())
                }
                .setNeutralButton("Clear"
                ) { _, _ -> listener }
                .setNegativeButton("Cancel"
                ) { _, _ ->
                    // User cancelled the dialog
                    listener.onDialogNegativeClick(this)
                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}