package com.example.addnote.view

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
@Composable
fun AlertDialogScreen(message : String,dismissDailog : (()->Unit)){

        AlertDialog(
            onDismissRequest = { dismissDailog() },
            title = { Text("Login Error") },
            text = { Text(message) },
            confirmButton = {
                TextButton(onClick = { dismissDailog() }) {
                    Text("OK")
                }
            }
        )
    }