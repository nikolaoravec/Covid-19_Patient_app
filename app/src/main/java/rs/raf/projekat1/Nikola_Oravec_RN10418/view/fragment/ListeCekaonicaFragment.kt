package rs.raf.projekat1.Nikola_Oravec_RN10418.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_ceka.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.adapter.CekajuAdapter
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Nikola_Oravec_RN10418.viewmodel.ListeViewModel

class ListeCekaonicaFragment : Fragment(R.layout.fragment_list_ceka) {

    private val listeViewModel: ListeViewModel by activityViewModels()
    private lateinit var cekajuAdapter: CekajuAdapter

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
        et_search_ceka.doAfterTextChanged {
            listeViewModel.filterPatientsCeka(it.toString())
        }
    }

    private fun initRecycler() {
        rv_ceka.layoutManager = LinearLayoutManager(context)
        cekajuAdapter = CekajuAdapter(PatientDiffItemCallback()) { patient: Patient, s: String ->
            if (s == "Zdrav") {
                listeViewModel.moveFromWaitingToReleased(patient)
            } else if (s == "Hospitalizuj") {
                listeViewModel.moveToHospitalised(patient)
            }
        }
        rv_ceka.adapter = cekajuAdapter
    }

    private fun initObservers() {
        listeViewModel.getPatientsCeka().observe(viewLifecycleOwner, Observer {
            cekajuAdapter.submitList(it)
        })
    }
}