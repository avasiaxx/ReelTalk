package com.avasia.reeltalk.welcomescreens.welcomepages.welcomedetails

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

/**
 * This fragment utilizes a ViewPager to showcase images and their respective descriptions.
 * Users can effortlessly navigate through images and their descriptions with the assistance
 * of a dot indicator at the screen's bottom.
 */
class WelcomeDetailsFragment: Fragment(R.layout.fragment_welcome_details) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        binding.login.text = formatLoginString(binding)

        val viewPager2 = binding.viewpager
        val continueBtn = binding.continueBtn
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if(position == LAST_FRAGMENT){
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
    private fun findLoginPosition(inputString: String): Pair<Int, Int>?{
        val startIndex = inputString.indexOf("Login")
        val endIndex = startIndex + "Login".length

        return if (startIndex >= 0) {
            Pair(startIndex, endIndex)
        } else {
            null
        }
    }

    private fun findPositionBeforeLogin(inputString: String): Int?{
        val loginIndex = inputString.indexOf("Login")
        return if (loginIndex > 0) {
            loginIndex - 1
        } else {
            null
        }
    }

    private fun formatLoginString(binding: FragmentWelcomeDetailsBinding): SpannableStringBuilder {
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
        val beforeLoginResult = findPositionBeforeLogin(loginString)
        if(beforeLoginResult != null){
            val (start,end) = Pair(START, beforeLoginResult)
            spannable.setSpan(
                colorSpan1,
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        val loginResult = findLoginPosition(loginString)
        if(loginResult!= null){
            val (start, end) = loginResult
            spannable.setSpan(
                colorSpan2,
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        return spannable
    }
    companion object {
        private const val START = 0
        private const val LAST_FRAGMENT = 2
    }
}