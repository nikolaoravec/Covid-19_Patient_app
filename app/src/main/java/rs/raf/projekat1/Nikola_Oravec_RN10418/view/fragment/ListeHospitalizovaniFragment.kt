package rs.raf.projekat1.Nikola_Oravec_RN10418.view.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_hospitalizovano.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.activity.KartonActivity
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.adapter.HospitalizujAdapter
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Nikola_Oravec_RN10418.viewmodel.ListeViewModel
import timber.log.Timber

class ListeHospitalizovaniFragment : Fragment(R.layout.fragment_list_hospitalizovano) {

    companion object {
        const val PATIENT_REQUEST_CODE = 1
        const val NAME_MESSAGE = "nameMess"
        const val LASTNAME_MESSAGE = "lastnameMess"
        const val CONDITION_TREN_MESSAGE = "trenMess"
        const val CONDITION_MESSAGE = "prijemMess"
        const val DATE_PRIJEM = "date_prij"
        const val DATE_ODJAVA = "date_odj"
        const val IMAGE_MESSAGE = "image_msg"
        const val ID_MESSAGE = "id_msg"
    }


    private val listeViewModel: ListeViewModel by activityViewModels()
    private lateinit var hospitalizujAdapter: HospitalizujAdapter

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
        et_search_hosp.doAfterTextChanged {
            listeViewModel.filterPatientsHosp(it.toString())
        }
    }

    private fun initRecycler() {
        rv_hosp.layoutManager = LinearLayoutManager(context)
        hospitalizujAdapter =
            HospitalizujAdapter(PatientDiffItemCallback()) { patient: Patient, s: String ->
                if (s == "Karton") {
                    openMedicalRecord(patient)
                } else if (s == "Otpusti") {
                    listeViewModel.moveFromHospToReleased(patient)
                }
            }
        rv_hosp.adapter = hospitalizujAdapter
    }

    private fun openMedicalRecord(patient: Patient) {
        val intent = Intent(context, KartonActivity::class.java)
        intent.putExtra(KartonActivity.PATIENT_KEY, patient)
        startActivityForResult(intent, PATIENT_REQUEST_CODE)
    }

    //    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {

            data?.let { it ->
                val name: String = it.getStringExtra(NAME_MESSAGE) ?: ""
                val lastname: String = it.getStringExtra(LASTNAME_MESSAGE) ?: ""
                val trenStanje: String = it.getStringExtra(CONDITION_TREN_MESSAGE) ?: ""
                val prijemStanje: String = it.getStringExtra(CONDITION_MESSAGE) ?: ""
                val iStr = it.getStringExtra(ID_MESSAGE) ?: ""
                val i: Int = Integer.parseInt(iStr)
                val datePriojem: String = it.getStringExtra(DATE_PRIJEM) ?: ""
                val dateOdjava: String = it.getStringExtra(DATE_ODJAVA) ?: ""
                val imageStr = it.getStringExtra(IMAGE_MESSAGE) ?: ""
                val image: Int = Integer.parseInt(imageStr)
                val patient = Patient(
                    i,
                    name,
                    lastname,
                    prijemStanje,
                    trenStanje,
                    dateOdjava,
                    datePriojem,
                    image
                )

                listeViewModel.switchPacientsInfo(patient)
            }
        }
    }

    private fun initObservers() {
        listeViewModel.getPatientsHosp().observe(viewLifecycleOwner, Observer {
            hospitalizujAdapter.submitList(it)
        })
    }
}