package com.example.tipcalculator.view

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme

@Composable
fun TipView(){
    var amount by remember { mutableStateOf("")}
    var tippercentage by remember { mutableStateOf("")}
    val amountInNumber: Double = amount.toDoubleOrNull() ?: 0.0
    val tippercentageInNumber : Double = tippercentage.toDoubleOrNull() ?: 1.0
    var roundUp by remember { mutableStateOf(false)}
    val tip = calculateTip(amountInNumber,tippercentageInNumber,roundUp)


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 16.dp)
        .offset(y = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = "Calculate Tip ",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value =amount , onValueChange = {amount = it},
            label = { Text(text = "Cost of Service")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        OutlinedTextField(
            value =tippercentage , onValueChange = {tippercentage = it},
            label = { Text(text = "tip(%)")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        RoundTheTipRow(round =roundUp, isChecked = { roundUp = !roundUp } )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Total Tip amount is \$${tip}")

    }
}
@Composable
fun RoundTheTipRow(round : Boolean,isChecked : ()-> Unit ){

    Row(
        modifier = Modifier
            .padding(top = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Round The Tip",
            modifier = Modifier.padding(start=50.dp))
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            modifier = Modifier.padding(end = 50.dp),
            checked = round,
            onCheckedChange = {isChecked()})
    }
}
@Preview(showBackground = true)
@Composable
fun TipViewPreview(){
    TipCalculatorTheme{
        TipView()
    }
}
private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): Double {
    var tip = tipPercent / 100 * amount
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return tip
}