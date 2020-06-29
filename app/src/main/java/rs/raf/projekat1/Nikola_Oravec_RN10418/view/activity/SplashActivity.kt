package rs.raf.projekat1.Nikola_Oravec_RN10418.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import timber.log.Timber

class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, LoginActivity::class.java)
        val intentMain = Intent(this, MainActivity::class.java)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val info: String? = sharedPreferences.getString(LoginActivity.LOGIN_KEY, null)
        if (info == null) {
            startActivity(intent)
            finish()
        } else {
            startActivity(intentMain)
            finish()
        }
    }
}