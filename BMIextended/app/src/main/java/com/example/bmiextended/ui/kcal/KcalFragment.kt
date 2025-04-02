package com.example.bmiextended.ui.kcal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bmiextended.databinding.FragmentKcalBinding

class KcalFragment : Fragment() {

    private var _binding: FragmentKcalBinding? = null
    private val binding get() = _binding!!

    private val viewModel: KcalViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentKcalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            viewModel.kcalResult.observe(viewLifecycleOwner, { kcal ->
                binding.kcalResult.text = kcal
                binding.kcalResult.visibility = View.VISIBLE
            })

            binding.seekBarActivity.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    val activityText = when (progress) {
                        in 0..200 -> "Sitting lifestyle"
                        in 201..400 -> "Light activity"
                        in 401..600 -> "Moderate activity"
                        in 601..800 -> "High activity"
                        else -> "Very high activity"
                    }
                    binding.activityTypeView.text = activityText
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

            binding.calculateButton.setOnClickListener{
                val age = binding.ageInput.text.toString()
                val weight = binding.weightInput.text.toString()
                val height = binding.heightInput.text.toString()
                val activityLevel = when (binding.seekBarActivity.progress) {
                    in 0..200 -> 1.2f
                    in 201..400 -> 1.375f
                    in 401..600 -> 1.55f
                    in 601..800 -> 1.725f
                    else -> 1.9f
                }
                viewModel.calculateKcal(age, weight, height, activityLevel)
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}