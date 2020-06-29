package rs.raf.projekat1.Nikola_Oravec_RN10418.view.activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.viewpager.PagerAdapterMenu

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var user: String
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {

        sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        user = sharedPreferences.getString(LoginActivity.LOGIN_KEY, null).toString()

        initAdapter()
        initNavigation()

    }

    private fun initAdapter() {
        viewPager.adapter = PagerAdapterMenu(supportFragmentManager)
    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.unos -> {
                    viewPager.setCurrentItem(PagerAdapterMenu.FRAGMENT_UNOS, false)
                }
                R.id.stanje -> {
                    viewPager.setCurrentItem(PagerAdapterMenu.FRAGMENT_STANJE, false)
                }
                R.id.liste -> {
                    viewPager.setCurrentItem(PagerAdapterMenu.FRAGMENT_LISTE, false)
                }
                R.id.profil -> {
                    viewPager.setCurrentItem(PagerAdapterMenu.FRAGMENT_PROFIL, false)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}
