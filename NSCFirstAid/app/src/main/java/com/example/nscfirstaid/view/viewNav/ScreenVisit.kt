package com.example.nscfirstaid.view.viewNav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nscfirstaid.ui.theme.NSCFirstAidTheme

@Composable
fun ScreenVisit(){
    Column(modifier = Modifier.padding(top = 50.dp).fillMaxSize()) {
        Text(text = "Visit")
    }
}
@Composable
@Preview(showBackground = true)
fun ScreenVisitPreview() {
    NSCFirstAidTheme {
        ScreenVisit()
    }
}