package rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.viewholder.WaitingViewHolder

class CekajuAdapter(
    patientDiffItemCallback: PatientDiffItemCallback,
    private val onPatientClicked: (Patient,String) -> Unit
) : ListAdapter<Patient, WaitingViewHolder>(patientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaitingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView =
            layoutInflater.inflate(R.layout.fragment_list_ceka_item, parent, false)
        return WaitingViewHolder(containerView) { pos: Int, btn: String ->
            val patient = getItem(pos)
            onPatientClicked.invoke(patient, btn)
        }
    }

    override fun onBindViewHolder(holder: WaitingViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }
}
