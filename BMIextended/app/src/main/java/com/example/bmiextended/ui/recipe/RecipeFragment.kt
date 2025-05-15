package com.example.bmiextended.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bmiextended.R
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

        recipeViewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            recipeAdapter = RecipeAdapter(recipes) { selectedRecipe ->
                findNavController().navigate(R.id.shoppingListFragment)
            }
            binding.recipeRecyclerView.adapter = recipeAdapter
        }

        val savedKcal = kcalViewModel.getTotalKcalFromSavedState()
        if (savedKcal > 0) {
            binding.kcalResultInfo.text = "Recommended for kcal: %.2f".format(savedKcal)
            recipeViewModel.setKcalRequirement(savedKcal)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
