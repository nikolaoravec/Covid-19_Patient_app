package rs.raf.projekat1.Nikola_Oravec_RN10418.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.Nikola_Oravec_RN10418.R
import rs.raf.projekat1.Nikola_Oravec_RN10418.model.Patient
import java.time.LocalDate


class ListeViewModel : ViewModel() {


    private val patientsOtpusteno : MutableLiveData<List<Patient>> = MutableLiveData()
    private val patientsListOtpusteno : MutableList<Patient> = mutableListOf()

    private val patientsHosp : MutableLiveData<List<Patient>> = MutableLiveData()
    private val patientsListHosp : MutableList<Patient> = mutableListOf()

    private val patientsCeka : MutableLiveData<List<Patient>> = MutableLiveData()
    private val patientsListCeka : MutableList<Patient> = mutableListOf()

    private var indexAdd = 61

    init {
        val listToSubmit = mutableListOf<Patient>()

        patientsListHosp.clear()
        patientsListOtpusteno.clear()

        var date = LocalDate.parse("2020-03-04")
        for (i in 1..20){
            val patient = Patient(i,"Patak","Daca","Kasalj i mala temperatura",
                "",date.toString(),"",
                R.drawable.donaldduck)
            patientsListCeka.add(patient)
        }

        date = LocalDate.parse("2020-04-12")
        for (i in 21..40){
            val patient = Patient(i,"Dusko","Dugousko","Blaga temperatura i simptomi prehlade",
                "",date.toString(),"",
                R.drawable.buggsbunny)
            patientsListCeka.add(patient)
        }

        date = LocalDate.parse("2020-03-02")
        for (i in 41..60){
            val patient = Patient(i,"Marvin","Marsovac","Zapaljenje pluca",
                "",date.toString(),"",
                R.drawable.marvin)
            patientsListCeka.add(patient)
        }

        listToSubmit.addAll(patientsListCeka)
        patientsCeka.value = listToSubmit
    }

    fun getPatientsCeka() : LiveData<List<Patient>>{
        return patientsCeka
    }
    fun getPatientsHosp() : LiveData<List<Patient>>{
        return patientsHosp
    }
    fun getPatientsOtpusteno() : LiveData<List<Patient>>{
        return patientsOtpusteno
    }

    fun filterPatientsCeka(filter:String){
        val filteredList = patientsListCeka.filter { it.name.toLowerCase().startsWith(filter.toLowerCase()) || it.lastname.toLowerCase().startsWith(filter.toLowerCase())}
            patientsCeka.value = filteredList
    }

    fun filterPatientsHosp(filter:String){
        val filteredList = patientsListHosp.filter { it.name.toLowerCase().startsWith(filter.toLowerCase()) || it.lastname.toLowerCase().startsWith(filter.toLowerCase())}
        patientsHosp.value = filteredList
    }

    fun filterPatientsOtpusteno(filter:String){
        val filteredList = patientsListOtpusteno.filter { it.name.toLowerCase().startsWith(filter.toLowerCase()) || it.lastname.toLowerCase().startsWith(filter.toLowerCase())}
        patientsOtpusteno.value = filteredList
    }

    fun addPatient(patient : Patient){

        patientsListCeka.add(patient)
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(patientsListCeka)
        patientsCeka.value = listToSubmit
        indexAdd+=1

    }

    fun moveFromWaitingToReleased(patient : Patient){

        val listToSubmit = mutableListOf<Patient>()
        val listToSubmit2 = mutableListOf<Patient>()

        patient.datum_odjava = LocalDate.now().toString()

        patientsListOtpusteno.add(patient)
        listToSubmit.addAll(patientsListOtpusteno)
        patientsOtpusteno.value = listToSubmit

        patientsListCeka.remove(patient)
        listToSubmit2.addAll(patientsListCeka)
        patientsCeka.value = listToSubmit2

    }

    fun moveFromHospToReleased(patient : Patient){

        val listToSubmit = mutableListOf<Patient>()
        val listToSubmit2 = mutableListOf<Patient>()

        patient.datum_odjava = LocalDate.now().toString()

        patientsListOtpusteno.add(patient)
        listToSubmit.addAll(patientsListOtpusteno)
        patientsOtpusteno.value = listToSubmit

        patientsListHosp.remove(patient)
        listToSubmit2.addAll(patientsListHosp)
        patientsHosp.value = listToSubmit2

    }

    fun moveToHospitalised(patient : Patient) {

        val listToSubmit = mutableListOf<Patient>()
        val listToSubmit2 = mutableListOf<Patient>()

        patientsListHosp.add(patient)
        listToSubmit.addAll(patientsListHosp)
        patientsHosp.value = listToSubmit

        patientsListCeka.remove(patient)
        listToSubmit2.addAll(patientsListCeka)
        patientsCeka.value = listToSubmit2
    }

    fun switchPacientsInfo(patient: Patient){
        val listToSubmit = mutableListOf<Patient>()
        val patientOld = patientsListHosp.find { p -> p.id == patient.id }
        val index = patientsListHosp.indexOf(patientOld)
        patientsListHosp.removeAt(index)
        patientsListHosp.add(index,patient)
        listToSubmit.addAll(patientsListHosp)
        patientsHosp.value = listToSubmit
    }

    fun getIndexAdd() : Int{
        return indexAdd
    }

}