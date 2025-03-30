package com.example.bmiextended.ui.bmi

import BmiViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.bmiextended.databinding.FragmentBmiBinding


class BmiFragment : Fragment() {
    private var _binding: FragmentBmiBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BmiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBmiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.bmi.observe(viewLifecycleOwner, Observer { bmiText ->
            binding.bmiResult.text = bmiText
            binding.bmiResult.visibility = View.VISIBLE
        })

        viewModel.bmiMessage.observe(viewLifecycleOwner, Observer { message ->
            binding.bmiMessage.text = message
            binding.bmiMessage.visibility = View.VISIBLE
        })

        binding.calculateButton.setOnClickListener {
            val weight = binding.weightInput.text.toString()
            val height = binding.heightInput.text.toString()
            viewModel.calculateBMI(weight, height)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
