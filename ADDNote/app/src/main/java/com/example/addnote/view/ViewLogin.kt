package com.example.addnote.view

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.addnote.R
import com.example.addnote.activity.HomeActivity
import com.example.addnote.model.User
import com.example.addnote.ui.theme.ADDNoteTheme

@Composable
fun LoginScreen(
    btnLoginAction : (user : User )->String,
    moveToNext : (()->Unit)){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isButtonEnabled = username.isNotEmpty() && password.isNotEmpty()
    var showDialog by remember { mutableStateOf(false)}
    var showAlertMessage by remember { mutableStateOf("")}

    if (showDialog) {
        AlertDialogScreen(
            message = showAlertMessage,dismissDailog = {showDialog = false}
        )
    }

    Column(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding()
    ) {
            HeaderLogin()
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text(stringResource(id = R.string.txt_username)) },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(stringResource(id = R.string.txt_password)) },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val user = User(id = 0, username = username, password = password)
                        Log.i("LoginScreen", "Login button pressed!")
                        var validationString =btnLoginAction( user)
                        if (validationString == "good"){
                          moveToNext()
                        }else{
                            showAlertMessage = validationString
                            showDialog = true
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isButtonEnabled
                ) {
                    Text(text = stringResource(id = R.string.txt_login))
                }
            }

            Spacer(modifier = Modifier.weight(1f))

    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    ADDNoteTheme {
        LoginScreen(btnLoginAction = {""},moveToNext={})
    }
}