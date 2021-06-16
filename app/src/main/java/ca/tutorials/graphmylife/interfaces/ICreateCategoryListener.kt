package ca.tutorials.graphmylife.interfaces

import androidx.fragment.app.DialogFragment

interface ICreateCategoryListener {
    fun onDialogPositiveClick(dialog : DialogFragment, categoryName : String)
    fun onDialogNegativeClick(dialog : DialogFragment)
}