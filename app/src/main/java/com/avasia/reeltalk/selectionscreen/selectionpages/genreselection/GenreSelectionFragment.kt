package com.avasia.reeltalk.selectionscreen.selectionpages.genreselection


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.avasia.reeltalk.databinding.FragmentGenreSelectionBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup


class GenreSelectionFragment : Fragment() {

    private lateinit var chipGroup: ChipGroup

    private val genreSelectionViewModel: GenreSelectionViewModel by activityViewModels()

    private var _binding: FragmentGenreSelectionBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(com.avasia.reeltalk.R.layout.fragment_genre_selection,
            container,
            false)
        _binding = FragmentGenreSelectionBinding.bind(view)
        chipGroup = binding.chipGroup
        addChipsToGroup()
        return view
    }

    private fun addChipsToGroup() {
        for (text in genreSelectionViewModel.genreOptions) {
            val chip = Chip(requireContext())
            chip.text = text
            val chipDrawable = ChipDrawable.createFromAttributes(
                requireContext(),
                null,
                0,
                com.avasia.reeltalk.R.style.ChipStyle
            )
            chip.setChipDrawable(chipDrawable)
            chip.setPadding(110, 60, 110, 60)

            chip.isCheckable = true
            chip.isChecked = false

            chip.setTextColor(ContextCompat.getColor(requireContext(),
                com.avasia.reeltalk.R.color.highEmphasis)
            )
            chip.setChipBackgroundColorResource(com.avasia.reeltalk.R.color.thirdSurface)

            // Handle Chip click events if needed
            chip.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    chip.setTextColor(ContextCompat.getColor(requireContext(),
                        com.avasia.reeltalk.R.color.thirdSurface)
                    )
                    chip.setChipBackgroundColorResource(com.avasia.reeltalk.R.color.highEmphasis)
                } else {
                    chip.setTextColor(ContextCompat.getColor(requireContext(),
                        com.avasia.reeltalk.R.color.highEmphasis)
                    )
                    chip.setChipBackgroundColorResource(com.avasia.reeltalk.R.color.thirdSurface)
                }
            }
            chipGroup.addView(chip)
            chipGroup.setChipSpacing(1)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}