package com.example.bmiextended

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.startsWith

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.bmiextended.ui.bmi.BmiFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BmiFragmentTest {

 @Test
 fun calculateBMI_showsResultCorrectly(): Unit {
  launchFragmentInContainer<BmiFragment>(
   themeResId = R.style.Theme_BMIextended
  )

  onView(withId(R.id.weightInput)).perform(typeText("70"), closeSoftKeyboard())
  onView(withId(R.id.heightInput)).perform(typeText("175"), closeSoftKeyboard())
  onView(withId(R.id.calculateButton)).perform(click())

  Thread.sleep(500)

  onView(withId(R.id.bmiResult))
   .check(matches(isDisplayed()))
   .check(matches(withText(startsWith("Your BMI:"))))

  onView(withId(R.id.bmiMessage))
   .check(matches(isDisplayed()))
   .check(matches(withText("Normal weight")))
 }
}
