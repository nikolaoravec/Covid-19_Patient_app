package rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.viewholder.HospitalizovaniViewHolder

class HospitalizujAdapter(
    patientDiffItemCallback: PatientDiffItemCallback,
    private val onPatientClicked: (Patient, String) -> Unit
) : ListAdapter<Patient, HospitalizovaniViewHolder>(patientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalizovaniViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView =
            layoutInflater.inflate(R.layout.fragment_list_hospitalizovano_item, parent, false)
        return HospitalizovaniViewHolder(containerView) { i: Int, s: String ->
            val patient = getItem(i)
            onPatientClicked.invoke(patient,s)
        }
    }

    override fun onBindViewHolder(holder: HospitalizovaniViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }
}