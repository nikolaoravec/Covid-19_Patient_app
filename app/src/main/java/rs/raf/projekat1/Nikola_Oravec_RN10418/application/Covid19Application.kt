package rs.raf.projekat1.Nikola_Oravec_RN10418.application

import android.app.Application
import timber.log.Timber

class Covid19Application : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

}