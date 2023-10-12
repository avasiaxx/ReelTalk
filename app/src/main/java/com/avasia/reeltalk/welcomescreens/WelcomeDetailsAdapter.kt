package com.avasia.reeltalk.welcomescreens

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.avasia.reeltalk.welcomescreens.welcomepages.WelcomePage1Fragment
import com.avasia.reeltalk.welcomescreens.welcomepages.WelcomePage2Fragment
import com.avasia.reeltalk.welcomescreens.welcomepages.WelcomePage3Fragment

class WelcomeDetailsAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3 // Number of fragments
    }
    //TODO Use a list from a lazy global variable to get rid of the when statement and use the index
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> WelcomePage1Fragment()
            1 -> WelcomePage2Fragment()
            2 -> WelcomePage3Fragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
