package com.example.nscfirstaid.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.nscfirstaid.ui.theme.NSCFirstAidTheme
import com.example.nscfirstaid.view.MainScreenView
import com.example.nscfirstaid.view.viewNav.NavigationBarScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NSCFirstAidTheme {
                MainScreenView()
            }
        }
    }
}

