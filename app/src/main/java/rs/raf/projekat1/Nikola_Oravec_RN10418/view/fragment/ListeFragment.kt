package rs.raf.projekat1.Nikola_Oravec_RN10418.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_list.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.viewpager.PagerAdapterTabs

class ListeFragment : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        listViewPager.adapter = PagerAdapterTabs(childFragmentManager)
        tl_liste.setupWithViewPager(listViewPager)
    }


}