package com.example.nscfirstaid.view.viewNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PlayCircleOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem (
    val title : String,
    val seletedIcon : ImageVector,
    val unseletedIcon  : ImageVector,
    val route : String
){
    companion object{
        val items = listOf(
            BottomNavigationItem(
                title = "Home",
                seletedIcon = Icons.Filled.Home,
                unseletedIcon = Icons.Outlined.Home,
                route = "Home"
            ),
            BottomNavigationItem(
                title = "Help",
                seletedIcon = Icons.Filled.Help,
                unseletedIcon = Icons.Outlined.HelpOutline,
                route = "Help"
            ),
            BottomNavigationItem(
                title = "About",
                seletedIcon = Icons.Filled.AddBox,
                unseletedIcon = Icons.Outlined.AddBox,
                route = "About"
            ),
            BottomNavigationItem(
                title = "Video",
                seletedIcon = Icons.Filled.PlayCircle,
                unseletedIcon = Icons.Outlined.PlayCircleOutline,
                route = "Video"
            ),
            BottomNavigationItem(
                title = "Visit",
                seletedIcon = Icons.Filled.Category,
                unseletedIcon = Icons.Outlined.Category,
                route = "Visit"
            )
        )
    }

}