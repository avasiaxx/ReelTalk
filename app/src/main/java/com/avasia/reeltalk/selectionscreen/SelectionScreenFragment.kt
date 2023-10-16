package com.avasia.reeltalk.selectionscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.avasia.reeltalk.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class SelectionScreenFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_selection_screen, container, false)
        val viewPager2 = view.findViewById<ViewPager2>(R.id.viewpager)
        val adapter = SelectionScreenAdapter(this)
        val dotsIndicator = view.findViewById<DotsIndicator>(R.id.dots_indicator)
        viewPager2.adapter = adapter
        dotsIndicator.attachTo(viewPager2)
        return view
    }


}