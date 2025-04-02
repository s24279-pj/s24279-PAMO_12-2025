package com.example.bmiextended.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bmiextended.adapter.RecipeAdapter
import com.example.bmiextended.databinding.FragmentRecipeBinding
import com.example.bmiextended.ui.kcal.KcalViewModel

class RecipeFragment : Fragment() {

    private var _binding: FragmentRecipeBinding? = null
    private val binding get() = _binding!!

    private val recipeViewModel: RecipeViewModel by viewModels()
    private val kcalViewModel: KcalViewModel by activityViewModels()

    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recipeRecyclerView.layoutManager = LinearLayoutManager(context)

        val savedKcal = kcalViewModel.getTotalKcalFromSavedState()

        if (savedKcal > 0) {
            binding.kcalResultInfo.text = "Total kcal: %.2f".format(savedKcal)
            recipeViewModel.setKcalRequirement(savedKcal)
        } else {
            binding.kcalResultInfo.text = "Calculate kcal first."
        }

        kcalViewModel.totalKcal.observe(viewLifecycleOwner) { totalKcal ->
            if (totalKcal > 0) {
                binding.kcalResultInfo.text = "Total kcal: %.2f".format(totalKcal)
                recipeViewModel.setKcalRequirement(totalKcal)
            } else {
                binding.kcalResultInfo.text = "Calculate kcal first."
            }
        }

        recipeViewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            binding.recipeRecyclerView.adapter = RecipeAdapter(recipes)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}