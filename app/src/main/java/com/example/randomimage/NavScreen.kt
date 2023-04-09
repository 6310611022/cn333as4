package com.example.randomimage

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.randomimage.ui.theme.SetValueScreen

@Composable
fun HomeNavScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Surface() {
        NavHost(
            navController = navController,
            startDestination = "home",
        ) {
            composable("home") {
                SetValueScreen(navController=  navController)
            }
            composable("Show Image/{width}/{height}/{category}",
                arguments = listOf(
                    navArgument("width"){type = NavType.StringType},
                    navArgument("height"){type = NavType.StringType},
                    navArgument("category"){type = NavType.StringType}
                    )) {backStackEntry ->
                val width = backStackEntry.arguments?.getString("width")
                val height = backStackEntry.arguments?.getString("height")
                val category = backStackEntry.arguments?.getString("category")
                if (width != null) {
                    if (height != null) {
                        if (category != null) {
                            ImageScreen(navController, width,height,category)
                        }
                    }
                }
            }
        }
    }
}