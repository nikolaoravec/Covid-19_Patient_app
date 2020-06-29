package rs.raf.projekat1.Nikola_Oravec_RN10418.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.Nikola_Oravec_RN10418.view.fragment.*

class PagerAdapterTabs (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    companion object {
        private const val ITEM_COUNT = 3
        const val FRAGMENT_CEKAONICA = 0
        const val FRAGMENT_HOSPITALIZOVANO = 1
        const val FRAGMENT_OTPUSTENO = 2
    }
    override fun getItem(position: Int): Fragment {
        return when(position){
            FRAGMENT_CEKAONICA -> ListeCekaonicaFragment()
            FRAGMENT_HOSPITALIZOVANO -> ListeHospitalizovaniFragment()
            else -> ListeOtpusteniFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            FRAGMENT_CEKAONICA -> "Cekaonica"
            FRAGMENT_HOSPITALIZOVANO -> "Hospitalizovano"
            else -> "Otpusteno"
        }
    }
}