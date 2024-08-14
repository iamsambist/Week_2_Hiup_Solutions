package com.example.nscfirstaid.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.nscfirstaid.ui.theme.NSCFirstAidTheme
import com.example.nscfirstaid.view.header.HeaderScreen
import com.example.nscfirstaid.view.viewNav.NavigationBarScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MainScreenView(){

    val systemUiController = rememberSystemUiController()
    val headerColor = Color.Blue
    systemUiController.setStatusBarColor(
        color = headerColor,
        darkIcons = false
    )
    Column {
        HeaderScreen()
        Column(modifier = Modifier.padding(20.dp)) {
            NavigationBarScreen()
        }

    }
}
@Preview(showBackground = true)
@Composable
fun MainScreenViewPreview(){
    NSCFirstAidTheme {
        MainScreenView()
    }
}