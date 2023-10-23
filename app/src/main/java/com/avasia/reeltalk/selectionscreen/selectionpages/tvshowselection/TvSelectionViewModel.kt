package com.avasia.reeltalk.selectionscreen.selectionpages.tvshowselection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avasia.reeltalk.R
import com.avasia.reeltalk.data.models.Show

class TvSelectionViewModel : ViewModel() {

    private val _tvShows = MutableLiveData<List<Show>>(emptyList())
    val tvShows: LiveData<List<Show>>
        get() = _tvShows

    private val _selectedTvShows = MutableLiveData<List<Show>>(emptyList())
    val selectedTvShows
        get() = _selectedTvShows

    init {
        _tvShows.value = tvShowsList
    }

    fun onTvSelected(show: Show) {
        val selectionSize = _selectedTvShows.value?.size ?: 0
        if (!show.selected && selectionSize < MAX_SELECTED) {
            show.selected = true
            val currentSelection = _selectedTvShows.value?.toMutableList() ?: mutableListOf()
            currentSelection.add(show)
            _selectedTvShows.value = currentSelection
        } else {
            show.selected = false
            val currentSelection = _selectedTvShows.value?.toMutableList() ?: mutableListOf()
            currentSelection.remove(show)
            _selectedTvShows.value = currentSelection
        }
    }

    companion object {
        /**
         * The maximum number of genres that can be selected.
         */
        const val MAX_SELECTED = 5

        private val tvShowsList = listOf(
            Show(
                R.drawable.disenchantment,
                "Disenchantment"
            ),
            Show(
                R.drawable.youngsheldon,
                "Young Sheldon"
            ),
            Show(
                R.drawable.bigbangtheory,
                "Big Bang Theory"
            ),
            Show(
                R.drawable.mandalorian,
                "Mandalorian"
            ),
            Show(
                R.drawable.demonslayer,
                "Demon Slayer"
            ),
            Show(
                R.drawable.strangerthings,
                "Stranger Things"
            )
        )
    }
}