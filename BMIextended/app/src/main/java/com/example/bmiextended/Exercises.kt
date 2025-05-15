package com.example.bmiextended

import kotlin.math.PI
import kotlin.random.Random

class Exercises {

    /**
     *Exercise 1
     *Complete the code to make the program print "Mary is 20 years old" to standard output.
     * */
    fun printVariables() {
        val name = "Mary"
        val age = 20
        println("$name is $age years old")
    }

    /**
     *Exercise 2
     *Explicitly declare the correct type for each variable
     * */
    fun declareCorrectType() {
        val a: Int = 1000
        val b: String = "log message"
        val c: Double = 3.14
        val d: Long = 100_000_000_000_000
        val e: Boolean = false
        val f: Char = '\n'
    }
    /**
     *Exercise 3
     *Print how many numbers there are in total
     * */
    fun collectionsExercise1() {
        val greenNumbers = listOf(1, 4, 23)
        val redNumbers = listOf(17, 2)
        val totalCount = greenNumbers.count() + redNumbers.count()
        println(totalCount)
    }

    /**
     *Exercise 4
     *You have a set of protocols supported by your server. A user requests to use a particular protocol. Complete the program to check whether the requested protocol
     * is supported or not (isSupported must be a Boolean value).
     * */
    fun collectionsExercise2() {
        val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
        val requested = "smtp"
        val isSupported = requested.uppercase() in SUPPORTED
        println("Support for $requested: $isSupported")
    }

    /**
     *Exercise 5
     *Define a map that relates integer numbers from 1 to 3 to their corresponding spelling. Use this map to spell the given number.
     * */
    fun collectionsExercise3() {
        val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
        val n = 2
        println("$n is spelt as '${number2word[n]}'")
    }

    /**
     *Exercise 6
     *Create a simple game where you win if throwing two dice results in the same number. Use if to print You win :) if the dice match or You lose :( otherwise.
     * */
    fun conditionalExpressionsExercise1() {
        val firstResult = Random.nextInt(6)
        val secondResult = Random.nextInt(6)
        if (firstResult == secondResult)
            println("You win :)")
        else
            println("You lose :(")
    }

    /**
     *Exercise 7
     *Using a when expression, update the following program so that it prints the corresponding actions when you input the names of game console buttons.
     * */
    fun conditionalExpressionsExercise2() {
        val button = "A"
        println(
            when (button) {
                "A" -> "Yes"
                "B" -> "No"
                "X" -> "Menu"
                "Y" -> "Nothing"
                else -> "There is no such button"
            }
        )
    }

    /**
     *Exercise 8
     *You have a program that counts pizza slices until there’s a whole pizza with 8 slices.
     * */
    fun loopExercise() {
        var pizzaSlices = 0
        while ( pizzaSlices < 7 ) {
            pizzaSlices++
            println("There's only $pizzaSlices slice/s of pizza :(")
        }
        pizzaSlices++
        println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
    }

    /**
     *Exercise 9
     *Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100 incrementally, replacing any number divisible by three with the word
     * "fizz", and any number divisible by five with the word "buzz". Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".
     * */
    fun forLoopExercise1() {
        for (number in 1..100) {
            println(
                when {
                    number % 15 == 0 -> "fizzbuzz"
                    number % 3 == 0 -> "fizz"
                    number % 5 == 0 -> "buzz"
                    else -> "$number"
                }
            )
        }
    }

    /**
     *Exercise 9
     *You have a list of words. Use for and if to print only the words that start with the letter l.
     * */
    fun forLoopExercise2() {
        val words = listOf("dinosaur", "limousine", "magazine", "language")
        for (w in words) {
            if (w.startsWith("l"))
                println(w)
        }
    }

    /**
     *Exercise 10
     *Write a function called circleArea that takes the radius of a circle in integer format as a parameter and outputs the area of that circle
     * */
    fun circleArea1(radius: Int): Double {
        return PI * radius * radius
    }
    fun functionExercise1() {
        println(circleArea1(2)) // 12.566370614359172
    }

    /**
     *Exercise 11
     *Rewrite the circleArea function from the previous exercise as a single-expression function.
     * */

    fun circleArea2(radius: Int): Double = PI * radius * radius

    fun functionExercise2() {
        println(circleArea2(2))
    }

    /**
     *Exercise 12
     *You have a function that translates a time interval given in hours, minutes, and seconds into seconds. In most cases, you need to pass only one or two function
     * parameters while the rest are equal to 0. Improve the function and the code that calls it by using default parameter values and named arguments so that the code is
     * easier to read.
     * */
    fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) =
        ((hours * 60) + minutes) * 60 + seconds

    fun functionExercise3() {
        println(intervalInSeconds(1, 20, 15))
        println(intervalInSeconds(minutes = 1, seconds = 25))
        println(intervalInSeconds(hours = 2))
        println(intervalInSeconds(minutes = 10))
        println(intervalInSeconds(hours = 1, seconds = 1))
    }
}