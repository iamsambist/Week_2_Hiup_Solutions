package com.example.statehostingdemo.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statehostingdemo.ui.theme.StateHostingDemoTheme

@Composable
fun ParentComposable(){
    var count : MutableState<Int> =  rememberSaveable { mutableStateOf(0)}
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        NotificationComposable(
            count = count.value,
            increment = {count.value++}
        )
        Spacer(modifier = Modifier.height(10.dp))
        MessageComposable(count=count.value)
    }
}
@Composable
fun NotificationComposable(count: Int, increment: () -> Unit) {
    Column (verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "You have sent ${count} Notification")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { increment() }) {
            Text(text = "Send Notification")
            
        }
        
    }
}
@Composable
fun MessageComposable(count: Int){
    Card(elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(5.dp, Color.Black)
    ){
        Row(modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically){
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "love",
                modifier = Modifier.padding(4.dp))
            Text(text = "Message Sent so far ${count}")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ParentComposablePreview(){
    StateHostingDemoTheme{
        ParentComposable()
    }
}

