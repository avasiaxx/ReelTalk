package com.avasia.reeltalk.welcomescreens.welcomepages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.avasia.reeltalk.R
import com.avasia.reeltalk.databinding.FragmentWelcomePageBinding

class WelcomePageFragment(private val position: Int): Fragment() {

    private val welcomePageViewModel: WelcomePageViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentWelcomePageBinding.bind(view)
        setFragmentDetails(binding)
    }

    private fun setFragmentDetails(binding: FragmentWelcomePageBinding) {
        val (image, text) = welcomePageViewModel.getPageDetails()[position]
        binding.imageView.setImageResource(image)
        binding.textView2.text = resources.getString(text)
    }
}