package rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_list_otpusteno_item.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient
import timber.log.Timber

class ReleasedPatientViewHolder(
    override val containerView: View,
    onItemClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        iv_released_patientPic.setOnClickListener {
            onItemClicked.invoke(adapterPosition)
        }
    }

    fun bind(patient: Patient) {
        Picasso
            .get()
            .load(patient.image)
            .into(iv_released_patientPic)
        tv_name_patient.text = patient.name
        tv_lastname_patient.text = patient.lastname
        dateTi.text = patient.datum_odjava
    }
}