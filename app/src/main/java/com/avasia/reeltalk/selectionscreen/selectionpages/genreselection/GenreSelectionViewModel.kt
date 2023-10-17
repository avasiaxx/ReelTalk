package com.avasia.reeltalk.selectionscreen.selectionpages.genreselection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel for managing genre selection in an Android application.
 *
 * This ViewModel is responsible for managing the selection of genres. It keeps track of the
 * number of genres selected, enforces selection limits, and provides a list of available genre options.
 *
 * @property selected A LiveData representing the number of genres currently selected.
 * @property genreOptions An array of available genre options.
 */
class GenreSelectionViewModel : ViewModel() {

    private val _selected = MutableLiveData<Int>()

    val selected: LiveData<Int>
        get() = _selected

    val genreOptions = arrayOf(
        "Action",
        "Adventure",
        "Animation",
        "Biography",
        "Comedy",
        "Crime",
        "Documentary",
        "Drama",
        "Family",
        "Fantasy",
        "History",
        "Horror",
        "Mystery",
        "Reality",
        "Romance",
        "Sci-Fi",
        "Sport",
        "Thriller",
        "War",
        "Western"
    )

    /**
     * Initializes the ViewModel by setting the initial selected value to the minimum.
     */
    init {
        _selected.value = MIN_SELECTED
    }

    /**
     * Increases the selected count if it is below the maximum limit.
     */
    fun onIncrease() {
        if (_selected.value!! < MAX_SELECTED) {
            _selected.value = _selected.value!! + 1
        }
    }

    /**
     * Decreases the selected count if it is above the minimum limit.
     */
    fun onDecrease() {
        if (_selected.value!! > 0) {
            _selected.value = _selected.value!! - 1
        }
    }

    /**
     * Checks if the maximum selection limit has been reached.
     *
     * @return `true` if the maximum limit has been reached, `false` otherwise.
     */
    fun checkIfMaxSelected(): Boolean {
        return _selected.value!! == MAX_SELECTED
    }

    companion object {
        /**
         * The maximum number of genres that can be selected.
         */
        const val MAX_SELECTED = 3

        /**
         * The minimum number of genres that can be selected.
         */
        const val MIN_SELECTED = 0
    }
}