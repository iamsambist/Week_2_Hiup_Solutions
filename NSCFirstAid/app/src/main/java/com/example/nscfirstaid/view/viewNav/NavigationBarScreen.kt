package com.example.nscfirstaid.view.viewNav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nscfirstaid.ui.theme.NSCFirstAidTheme

@Composable
fun NavigationBarScreen(){
      val navController = rememberNavController()
//    val items = BottomNavigationItem.items
//    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold( bottomBar = { BottomNavigationBar(navController) }
//            bottomBar = {
//                NavigationBar {
//                    items.forEachIndexed { index, item ->
//                        NavigationBarItem(
//                            selected = selectedItemIndex == index,
//                            label = {
//                                Text(text = item.title)
//                            },
//                            onClick = {
//                                selectedItemIndex = index
//                                //navController.navigate(item.title)
//                            },
//                            icon = {
//                                Icon(
//                                    imageVector = if (index == selectedItemIndex) {
//                                        item.seletedIcon
//                                    } else item.unseletedIcon,
//                                    contentDescription = item.title
//                                )
//
//                            })
//                    }
//                }
//
//            }
        ){ innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home", // Set the initial route
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("Home") { ScreenHome() }
                composable("help") { ScreenHelp() }
                composable("about") { ScreenAbout() }
                composable("video") { ScreenVideo() }
                composable("visit") { ScreenVisit() }
            }
        }

    }
}
@Composable
fun BottomNavigationBar(navController: NavController){
    val items = BottomNavigationItem.items
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index && currentRoute==item.route,
                    label = {
                        Text(text = item.title)
                    },
                    onClick = {
                        selectedItemIndex = index
                        navController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                item.seletedIcon
                            } else item.unseletedIcon,
                            contentDescription = item.title
                        )

                    })
            }
        }
}
@Preview(showBackground = true)
@Composable
fun NavigationBarScreenPreview(){
    NSCFirstAidTheme {
        NavigationBarScreen()
    }
}