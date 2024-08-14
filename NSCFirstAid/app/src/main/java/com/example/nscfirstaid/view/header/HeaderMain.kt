package com.example.nscfirstaid.view.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nscfirstaid.R
import com.example.nscfirstaid.ui.theme.NSCFirstAidTheme

@Composable
fun HeaderScreen(){
    var searchQuery by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    // Sample items for the dropdown menu
    val dropdownItems = listOf("Option 1", "Option 2", "Option 3")
    var selectedItem by remember { mutableStateOf(dropdownItems[0]) }
    Spacer(modifier = Modifier.padding(WindowInsets.statusBars.asPaddingValues()))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row (Modifier.padding(5.dp)){
// Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search...") },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .background(Color.White, shape = RoundedCornerShape(8.dp)),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search, // Same icon as above or a different one
                        contentDescription = "Search"
                    )
                }
            )

            // Dropdown Button with Image and Text

            Button(
                modifier = Modifier.fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(5),
                onClick = { expanded = true }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.mipmap.us_flag),
                        contentDescription = "Dropdown Image",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(text = "EN",
                        color = Color.Black)
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dropdown Arrow",
                        tint = Color.Black
                    )
                }
            }
        }


            //Dropdown Menu
    }
}
@Preview(showBackground = true)
@Composable
fun HeaderScreenPreview(){
    NSCFirstAidTheme {
        HeaderScreen()
    }
}