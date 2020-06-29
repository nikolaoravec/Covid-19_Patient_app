package rs.raf.projekat1.Nikola_Oravec_RN10418.view.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profil.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.activity.IzmeniProfilActivity
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.activity.LoginActivity

class ProfilFragment : Fragment(R.layout.fragment_profil) {

    companion object {
        const val WORKER_RECEIVED_REQUEST_CODE = 1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initListeners()
    }

    private fun init(){

        initTextViews()
        initListeners()

    }

    private fun initTextViews(){
        val sharedPreferences = requireContext().getSharedPreferences(requireContext().packageName, Context.MODE_PRIVATE)
        val arrShared = sharedPreferences.getString(LoginActivity.LOGIN_KEY,null)!!.split(".")
        tv_profil_ime.text = arrShared[0]
        tv_profil_prezime.text = arrShared[1]
        tv_profil_bolnica.text = arrShared[2]
    }

    private fun initListeners(){
        btn_odjava.setOnClickListener {
            val sharedPref = requireContext().getSharedPreferences(context?.packageName, Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        btn_izmeni.setOnClickListener {
            val intent = Intent(context, IzmeniProfilActivity::class.java)
            startActivityForResult(intent,WORKER_RECEIVED_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            WORKER_RECEIVED_REQUEST_CODE -> {
                if(resultCode == Activity.RESULT_OK){
                    initTextViews()
                }
            }
        }

    }

}