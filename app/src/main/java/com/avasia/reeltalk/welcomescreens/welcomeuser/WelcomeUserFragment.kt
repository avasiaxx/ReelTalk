package com.avasia.reeltalk.welcomescreens.welcomeuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.avasia.reeltalk.R
import com.avasia.reeltalk.databinding.FragmentWelcomeUserBinding
import com.avasia.reeltalk.profile.ProfileViewModel

/**
 * Fragment to welcome the user.
 *
 * This Fragment is designed to provide a warm welcome to the user when they first enter
 * a particular section of the app or when they are new to the app. It typically displays
 * a user-friendly welcome message with their entered username or introductory content.
 */
class WelcomeUserFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by activityViewModels()

    private var _binding: FragmentWelcomeUserBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val welcomeMsg = binding.title.text
        val displayName = profileViewModel.userDisplayName
        val stringBuilder = StringBuilder()
            .append(
            welcomeMsg,
            ", $displayName!"
        )
        binding.title.text = stringBuilder.toString()
        binding.continueBtn.setOnClickListener {
            findNavController().navigate(R.id.selectionScreenFragment)
        }
    }
}