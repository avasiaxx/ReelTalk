package com.avasia.reeltalk.welcomescreens

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
 * Fragment for the initial welcome screen with a brief delay before transitioning to the splash screen.
 *
 * The `InitialWelcomeFragment` is the first screen users encounter when they launch the app. It serves
 * as a brief welcome or branding screen and includes a short delay before automatically navigating to
 * the splash screen. This delay provides a smooth introduction to the app and allows time for any
 * necessary initialization.
 *
 * Usage:
 * - Include this fragment as the initial screen of your app's navigation flow.
 * - Customize the appearance and content of this welcome screen to create a welcoming first impression
 *   for users.
 * - Adjust the `SPLASH_DELAY` constant to control the duration of the delay before transitioning to the
 *   splash screen.
 *
 * Example:
 * ```
 * val initialWelcomeFragment = InitialWelcomeFragment()
 * supportFragmentManager.beginTransaction()
 *     .replace(R.id.fragment_container, initialWelcomeFragment)
 *     .commit()
 * ```
 *
 * Note:
 * - While this fragment provides a seamless entry into the app, ensure that the delay is kept minimal to
 *   prevent user impatience.
 * - For custom branding and introduction, consider customizing the layout and content in the associated
 *   XML layout file.
 */
class InitialWelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.splashFragment)
        }, SPLASH_DELAY)
    }

    companion object {
        private const val SPLASH_DELAY = 3000L // 3 seconds
    }
}