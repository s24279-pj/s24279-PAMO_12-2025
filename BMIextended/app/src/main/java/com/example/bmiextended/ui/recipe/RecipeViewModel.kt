package com.example.bmiextended.ui.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bmiextended.model.Recipe

class RecipeViewModel : ViewModel() {

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> = _recipes

    private val _kcalInfo = MutableLiveData<String>()
    val kcalInfo: LiveData<String> = _kcalInfo

    fun setKcalRequirement(kcal: Float) {
        _kcalInfo.value = "Daily kcal requirement: ${kcal.toInt()} kcal"
        _recipes.value = getRecipesByKcal(kcal)
    }

    private fun getRecipesByKcal(kcal: Float): List<Recipe> {
        return Recipe.getRecipes().filter { recipe ->
            when {
                kcal < 2000 -> recipe.category == "light"
                kcal < 2800 -> recipe.category == "medium"
                else -> recipe.category == "high"
            }
        }
    }
}