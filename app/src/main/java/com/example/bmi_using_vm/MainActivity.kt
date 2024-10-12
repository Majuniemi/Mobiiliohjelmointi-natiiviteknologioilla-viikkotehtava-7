package com.example.bmi_using_vm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi_using_vm.ui.theme.BMI_using_VMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMI_using_VMTheme {
                Surface(
                    modifier = Modifier.fillMaxSize().padding(16.dp).padding(top = 16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BMIApp()
                }
            }
        }
    }
}

@Composable
fun BMIApp(bmiViewModel: BmiViewModel = viewModel()) {
    Column() {
        Text(
            text = stringResource(R.string.body_mass_index),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = bmiViewModel.heightInput,
            onValueChange = {bmiViewModel.changeHeightInput(it.replace(',','.'))},
            label = { Text(stringResource(R.string.height)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = bmiViewModel.weightInput,
            onValueChange = {bmiViewModel.changeWeightInput(it.replace(',','.'))},
            label = { Text(stringResource(R.string.weight)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        Text(text = stringResource(R.string.result, String.format("%.2f", bmiViewModel.changeBmi()).replace(',','.')))

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BMI_using_VMTheme {
        BMIApp()
    }
}