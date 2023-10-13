package com.avasia.reeltalk.pushnotificationprompt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.avasia.reeltalk.R
import com.avasia.reeltalk.databinding.FragmentPushNotificationsBinding

/**
 * Fragment for managing push notification settings.
 *
 * This Fragment allows users to configure their push notification preferences. It provides an option
 * to turn off push notifications and navigate to a welcome or user settings page.
 */
class PushNotificationFragment : Fragment() {

    private var _binding: FragmentPushNotificationsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_push_notifications, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPushNotificationsBinding.bind(view)
        binding.turnOff.setOnClickListener {
            findNavController().navigate(R.id.welcomeUserFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}