package rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.viewholder.ReleasedPatientViewHolder

class OtpusteniAdapter (
    patientDiffItemCallback: PatientDiffItemCallback,
    private val onPatientClicked : (Patient) -> Unit) : ListAdapter<Patient,ReleasedPatientViewHolder>(patientDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReleasedPatientViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.fragment_list_otpusteno_item, parent, false)
        return ReleasedPatientViewHolder(containerView) {
            val patient = getItem(it)
            onPatientClicked.invoke(patient)
        }
    }

    override fun onBindViewHolder(holder: ReleasedPatientViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }

}