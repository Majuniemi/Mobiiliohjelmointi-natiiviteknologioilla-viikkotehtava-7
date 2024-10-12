package com.example.bmi_using_vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")
    private var bmi by mutableFloatStateOf(0f)

    private fun calculateBmi(): Float {
        val weight = weightInput.toFloatOrNull() ?: 0.0f
        val height = heightInput.toFloatOrNull() ?: 0.0f
        bmi = if (weight > 0 && height > 0) weight / (height * height) else 0.0f
        return bmi
    }

    fun changeBmi(): Float {
        bmi = calculateBmi()
        return bmi
    }

    fun changeHeightInput(value: String) {
        heightInput = value
    }

    fun changeWeightInput(value: String) {
        weightInput = value
    }

}