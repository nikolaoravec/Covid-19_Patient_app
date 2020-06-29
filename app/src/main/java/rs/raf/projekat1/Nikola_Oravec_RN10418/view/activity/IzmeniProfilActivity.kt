package rs.raf.projekat1.Nikola_Oravec_RN10418.view.activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_izmeni_profil.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R

class IzmeniProfilActivity : AppCompatActivity(R.layout.activity_izmeni_profil) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initListeners()
    }


    private fun initListeners() {

        btn_podaci_izmeni.setOnClickListener {
            if (check()) {
                addToSharedPref()
                setResult(Activity.RESULT_OK)
                finish()
            }
        }

        btn_odustani.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    private fun check(): Boolean {
        if (et_profil_ime_izmeni.text.isEmpty() || et_profil_prezime_izmeni.text.isEmpty() || et_profil_bolnica_izmeni.text.isEmpty()) {
            Toast.makeText(this, "Sva polja moraju da budu popunjena!", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun addToSharedPref() {
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val username: String? = et_profil_ime_izmeni.text.toString()
        val lastname: String? = et_profil_prezime_izmeni.text.toString()
        val bolnica: String? = et_profil_bolnica_izmeni.text.toString()
        val fullInfo = "$username.$lastname.$bolnica"
        editor.putString(LoginActivity.LOGIN_KEY, fullInfo)
        editor.apply()
    }
}