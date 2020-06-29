package rs.raf.projekat1.Nikola_Oravec_RN10418.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Patient(
    val id: Int,
    val name: String,
    val lastname: String,
    val stanjePrijem: String,
    val stanjeTren: String,
    val datum_prijem: String,
    var datum_odjava: String,
    val image: Int
) : Parcelable