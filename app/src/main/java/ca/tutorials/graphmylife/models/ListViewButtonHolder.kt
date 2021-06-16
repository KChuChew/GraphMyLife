package ca.tutorials.graphmylife.models

import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import ca.tutorials.graphmylife.R

class ListViewButtonHolder {
    lateinit var description : String
    lateinit var button : Button
    lateinit var supportFragmentManager : FragmentManager
    lateinit var fragment : Fragment
    lateinit var category : ChartCategory

    fun openNewFragment(supportFragmentManager : FragmentManager, fragment : Fragment) {
        supportFragmentManager.commit {
            replace(R.id.mainActivityFragment, fragment, "FRAGMENT TEST")
            addToBackStack(null)
        }
    }
}