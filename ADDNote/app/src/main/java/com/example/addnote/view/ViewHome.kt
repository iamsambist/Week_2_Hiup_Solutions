package com.example.addnote.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.addnote.model.Category
import com.example.addnote.model.CategoryHandler
import com.example.addnote.ui.theme.ADDNoteTheme

@Composable
fun ViewHomeScreen(
    categories: MutableList<Category>,
    leftBtnAction: ( () -> Unit),
    removeCategoryAction: ((category : Category)->Unit),
    updateCategoryAction : ((category : Category)->Unit)){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(0.dp)
            .fillMaxSize()
    ) {
        HeaderHome(leftBtnAction = leftBtnAction)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ){
                Categories(categories = categories,
                    removeCategoryAction = {category ->removeCategoryAction(category)},
                    updateCategoryAction = {category -> updateCategoryAction(category)})
            }
        }
    }
}
@Composable
fun Categories(categories: List<Category>,
               removeCategoryAction: (category : Category) -> Unit,
               updateCategoryAction : ((category : Category)->Unit)) {
LazyColumn(modifier = Modifier
    .fillMaxSize()
    .padding(top = 5.dp)) {
    items(categories) {category ->
        Category(category,btnRemoveCategory= {category->removeCategoryAction(category)},
            upDateCategory = {category->updateCategoryAction(category)})
        Spacer(modifier = Modifier.height(15.dp))
    }

}
}
@Composable
fun Category(category: Category,
             btnRemoveCategory : ((category : Category)->Unit),
             upDateCategory : ((category : Category)->Unit)) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp).pointerInput(Unit){
            detectTapGestures(
                onLongPress = {upDateCategory(category)}
            )
        }) {
            Text(text = category.name, style = MaterialTheme.typography.titleMedium, fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier.clickable { btnRemoveCategory(category) },
                imageVector = Icons.Filled.Delete, contentDescription = "Delete")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ViewHomeScreenPreview(){
    ADDNoteTheme {
        ViewHomeScreen(
            categories = CategoryHandler.catgories,
            leftBtnAction = {},
            removeCategoryAction = {},
            updateCategoryAction = {})
    }
}