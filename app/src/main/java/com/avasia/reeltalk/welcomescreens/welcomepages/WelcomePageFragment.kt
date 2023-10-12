package com.avasia.reeltalk.welcomescreens.welcomepages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.avasia.reeltalk.R
import com.avasia.reeltalk.databinding.FragmentWelcomePageBinding

class WelcomePageFragment(private val position: Int): Fragment() {
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
    private fun setFragmentDetails(binding: FragmentWelcomePageBinding){
        when (position) {
            0 -> setPage1(binding)
            1 -> setPage2(binding)
            2 -> setPage3(binding)
    }
}

    private fun setPage1(binding: FragmentWelcomePageBinding){
        binding.imageView.setImageResource(
            R.drawable.illustration1
        )
        binding.textView2.text = resources.getString(
            R.string.welcome_to_reel_talk_a_community_designed_for_true_film_and_tv_show_fans
        )
    }

    private fun setPage2(binding: FragmentWelcomePageBinding){
        binding.imageView.setImageResource(
            R.drawable.illustration2
        )
        binding.textView2.text = resources.getString(
            R.string.discover_and_discuss_your_favorite_films_n_movies_and_shows
        )
    }

    private fun setPage3(binding: FragmentWelcomePageBinding){
        binding.imageView.setImageResource(
            R.drawable.illustration3
        )
        binding.textView2.text = resources.getString(
            R.string.let_s_get_started
        )
    }
}