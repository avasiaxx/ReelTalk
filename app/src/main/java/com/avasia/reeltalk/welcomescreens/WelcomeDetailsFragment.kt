package com.avasia.reeltalk.welcomescreens

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.avasia.reeltalk.R
import com.avasia.reeltalk.databinding.FragmentWelcomeDetailsBinding

class WelcomeDetailsFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_welcome_details,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(
            view,
            savedInstanceState
        )

        /* Get the login textview string, format it with the correct color palette using
        ForegroundColorSpans & a spannableStringBuilder */
        val binding = FragmentWelcomeDetailsBinding.bind(view)
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
    }
}