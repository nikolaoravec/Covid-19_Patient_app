package rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_list_ceka_item.*
import kotlinx.android.synthetic.main.fragment_list_hospitalizovano_item.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient

class HospitalizovaniViewHolder (
    override val containerView: View,
    onItemClicked: (Int, String) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        btn_karton.setOnClickListener {
            onItemClicked.invoke(adapterPosition, btn_karton.text as String)
        }
        btn_otpusti.setOnClickListener {
            onItemClicked.invoke(adapterPosition, btn_otpusti.text as String)
        }
    }

    fun bind(patient: Patient) {
        Picasso
            .get()
            .load(patient.image)
            .into(iv_hosp_patientsPic)
        tv_name_patient_hosp.text = patient.name
        tv_lastname_patient_hosp.text = patient.lastname
    }
}