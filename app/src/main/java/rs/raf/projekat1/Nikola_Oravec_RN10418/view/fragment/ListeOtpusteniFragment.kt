package rs.raf.projekat1.Nikola_Oravec_RN10418.view.fragment

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_list_otpusteno.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.adapter.OtpusteniAdapter
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Nikola_Oravec_RN10418.viewmodel.ListeViewModel

class ListeOtpusteniFragment : Fragment(R.layout.fragment_list_otpusteno) {

    private val listeViewModel: ListeViewModel by activityViewModels()
    private lateinit var otpusteniAdapter: OtpusteniAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initUi()
        initObservers()
    }

    private fun initUi() {
        initListeners()
        initRecycler()
    }

    private fun initListeners() {
        et_search_otpusteno.doAfterTextChanged {
            listeViewModel.filterPatientsOtpusteno(it.toString())
        }
    }

    private fun initRecycler() {
        rv_otpusteno.layoutManager = GridLayoutManager(context, 2)
        otpusteniAdapter = OtpusteniAdapter(PatientDiffItemCallback()) {
        }
        rv_otpusteno.adapter = otpusteniAdapter
    }

    private fun initObservers() {
        listeViewModel.getPatientsOtpusteno().observe(viewLifecycleOwner, Observer {
            otpusteniAdapter.submitList(it)
        })
    }
}