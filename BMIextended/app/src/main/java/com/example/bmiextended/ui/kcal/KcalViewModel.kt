package com.example.bmiextended.ui.kcal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class KcalViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _kcalResult = MutableLiveData<String>()
    val kcalResult: LiveData<String> = _kcalResult

    private val _totalKcal = MutableLiveData<Float>(0f)
    val totalKcal: LiveData<Float> = _totalKcal

    companion object {
        private var savedKcal: Float = 0f

        fun getSavedKcal(): Float = savedKcal

        fun setSavedKcal(value: Float) {
            savedKcal = value
        }
    }

    fun calculateKcal(ageInput: String, weightInput: String, heightInput: String, activityLevel: Float) {
        if (weightInput.isEmpty() || heightInput.isEmpty() || ageInput.isEmpty()) {
            _kcalResult.value = "Please enter all age, weight and height"
            return
        }

        val age = ageInput.toFloatOrNull()
        val weight = weightInput.toFloatOrNull()
        val height = heightInput.toFloatOrNull()

        if (weight == null || height == null || age == null || age <= 0 || weight <= 0 || height <= 0) {
            _kcalResult.value = "Invalid input. Enter values above 0."
            return
        }

        val harrisBenedictPattern = 10 * weight + 6.25 * height - 5 * age + 5
        val totalKcalValue = (harrisBenedictPattern * activityLevel).toFloat()

        _totalKcal.value = totalKcalValue
        setSavedKcal(totalKcalValue)
        savedStateHandle["total_kcal"] = totalKcalValue
        _kcalResult.value = "Total kcal requirement: %.2f kcal".format(totalKcalValue)
    }

    fun getTotalKcalFromSavedState(): Float {
        return savedStateHandle["total_kcal"] ?: getSavedKcal()
    }
}
