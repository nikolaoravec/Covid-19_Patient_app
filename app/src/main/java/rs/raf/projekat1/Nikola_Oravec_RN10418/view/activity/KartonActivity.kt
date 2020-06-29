package rs.raf.projekat1.Nikola_Oravec_RN10418.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_karton.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.fragment.ListeHospitalizovaniFragment

class KartonActivity : AppCompatActivity(R.layout.activity_karton) {

    companion object {
        const val PATIENT_KEY = "patient_key"
    }

    private var patient: Patient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        parseIntent()
        initListeners()
    }

    private fun initListeners() {

        btn_karton_izmeni.setOnClickListener {
            val intent = Intent()
            if (check()) {
                intent.putExtra(
                    ListeHospitalizovaniFragment.NAME_MESSAGE,
                    et_karton_ime.text.toString()
                )
                intent.putExtra(
                    ListeHospitalizovaniFragment.LASTNAME_MESSAGE,
                    et_karton_prezime.text.toString()
                )
                intent.putExtra(
                    ListeHospitalizovaniFragment.CONDITION_MESSAGE,
                    ev_karton_priprijemu.text.toString()
                )
                intent.putExtra(
                    ListeHospitalizovaniFragment.CONDITION_TREN_MESSAGE,
                    ev_karton_trenutno.text.toString()
                )
                intent.putExtra(ListeHospitalizovaniFragment.DATE_PRIJEM, tv_karton_datum.text)
                intent.putExtra(ListeHospitalizovaniFragment.DATE_ODJAVA, patient?.datum_odjava)
                intent.putExtra(
                    ListeHospitalizovaniFragment.IMAGE_MESSAGE,
                    (patient?.image!!).toString()
                )
                intent.putExtra(ListeHospitalizovaniFragment.ID_MESSAGE, (patient?.id!!).toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

        btn_karton_odustani.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    private fun parseIntent() {
        intent?.let {
            patient = it.getParcelableExtra(PATIENT_KEY)
            val name = patient?.name
            val lastname = patient?.lastname
            val trenS = patient?.stanjeTren
            val prijemS = patient?.stanjePrijem
            val datumPrijem = patient?.datum_prijem

            et_karton_ime.setText(name)
            et_karton_prezime.setText(lastname)
            ev_karton_priprijemu.setText(prijemS)
            ev_karton_trenutno.setText(trenS)
            tv_karton_datum.text = datumPrijem
        }
    }

    private fun check(): Boolean {
        if (et_karton_ime.text.isEmpty() || et_karton_prezime.text.isEmpty() || ev_karton_priprijemu.text.isEmpty() || ev_karton_trenutno.text.isEmpty()) {
            Toast.makeText(this, "Sva polja moraju da budu popunjena!", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}