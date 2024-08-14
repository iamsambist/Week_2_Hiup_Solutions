package com.example.addnote.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.addnote.ui.theme.ADDNoteTheme

@Composable
fun HeaderHome(
    leftBtnAction: (()->Unit)) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {leftBtnAction() }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Back",
                    tint = Color.White)
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Home",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { leftBtnAction()  }) {
                Icon(
                    imageVector = Icons.Filled.ExitToApp,
                    contentDescription = "Back",
                    tint = Color.White)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HeaderHomePreview(){
    ADDNoteTheme {
        HeaderHome({})
    }
}