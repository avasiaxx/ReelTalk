package com.avasia.reeltalk.selectionscreen.selectionpages.movieselection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avasia.reeltalk.R
import com.avasia.reeltalk.data.models.Show

class MovieSelectionViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<Show>>(emptyList())
    val movies: LiveData<List<Show>>
        get() = _movies

    private val _selectedMovies = MutableLiveData<List<Show>>(emptyList())
    val selectedMovies
        get() = _selectedMovies

    init {
        _movies.value = moviesList
    }

    fun onMovieSelected(show: Show) {
        val selectionSize = _selectedMovies.value?.size ?: 0
        if (!show.selected && selectionSize < MAX_SELECTED) {
            show.selected = true
            val currentSelection = _selectedMovies.value?.toMutableList() ?: mutableListOf()
            currentSelection.add(show)
            _selectedMovies.value = currentSelection
        } else {
            show.selected = false
            val currentSelection = _selectedMovies.value?.toMutableList() ?: mutableListOf()
            currentSelection.remove(show)
            _selectedMovies.value = currentSelection
        }
    }

    companion object {
        /**
         * The maximum number of genres that can be selected.
         */
        const val MAX_SELECTED = 5

        private val moviesList = listOf(
            Show(
                R.drawable.bohemian,
                "Bohemian Rhapsody"
            ),
            Show(
                R.drawable.deadpool,
                "Deadpool"
            ),
            Show(
                R.drawable.black_panther,
                "Black Panther"
            ),
            Show(
                R.drawable.guardiansofthegalaxy,
                "Guardians Of The Galaxy Vol2"
            ),
            Show(
                R.drawable.jurassicpark,
                "Jurassic Park"
            ),
            Show(
                R.drawable.starwars,
                "Star Wars: Return Of The Jedi"
            )
        )
    }
}