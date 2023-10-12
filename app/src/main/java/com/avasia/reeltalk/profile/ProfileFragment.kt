package com.avasia.reeltalk.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.avasia.reeltalk.databinding.FragmentProfileBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.CompositeDateValidator
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class ProfileFragment : Fragment() {

    private lateinit var pickMedia: ActivityResultLauncher<PickVisualMediaRequest?>

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private var selectedDate: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        pickMedia = registerForActivityResult(
            ActivityResultContracts.PickVisualMedia()
        ) { uri ->
            binding.profileImage.setImageURI(uri)
            binding.initial.text = ""
            if (uri != null) {
                Log.d("PhotoPicker", "Selected URI: $uri")
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileImage.setOnClickListener {
            selectPhoto()
        }

        val constraintsBuilder =
            CalendarConstraints.Builder()
                .setStart(get100YearsBefore())
                .setEnd(getDate())
                .setValidator(
                    CompositeDateValidator.allOf(
                        listOf(
                            DateValidatorPointForward.from(get100YearsBefore()),
                            DateValidatorPointBackward.before(getDate())
                        )
                    )
                )

        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Birthday")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .setCalendarConstraints(constraintsBuilder.build())
                .build()


        datePicker.addOnPositiveButtonClickListener {
            selectedDate = datePicker.selection!!


            val timeZoneUTC = TimeZone.getDefault()
            val offsetFromUTC = timeZoneUTC.getOffset(Date().time) * -1

            val simpleFormat = SimpleDateFormat("MM/yy", Locale.CANADA)
            val date = Date(selectedDate + offsetFromUTC)

            binding.birthdayInput.setText(simpleFormat.format(date))
        }

        binding.birthdayInput.onFocusChangeListener = View.OnFocusChangeListener { _, _ ->
            datePicker.show(childFragmentManager, "DatePicker")
        }
        binding.birthdayInput.isClickable = true
        binding.birthdayInput.setOnClickListener {
            datePicker.show(childFragmentManager, "DatePicker")
        }

        datePicker.addOnPositiveButtonClickListener {
            selectedDate = datePicker.selection!!

            val timeZoneUTC = TimeZone.getDefault()
            val offsetFromUTC = timeZoneUTC.getOffset(Date().time) * -1

            val simpleFormat = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
            val date = Date(selectedDate + offsetFromUTC)

            binding.birthdayInput.setText(simpleFormat.format(date))
        }
    }

    private fun selectPhoto() {
        pickMedia.launch(
            PickVisualMediaRequest(
                ActivityResultContracts.PickVisualMedia.ImageOnly
            )
        )
    }

    private fun get100YearsBefore(): Long {
        val hundredYearsAgo = Instant.now()
            .toEpochMilli() - 100L * 365L * 24L * 60L * 60L * 1000L // 100 years ago
        val calendar = Calendar.getInstance(TimeZone.getDefault())
        calendar.timeInMillis = hundredYearsAgo
        return calendar.timeInMillis
    }

    private fun getDate(): Long {
        val today = Instant.now().toEpochMilli()
        val calendar = Calendar.getInstance(TimeZone.getDefault())
        calendar.timeInMillis = today
        return calendar.timeInMillis
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}