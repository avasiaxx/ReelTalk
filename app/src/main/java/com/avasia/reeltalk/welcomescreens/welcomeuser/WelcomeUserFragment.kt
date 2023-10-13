package com.avasia.reeltalk.welcomescreens.welcomeuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.avasia.reeltalk.R

/**
 * Fragment to welcome the user.
 *
 * This Fragment is designed to provide a warm welcome to the user when they first enter
 * a particular section of the app or when they are new to the app. It typically displays
 * a user-friendly welcome message or introductory content.
 */
class WelcomeUserFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome_user, container, false)
    }
}