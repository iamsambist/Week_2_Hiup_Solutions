package com.example.addnote.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.addnote.ui.theme.ADDNoteTheme

@Composable
fun CategoryScreen(
    actionType: String?, userId: Int,
    addCategoryBtnAction: (categoryName: String) -> Unit,
    updateCategory : ((name : String)->Unit)){
    when (actionType) {
        "add" -> {
            AddUserScreen(addCategoryBtnAction)
        }
        "update" -> {

            EditUserScreen(userId = userId,updateCategory)
        }
        else -> {
            Text("Invalid action type")
        }
    }
}
@Composable
fun AddUserScreen(
    addCategoryBtnAction : ((categoryName : String )->Unit))
{
    var categoryName by remember { mutableStateOf("")}
    val isfieldEmpty = categoryName.isNotEmpty()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .verticalScroll(rememberScrollState())
        .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,) {
        Text(text = "Input Category Name",
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = categoryName,
            onValueChange = {categoryName = it} )
        Spacer(modifier = Modifier.height(20.dp))
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = { addCategoryBtnAction(categoryName) },
            enabled = isfieldEmpty) {
            Text(text = "Add")
        }
    }
}
@Composable
fun EditUserScreen(userId: Int,
                   updateCategory : ((name : String)->Unit) ){
    var categoryName by remember { mutableStateOf("")}
    val isfieldEmpty = categoryName.isNotEmpty()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .verticalScroll(rememberScrollState())
        .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,) {
        Text(text = "Write New Name",
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = categoryName,
            onValueChange = {categoryName = it} )
        Spacer(modifier = Modifier.height(20.dp))
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {updateCategory(categoryName)  },
            enabled = isfieldEmpty) {
            Text(text = "Add")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenPreview(){
    ADDNoteTheme {
        CategoryScreen(actionType = "",
            userId = 0,
            addCategoryBtnAction = {},
            updateCategory = {})
    }
}