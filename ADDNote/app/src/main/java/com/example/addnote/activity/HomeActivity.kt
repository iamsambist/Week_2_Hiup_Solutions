package com.example.addnote.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.addnote.model.Category
import com.example.addnote.model.CategoryHandler
import com.example.addnote.ui.theme.ADDNoteTheme
import com.example.addnote.view.ViewHomeScreen

class HomeActivity : ComponentActivity() {
    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        hideStatusBar()
        setContent {
            ADDNoteTheme {
                        var stateCategories: MutableList<Category> by remember { mutableStateOf(CategoryHandler.catgories.toMutableList()) }
                        ViewHomeScreen(
                            categories = stateCategories,
                            leftBtnAction = {
                                addCategoryAction(stateCategories)
                                stateCategories = CategoryHandler.catgories.toMutableList()
                            },
                            removeCategoryAction = { category ->
                                CategoryHandler.removeCategory(category)
                                stateCategories = CategoryHandler.catgories.toMutableList()
                            },
                            updateCategoryAction = { category -> updateCategory(category) })
            }
        }
    }
    private fun updateCategory(category: Category) {
        val intent = Intent(this, AddCategory::class.java)
        intent.putExtra("action_type", "update")
        intent.putExtra("user_id",category.id)
        startActivity(intent)
    }


    private fun addCategoryAction(stateCategories : MutableList<Category>) {
        val intent = Intent(this,AddCategory::class.java)
        intent.putExtra("action_type","add")
        startActivity(intent)
    }

    private fun hideStatusBar() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars())
    }

    override fun onResume() {
        super.onResume()
        enableEdgeToEdge()
        hideStatusBar()
        setContent {
            ADDNoteTheme {
                var stateCategories: MutableList<Category> by remember { mutableStateOf(CategoryHandler.catgories.toMutableList()) }
                stateCategories = CategoryHandler.catgories.toMutableList()
                ViewHomeScreen(
                    categories = stateCategories,
                    leftBtnAction = {
                        addCategoryAction(stateCategories)
                    },
                    removeCategoryAction = { category ->
                        CategoryHandler.removeCategory(category)
                        stateCategories = CategoryHandler.catgories.toMutableList()
                    },
                    updateCategoryAction = { category -> updateCategory(category) })
            }
        }
    }

}