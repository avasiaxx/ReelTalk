package com.avasia.reeltalk.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.avasia.reeltalk.R
/**
 * Splash Screen for the "Reel Talk" app.
 *
 * This splash screen is the initial screen that users see when they launch the "Reel Talk" app.
 * It is designed to provide a visually appealing and branded introduction to the app. The splash
 * screen typically displays the app's logo and name, creating a memorable first impression for
 * users.
 */
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.welcomeDetailsFragment)
        }, SPLASH_DELAY)
    }

    companion object {
        private const val SPLASH_DELAY = 3000L // 3 seconds
    }
}