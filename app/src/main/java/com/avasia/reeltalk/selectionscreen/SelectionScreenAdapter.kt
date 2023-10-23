package com.avasia.reeltalk.selectionscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class SelectionScreenAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val pageCount: Int,
    private val getPage: (Int) -> Fragment
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return pageCount
    }

    override fun createFragment(position: Int): Fragment {
        return getPage(position)
    }
}