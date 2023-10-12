package com.avasia.reeltalk.welcomescreens.welcomepages.welcomedetails

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.avasia.reeltalk.welcomescreens.welcomepages.WelcomePageFragment

class WelcomeDetailsAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3 // Number of fragments
    }
    override fun createFragment(position: Int): Fragment {
        return WelcomePageFragment(position)
    }
}

