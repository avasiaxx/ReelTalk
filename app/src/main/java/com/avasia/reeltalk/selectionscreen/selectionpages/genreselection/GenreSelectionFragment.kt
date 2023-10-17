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

/**
 * Fragment for selecting genres using Chips.
 * This fragment allows users to choose from a list of genres presented as Chips.
 * The selected genres are displayed at the top, and unselected genres can be disabled.
 * It interacts with the `GenreSelectionViewModel` to manage selected genres and provides
 * a user-friendly interface for genre selection.
 *
 * This class handles the following key features:
 * - Displaying a list of selectable genres as Chips.
 * - Updating the list of selected genres as Chips are selected or deselected.
 * - Disabling unselected genres when a maximum selection limit is reached.
 *
 * @property chipGroup A `ChipGroup` for displaying and managing the genre Chips.
 * @property genreSelectionViewModel The associated ViewModel for genre selection logic.
 * @property _binding A reference to the binding for the Fragment layout.
 */

class GenreSelectionFragment : Fragment() {

    private lateinit var chipGroup: ChipGroup

    private val genreSelectionViewModel: GenreSelectionViewModel by activityViewModels()

    private var _binding: FragmentGenreSelectionBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            com.avasia.reeltalk.R.layout.fragment_genre_selection,
            container,
            false
        )
        _binding = FragmentGenreSelectionBinding.bind(view)
        chipGroup = binding.chipGroup
        addChipsToGroup()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        genreSelectionViewModel.selected.observe(viewLifecycleOwner) {
            val amountSelected = genreSelectionViewModel.selected.value
            val newSelectionTest = "$amountSelected${binding.selected.text.substring(1)}"
            binding.selected.text = newSelectionTest

            if (genreSelectionViewModel.checkIfMaxSelected()) {
                disableUnselectedChips()
            } else {
                enableUnselectedChips()
            }
        }
    }

    private fun addChipsToGroup() {
        for (text in genreSelectionViewModel.genreOptions) {
            val chip = createConfiguredChip(text)
            chipGroup.addView(chip)
            chipGroup.setChipSpacing(1)
        }
    }

    private fun setChipsEnabled(isEnabled: Boolean) {
        for (i in 0 until chipGroup.childCount) {
            val chip = chipGroup.getChildAt(i) as Chip
            if (!chip.isChecked) {
                chip.isEnabled = isEnabled
            }
        }
    }

    private fun disableUnselectedChips() {
        setChipsEnabled(false)
    }

    private fun enableUnselectedChips() {
        setChipsEnabled(true)
    }

    private fun createConfiguredChip(text: String): Chip {
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

        val highEmphasisColor = ContextCompat.getColor(
            requireContext(),
            com.avasia.reeltalk.R.color.highEmphasis
        )
        val thirdSurfaceColor = ContextCompat.getColor(
            requireContext(),
            com.avasia.reeltalk.R.color.thirdSurface
        )

        chip.setTextColor(highEmphasisColor)
        chip.setChipBackgroundColorResource(com.avasia.reeltalk.R.color.thirdSurface)

        chip.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                chip.setTextColor(thirdSurfaceColor)
                chip.setChipBackgroundColorResource(com.avasia.reeltalk.R.color.highEmphasis)
                genreSelectionViewModel.onIncrease()
            } else {
                chip.setTextColor(highEmphasisColor)
                chip.setChipBackgroundColorResource(com.avasia.reeltalk.R.color.thirdSurface)
                genreSelectionViewModel.onDecrease()
            }
        }
        return chip
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}