package com.example.bmiextended.model;

import java.util.Arrays;
import java.util.List;

public class Recipe {
    private final String name;
    private final String description;
    private final int calories;

    private final String category;

    public Recipe(String name, String description, int calories, String category) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public String getCategory() {
        return category;
    }

    public static List<Recipe> getRecipes() {
        return Arrays.asList(
                new Recipe("Greek Salad", "Fresh salad with feta cheese, olives, and vegetables.", 350, "light"),
                new Recipe("Grilled Chicken with Veggies", "Grilled chicken breast with steamed broccoli and carrots.", 450, "light"),

                new Recipe("Pasta Bolognese", "Pasta with rich meat sauce, topped with parmesan.", 700, "medium"),
                new Recipe("Salmon with Rice", "Grilled salmon fillet with wild rice and spinach.", 750, "medium"),

                new Recipe("Steak with Mashed Potatoes", "Juicy beef steak with creamy mashed potatoes and gravy.", 900, "high"),
                new Recipe("Peanut Butter Oatmeal", "Oatmeal with peanut butter, banana, and honey.", 850, "high")
        );
    }
}
