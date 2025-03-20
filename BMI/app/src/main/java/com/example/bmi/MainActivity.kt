package com.example.bmi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.calculateButton.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val weightInput = binding.weightInput.text.toString()
        val heightInput = binding.heightInput.text.toString()

        if (weightInput.isEmpty() || heightInput.isEmpty()) {
            Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show()
            return
        }

        val weight = weightInput.toFloatOrNull()
        val height = heightInput.toFloatOrNull()

        if (weight == null || height == null || weight <= 0 || height <= 0) {
            Toast.makeText(this, "Invalid input. Please enter value above 0.", Toast.LENGTH_SHORT).show()
            return
        }

        val heightInMeters = height / 100
        val bmi = weight / (heightInMeters * heightInMeters)

        binding.bmiResult.text = "Your BMI: %.2f".format(bmi)
        binding.bmiMessage.text = "You are %s".format(bmiMessage(bmi))
        binding.bmiResult.visibility = View.VISIBLE
    }

    private fun bmiMessage(bmi: Float): String {
        if (bmi < 18.5)
            return "underweight"
        if(bmi < 25.0)
            return "normal"
        if (bmi < 30.0)
            return "overweight"
        if (bmi < 35.0)
            return "obese"

        return "extremely obese"
    }

}