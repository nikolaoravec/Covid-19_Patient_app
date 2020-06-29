package rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient

class PatientDiffItemCallback : DiffUtil.ItemCallback<Patient>() {

    override fun areItemsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.name == newItem.name &&
                oldItem.lastname == newItem.lastname &&
                oldItem.stanjePrijem == newItem.stanjePrijem &&
                oldItem.stanjeTren == newItem.stanjeTren &&
                oldItem.datum_prijem == newItem.datum_prijem &&
                oldItem.datum_odjava == newItem.datum_odjava
    }
}