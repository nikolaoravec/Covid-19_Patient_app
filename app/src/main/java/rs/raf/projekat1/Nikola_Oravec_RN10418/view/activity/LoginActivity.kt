package rs.raf.projekat1.Nikola_Oravec_RN10418.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R


class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    companion object {
        const val LOGIN_KEY = "loginKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginBtn.setOnClickListener {

            if (check()) {
                val intentmain = Intent(this, MainActivity::class.java)
                startActivity(intentmain)
                finish()
            }
        }
    }

    private fun check(): Boolean {

        if (editTextName.text.isEmpty() || editTextSurname.text.isEmpty() || editTextBolnica.text.isEmpty()) {
            Toast.makeText(this, "Sva polja moraju da budu popunjena!", Toast.LENGTH_SHORT).show()
            return false
        }

        if (editTextPIN.text.isEmpty()) {
            Toast.makeText(this, "Unesite PIN", Toast.LENGTH_SHORT).show()
            return false
        }
        if (editTextPIN.text.toString().length != 4) {
            Toast.makeText(this, "PIN treba da sadzi 4 cifre!", Toast.LENGTH_SHORT).show()
            return false
        }

        if (editTextPIN.text.toString() != "0000") {
            Toast.makeText(this, "PIN je pogresan!", Toast.LENGTH_SHORT).show()
            return false
        }

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val username: String? = editTextName.text.toString()
        val lastname: String? = editTextSurname.text.toString()
        val bolnica: String? = editTextBolnica.text.toString()
        val pin: String? = editTextPIN.text.toString()
        val fullInfo = "$username.$lastname.$bolnica.$pin"
        editor.putString(LOGIN_KEY, fullInfo)
        editor.apply()
        return true
    }
}