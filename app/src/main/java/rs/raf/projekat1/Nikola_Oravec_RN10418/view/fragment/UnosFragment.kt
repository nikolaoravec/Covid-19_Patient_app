package rs.raf.projekat1.Nikola_Oravec_RN10418.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_unos.*
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient
import rs.raf.projekat1.Nikola_Oravec_RN10418.viewmodel.ListeViewModel
import java.time.LocalDate

class UnosFragment : Fragment(R.layout.fragment_unos) {

    private val listeViewModel : ListeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){

        btn_dodaj.setOnClickListener {
            if(editTextUnosIme.text.isEmpty() || editTextUnosSurname.text.isEmpty() || editTextunosSimptom.text.isEmpty()){
                Toast.makeText(context,"Sva polja moraju biti popunjena!",Toast.LENGTH_SHORT).show()
            }else{

                listeViewModel.addPatient(createPatient())
                Toast.makeText(context,"Pacijent dodat!",Toast.LENGTH_SHORT).show()
                editTextUnosIme.text.clear()
                editTextUnosSurname.text.clear()
                editTextunosSimptom.text.clear()
            }
        }
    }

    private fun createPatient() : Patient{

        val ime = editTextUnosIme.text.toString()
        val prezime = editTextUnosSurname.text.toString()
        val simptomi = editTextunosSimptom.text.toString()
        val datumPrijema = LocalDate.now().toString()

        return Patient(listeViewModel.getIndexAdd(),ime,prezime,simptomi,"",datumPrijema,"",R.drawable.anon)
    }
}