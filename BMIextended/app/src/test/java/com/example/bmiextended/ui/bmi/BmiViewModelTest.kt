import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class BmiViewModelTest {

 @get:Rule
 val rule = InstantTaskExecutorRule()

 private val viewModel = BmiViewModel()

 @Test
 fun `returns error when inputs are empty`() {
  viewModel.calculateBMI("", "")
  assertEquals("Please enter both weight and height", viewModel.bmi.value)
  assertEquals("", viewModel.bmiMessage.value)
 }

 @Test
 fun `returns error for invalid inputs`() {
  viewModel.calculateBMI("-70", "abc")
  assertEquals("Invalid input. Enter values above 0.", viewModel.bmi.value)
  assertEquals("", viewModel.bmiMessage.value)
 }

 @Test
 fun `calculates correct BMI and message for normal weight`() {
  viewModel.calculateBMI("70", "175") // BMI ≈ 22.86
  assertEquals("Your BMI: 22,86", viewModel.bmi.value)
  assertEquals("Normal weight", viewModel.bmiMessage.value)
 }

 @Test
 fun `returns correct message for underweight`() {
  viewModel.calculateBMI("45", "170") // BMI ≈ 15.57
  assertEquals("Underweight", viewModel.bmiMessage.value)
 }

 @Test
 fun `returns correct message for overweight`() {
  viewModel.calculateBMI("85", "170") // BMI ≈ 29.41
  assertEquals("Overweight", viewModel.bmiMessage.value)
 }

 @Test
 fun `returns correct message for obesity`() {
  viewModel.calculateBMI("95", "165") // BMI ≈ 34.90
  assertEquals("Obese", viewModel.bmiMessage.value)
 }

 @Test
 fun `returns correct message for extreme obesity`() {
  viewModel.calculateBMI("120", "160") // BMI ≈ 46.88
  assertEquals("Extremely obese", viewModel.bmiMessage.value)
 }
}
