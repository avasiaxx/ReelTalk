package com.avasia.reeltalk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
/**
 * Main activity for the "Reel Talk" app.
 *
 * The `MainActivity` serves as the entry point and main container for the "Reel Talk" app. It is
 * responsible for initializing the app, setting the main content view, and navigating to the
 * initial destination, typically the "WelcomeFragment."
 *
 * Usage:
 * - This activity is the launch point for the app and should be declared as the main entry point
 *   in your AndroidManifest.xml file.
 * - The layout defined in the `setContentView` method should represent the core user interface of
 *   your app.
 * - The navigation logic in `onCreate` sets up the initial navigation destination, typically a
 *   fragment that welcomes users or provides the app's home screen.
 *
 * Example:
 * ```
 * val mainActivity = MainActivity()
 * mainActivity.setContentView(R.layout.activity_main)
 * mainActivity.initializeApp()
 * ```
 *
 * Note:
 * - Ensure that the app's navigation graph is correctly configured to handle the navigation between
 *   different fragments.
 * - The initial destination, in this case, is "WelcomeFragment," but it can be customized based on
 *   your app's navigation requirements.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.welcomeFragment)
    }
}