package rs.raf.projekat1.Nikola_Oravec_RN10418.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_stanje.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.viewmodel.ListeViewModel

class StanjeFragment : Fragment(R.layout.fragment_stanje) {

    private val listeViewModel: ListeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initObservers()
    }

    private fun initObservers() {
        listeViewModel.getPatientsHosp().observe(viewLifecycleOwner, Observer {
            et_broj_hospitalizovano.text = it.size.toString()
        })
        listeViewModel.getPatientsCeka().observe(viewLifecycleOwner, Observer {
            et_broj_cekaonica.text = it.size.toString()
        })
        listeViewModel.getPatientsOtpusteno().observe(viewLifecycleOwner, Observer {
            et_broj_otpusteno.text = it.size.toString()
        })
    }
}