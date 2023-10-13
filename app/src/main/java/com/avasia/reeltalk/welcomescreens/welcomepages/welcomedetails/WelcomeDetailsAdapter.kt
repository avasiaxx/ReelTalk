package com.avasia.reeltalk.welcomescreens.welcomepages.welcomedetails

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.avasia.reeltalk.welcomescreens.welcomepages.WelcomePageFragment


/**
 * Adapter for managing fragments in a welcome screen or onboarding flow.
 *
 * The `WelcomeDetailsAdapter` is designed to work in conjunction with a ViewPager or ViewPager2 to
 * facilitate the presentation of a welcome screen or onboarding flow with multiple pages or screens.
 * Each page typically represents a different section of the onboarding process.
 *
 * @param fragment The parent Fragment that contains the ViewPager or ViewPager2.
 *
 * Usage:
 * - Create an instance of `WelcomeDetailsAdapter` and set it as the adapter for a ViewPager or
 *   ViewPager2 within a parent Fragment or Activity.
 * - Customize the number of pages or fragments by changing the value returned by `getItemCount`.
 * - Customize the content and appearance of each page by editing the `WelcomePageFragment`.
 *
 * Example:
 * ```
 * val adapter = WelcomeDetailsAdapter(this)
 * viewPager.adapter = adapter
 * ```
 *
 * @see WelcomePageFragment for individual page content customization.
 *
 */
class WelcomeDetailsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3 // Number of fragments
    }

    override fun createFragment(position: Int): Fragment {
        return WelcomePageFragment(position)
    }
}

