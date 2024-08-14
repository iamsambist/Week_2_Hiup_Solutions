package com.example.addnote.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.addnote.model.Category
import com.example.addnote.model.CategoryHandler
import com.example.addnote.ui.theme.ADDNoteTheme
import com.example.addnote.view.CategoryScreen

class AddCategory : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val actionType = intent.getStringExtra("action_type")
        val userid = intent.getIntExtra("user_id",0)
        setContent{
            ADDNoteTheme {
//                NewCategoryScreen(addCategoryBtnAction = {
//                    categoryname -> addNewCategory(categoryname)
//                })
                CategoryScreen(
                    actionType = actionType,
                    userId =userid,
                    addCategoryBtnAction = {
                        name -> addNewCategory(name)},
                    updateCategory = {name->upDateCategory(name,userid)})

            }
        }
    }

    private fun upDateCategory(name: String,userid : Int) {
        CategoryHandler.updateCategory(id =userid, newName = name)
        finish()
    }

    private fun addNewCategory(categoryname : String) {

            val id = CategoryHandler.size()
            val newCategory = Category(id + 1,categoryname)
            CategoryHandler.addCategory(newCategory)
            finish()


    }
}