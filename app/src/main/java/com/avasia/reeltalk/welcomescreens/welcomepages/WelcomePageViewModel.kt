package com.avasia.reeltalk.welcomescreens.welcomepages

import androidx.lifecycle.ViewModel
import com.avasia.reeltalk.R

/**
 * ViewModel for managing data related to the welcome screen pages.
 *
 * This ViewModel provides methods to retrieve details for each page of a welcome screen.
 */

class WelcomePageViewModel: ViewModel() {
    /**
     * Retrieves a list of pairs, each containing resource identifiers for an illustration (image)
     * and a string resource for a welcome message text specific to different pages of a welcome screen.
     *
     * This function is used to fetch details for multiple pages of a welcome screen, where each page
     * is represented as a pair containing the drawable resource for an illustration and the string
     * resource for the welcome message text.
     *
     * @return A list of pairs, where each pair represents details for a specific welcome screen page.
     */
    fun getPageDetails(): List<Pair<Int, Int>> {
        return listOf(
            Pair(
                R.drawable.illustration1,
                R.string.welcome_to_reel_talk
            ),
            Pair(R.drawable.illustration2,
                R.string.discover_and_discuss
            ),
            Pair(R.drawable.illustration3,
                R.string.let_s_get_started
            )
        )
    }
}