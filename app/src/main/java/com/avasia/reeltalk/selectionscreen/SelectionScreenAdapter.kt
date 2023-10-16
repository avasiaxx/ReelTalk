package com.avasia.reeltalk.selectionscreen

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.avasia.reeltalk.selectionscreen.selectionpages.genreselection.GenreSelectionFragment

class SelectionScreenAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return GenreSelectionFragment()
    }
}