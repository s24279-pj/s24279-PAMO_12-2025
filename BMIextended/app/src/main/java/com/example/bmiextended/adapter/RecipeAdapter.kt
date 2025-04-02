package com.example.bmiextended.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bmiextended.R
import com.example.bmiextended.model.Recipe

class RecipeAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeName: TextView = itemView.findViewById(R.id.recipeName)
        val recipeDescription: TextView = itemView.findViewById(R.id.recipeDescription)
        val recipeCalories: TextView = itemView.findViewById(R.id.recipeCalories)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.recipeName.text = recipe.name
        holder.recipeDescription.text = recipe.description
        holder.recipeCalories.text = "${recipe.calories} kcal"
    }

    override fun getItemCount(): Int = recipes.size
}
