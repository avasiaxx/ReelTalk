package com.avasia.reeltalk.profile

import androidx.lifecycle.ViewModel

/**
 * ViewModel for managing user profile information, including the display name.
 *
 * The `ProfileViewModel` class is responsible for managing user-related data and providing
 * functionality to update the user's display name. It is designed to be used within the context
 * of an Android ViewModel to maintain a separation of concerns between data and UI components.
 */
class ProfileViewModel: ViewModel() {

    var userDisplayName: String = ""

    // Update the display name using this function
    fun setDisplayName(displayNameInput: String) {
        userDisplayName = displayNameInput
    }
}