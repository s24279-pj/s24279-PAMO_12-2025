import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    private val _bmi = MutableLiveData<String>()
    val bmi: LiveData<String> = _bmi

    private val _bmiMessage = MutableLiveData<String>()
    val bmiMessage: LiveData<String> = _bmiMessage

    fun calculateBMI(weightInput: String, heightInput: String) {
        if (weightInput.isEmpty() || heightInput.isEmpty()) {
            _bmi.value = "Please enter both weight and height"
            _bmiMessage.value = ""
            return
        }

        val weight = weightInput.toFloatOrNull()
        val height = heightInput.toFloatOrNull()

        if (weight == null || height == null || weight <= 0 || height <= 0) {
            _bmi.value = "Invalid input. Enter values above 0."
            _bmiMessage.value = ""
            return
        }

        val heightInMeters = height / 100
        val bmiValue = weight / (heightInMeters * heightInMeters)

        _bmi.value = "Your BMI: %.2f".format(bmiValue)
        _bmiMessage.value = getBmiMessage(bmiValue)
    }

    private fun getBmiMessage(bmi: Float): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi < 25.0 -> "Normal weight"
            bmi < 30.0 -> "Overweight"
            bmi < 35.0 -> "Obese"
            else -> "Extremely obese"
        }
    }
}
