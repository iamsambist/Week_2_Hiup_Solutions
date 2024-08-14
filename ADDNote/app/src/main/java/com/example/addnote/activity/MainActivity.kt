package com.example.addnote.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.addnote.ui.theme.ADDNoteTheme
import com.example.addnote.view.AlertDialogScreen
import com.example.addnote.view.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        hideStatusBar()
        setContent {
            ADDNoteTheme {
//                LoginScreen { user ->
//                    val validationString: String = user.validate()
//                                 validationString
//
//                }
                LoginScreen (btnLoginAction = {user ->
                    user.validate()
                }, moveToNext = {btnChangeActivity()})
            }
        }
    }

    private fun btnChangeActivity() {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }

    private fun hideStatusBar() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars())
    }
}

