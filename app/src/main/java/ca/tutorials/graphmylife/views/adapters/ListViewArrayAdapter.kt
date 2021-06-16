package ca.tutorials.graphmylife.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.findViewTreeLifecycleOwner
import ca.tutorials.graphmylife.R
import ca.tutorials.graphmylife.databinding.ListViewButtonItemBinding
import ca.tutorials.graphmylife.models.ListViewButtonHolder
import ca.tutorials.graphmylife.viewmodels.CreateCategoryViewModel
import ca.tutorials.graphmylife.views.MainActivity
import ca.tutorials.graphmylife.views.fragments.DisplayGraphFragment

class ListViewArrayAdapter(context : Context, resource : Int, items : ArrayList<ListViewButtonHolder>) : ArrayAdapter<ListViewButtonHolder>(context, resource, items) {
    private val layout = resource
    private lateinit var binding : ListViewButtonItemBinding

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val inflater = LayoutInflater.from(context)
        var data = getItem(position)

        binding = DataBindingUtil.inflate(inflater, R.layout.list_view_button_item, parent, false)
        //binding = convertView?.let { DataBindingUtil.findBinding(it) }!!
        //binding = DataBindingUtil.getBinding<>()
        //binding = convertView?.let { ListViewButtonItemBinding.bind(it) }!!
        binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()

        /*if(view == null)  {
            view = inflater.inflate(layout, parent, false) as View
        }*?

        //var b = view.findViewById<Button>(R.id.listViewButton)
        //binding = ListViewButtonItemBinding.inflate(inflater, parent, false)

        //listViewButtonHolder.button = binding.listViewButton;
        if (data != null) {
            binding.listViewButton.text = data.description
        }*/
        binding.listViewButton.text = data?.description
        binding.listViewButton.setOnClickListener {
            Toast.makeText(context, "Button Clicked for Item $position", Toast.LENGTH_SHORT).show()
            data?.openNewFragment(data?.supportFragmentManager, data?.fragment)
        }

        //return super.getView(position, view, parent)
        return binding.root
    }
}