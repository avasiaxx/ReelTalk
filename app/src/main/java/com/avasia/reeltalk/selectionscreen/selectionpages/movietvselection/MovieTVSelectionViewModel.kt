package com.avasia.reeltalk.selectionscreen.selectionpages.movietvselection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avasia.reeltalk.R
import com.avasia.reeltalk.data.models.Movie

class MovieTVSelectionViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>?>(emptyList())
    val movies: LiveData<List<Movie>?>
        get() = _movies

    init {
        val movies = listOf(
            Movie(
                R.drawable.bohemian,
                "Bohemian Rhapsody"
            ),
            Movie(
                R.drawable.deadpool,
                "Deadpool"
            ),
            Movie(
                R.drawable.black_panther,
                "Black Panther"
            ),
            Movie(
                R.drawable.guardiansofthegalaxy,
                "Guardians Of The Galaxy Vol2"
            ),
            Movie(
                R.drawable.barbie,
                "Barbie"
            ),
            Movie(
                R.drawable.starwars,
                "Star Wars: Return Of The Jedi"
            )
        )
        _movies.value = movies
    }
}