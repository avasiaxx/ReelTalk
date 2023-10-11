package com.avasia.reeltalk.welcomescreens

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.avasia.reeltalk.R
import com.avasia.reeltalk.databinding.FragmentWelcomeDetailsBinding
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class WelcomeDetailsFragment: Fragment(R.layout.fragment_welcome_details) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Bind the viewpager to it's adapter & dot indicator
        val view = inflater.inflate(R.layout.fragment_welcome_details, container, false)
        val viewPager2 = view.findViewById<ViewPager2>(R.id.viewpager)
        val adapter = WelcomeDetailsAdapter(this)
        val dotsIndicator = view.findViewById<WormDotsIndicator>(R.id.dots_indicator)
        viewPager2.adapter = adapter
        dotsIndicator.attachTo(viewPager2)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(
            view,
            savedInstanceState
        )

        val binding = FragmentWelcomeDetailsBinding.bind(view)

        /* Get the login textview string, format it with the correct color palette using
        ForegroundColorSpans & a spannableStringBuilder */

        val loginString: String =
            binding.root.context.resources.getString(
                R.string.already_have_an_account_login
            )
        val colorSpan1 = ForegroundColorSpan(
            ContextCompat.getColor(
                binding.root.context, R.color.highEmphasis
            )
        )
        val colorSpan2 = ForegroundColorSpan(
            ContextCompat.getColor(
                binding.root.context, R.color.colorPrimary
            )
        )
        val spannable = SpannableStringBuilder(loginString)
        spannable.setSpan(
            colorSpan1,
            0,
            24,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            colorSpan2,
            25,
            30,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.login.text = spannable


        //Set the visibility of the Continue Button depending on if the third fragment is selected
        val viewPager2 = binding.viewpager
        val continueBtn = binding.continueBtn
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if(position == 2){
                    continueBtn.visibility = View.VISIBLE
                }else{
                    continueBtn.visibility = View.GONE
                }
            }
        })

        continueBtn.setOnClickListener{
            findNavController().navigate(R.id.profileFragment)
        }
    }
}