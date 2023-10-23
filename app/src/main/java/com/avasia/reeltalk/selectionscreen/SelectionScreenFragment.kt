package com.avasia.reeltalk.selectionscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.avasia.reeltalk.R
import com.avasia.reeltalk.databinding.FragmentSelectionScreenBinding
import com.avasia.reeltalk.selectionscreen.selectionpages.tvshowselection.TvSelectionFragment
import com.avasia.reeltalk.selectionscreen.selectionpages.genreselection.GenreSelectionFragment
import com.avasia.reeltalk.selectionscreen.selectionpages.genreselection.GenreSelectionViewModel
import com.avasia.reeltalk.selectionscreen.selectionpages.movieselection.MovieSelectionFragment
import com.avasia.reeltalk.selectionscreen.selectionpages.movieselection.MovieSelectionViewModel
import com.avasia.reeltalk.selectionscreen.selectionpages.tvshowselection.TvSelectionViewModel

class SelectionScreenFragment : Fragment() {

    private var _binding: FragmentSelectionScreenBinding? = null
    private val binding get() = _binding!!

    private val genreSelectionViewModel: GenreSelectionViewModel by activityViewModels()
    private val movieSelectionViewModel: MovieSelectionViewModel by activityViewModels()
    private val tvSelectionViewModel: TvSelectionViewModel by activityViewModels()

    private var allSelected = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_selection_screen, container, false)
        _binding = FragmentSelectionScreenBinding.bind(view)
        val viewPager2 = binding.viewpager

        val adapter = SelectionScreenAdapter(parentFragmentManager, lifecycle, 3, ::getPage)
        val dotsIndicator = binding.dotsIndicator
        viewPager2.adapter = adapter
        viewPager2.isUserInputEnabled = false
        dotsIndicator.attachTo(viewPager2)
        genreSelectionViewModel.selected.observe(viewLifecycleOwner) {
            if (it == MAX_GENRE_SELECTION) {
                enableButton()
            } else {
                disableButton()
            }
        }
        movieSelectionViewModel.selectedMovies.observe(viewLifecycleOwner) {
            if (it.size == MAX_MOVIE_TV_SELECTION) {
                enableButton()
            } else {
                disableButton()
            }
        }
        tvSelectionViewModel.selectedTvShows.observe(viewLifecycleOwner) {
            allSelected = if (it.size == MAX_MOVIE_TV_SELECTION) {
                enableButton()
                true
            } else {
                disableButton()
                false
            }
        }
        binding.continueBtn.setOnClickListener {
            if (!allSelected) {
                viewPager2.currentItem += 1
                disableButton()
            } else {
                findNavController().navigate(R.id.endScreenFragment)
            }
        }
        return view
    }

    private fun getPage(position: Int): Fragment {
        return when (position) {
            0 -> GenreSelectionFragment()
            1 -> MovieSelectionFragment()
            2 -> TvSelectionFragment()
            else -> GenreSelectionFragment()
        }
    }

    /**
     * Enables the "Continue" button by enabling its click ability and updating its text color.
     */
    private fun enableButton() {
        binding.continueBtn.isEnabled = true
        binding.continueBtn.setTextColor(getColor(requireContext(), R.color.firstSurface))
    }


    /**
     * Disables the "Continue" button by disabling its click ability and updating its text color.
     */
    private fun disableButton() {
        binding.continueBtn.setTextColor(getColor(requireContext(), R.color.firstSurface))
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
        const val MAX_GENRE_SELECTION = 3
        const val MAX_MOVIE_TV_SELECTION = 5
    }
}