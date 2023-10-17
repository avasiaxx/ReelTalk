package com.avasia.reeltalk.selectionscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.avasia.reeltalk.R
import com.avasia.reeltalk.databinding.FragmentSelectionScreenBinding
import com.avasia.reeltalk.selectionscreen.selectionpages.genreselection.GenreSelectionViewModel

class SelectionScreenFragment : Fragment() {

    private var _binding: FragmentSelectionScreenBinding? = null
    private val binding get() = _binding!!

    private val genreSelectionViewModel: GenreSelectionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_selection_screen, container, false)
        _binding = FragmentSelectionScreenBinding.bind(view)
        val viewPager2 = binding.viewpager
        val adapter = SelectionScreenAdapter(this)
        val dotsIndicator = binding.dotsIndicator
        viewPager2.adapter = adapter
        viewPager2.isUserInputEnabled = false
        dotsIndicator.attachTo(viewPager2)
        genreSelectionViewModel.selected.observe(viewLifecycleOwner) {
            if (it == MAX_SELECTION) {
                enableButton()
            } else {
                disableButton()
            }
        }
        binding.continueBtn.setOnClickListener {
            viewPager2.currentItem += 1
            disableButton()
        }
        return view
    }

    /**
     * Enables the "Continue" button by enabling its click ability and updating its text color.
     */
    private fun enableButton() {
        binding.continueBtn.isEnabled = true
        binding.continueBtn.setTextColor(getColor(requireContext(), R.color.thirdSurface))
    }


    /**
     * Disables the "Continue" button by disabling its click ability and updating its text color.
     */
    private fun disableButton() {
        binding.continueBtn.setTextColor(getColor(requireContext(), R.color.thirdSurface))
        binding.continueBtn.isEnabled = false
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    /**
     * A companion object to hold the maximum allowed selection count for genres.
     * This constant defines the maximum number of genres a user can select.
     */
    companion object {
        const val MAX_SELECTION = 3
    }
}