package rs.raf.projekat1.Nikola_Oravec_RN10418.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_list_ceka_item.*
import kotlinx.android.synthetic.main.fragment_list_otpusteno_item.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient

class WaitingViewHolder (
    override val containerView: View,
    onItemClicked: (Int,String) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        btn_zdrav.setOnClickListener {
            onItemClicked.invoke(adapterPosition, btn_zdrav.text as String)
        }
        btn_hospitalizuj.setOnClickListener {
            onItemClicked.invoke(adapterPosition,btn_hospitalizuj.text as String)
        }
    }

    fun bind(patient: Patient) {
        Picasso
            .get()
            .load(patient.image)
            .into(iv_ceka_patientsPic)
        tv_name_patient_ceka.text = patient.name
        tv_lastname_patient_ceka.text = patient.lastname
        tv_ceka_stanje.text = patient.stanjePrijem
    }
}