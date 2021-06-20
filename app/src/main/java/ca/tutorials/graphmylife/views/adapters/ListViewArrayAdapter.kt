package ca.tutorials.graphmylife.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.findViewTreeLifecycleOwner
import ca.tutorials.graphmylife.R
import ca.tutorials.graphmylife.databinding.ListViewButtonItemBinding
import ca.tutorials.graphmylife.models.ListViewButtonHolder

class ListViewArrayAdapter(context : Context, resource : Int, items : ArrayList<ListViewButtonHolder>) : ArrayAdapter<ListViewButtonHolder>(context, resource, items) {
    private lateinit var binding : ListViewButtonItemBinding

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        var data = getItem(position)

        binding = DataBindingUtil.inflate(inflater, R.layout.list_view_button_item, parent, false)
        binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
        binding.listViewButton.text = data?.description
        binding.listViewButton.setOnClickListener {
            Toast.makeText(context, "Button Clicked for Item $position", Toast.LENGTH_SHORT).show()
            data?.openNewFragment(data?.supportFragmentManager, data?.fragment)
        }

        return binding.root
    }
}