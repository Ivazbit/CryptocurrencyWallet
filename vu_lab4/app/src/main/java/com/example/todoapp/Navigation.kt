package com.example.todoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.HomeScreen
import com.example.todoapp.ui.HomeViewModel
import com.example.todoapp.ui.detail.DetailScreen

@Composable
fun TodoNavHost (){
    val navController = rememberNavController()
    val homeViewModel = HomeViewModel()

    NavHost(navController = navController, startDestination = NavRoute.Home.route){
        composable(NavRoute.Home.route){
            HomeScreen {
                navController.navigate(NavRoute.Detail.route + "/${it?.id?: -1}"){
                }
            }
        }
        composable(
            NavRoute.Detail.route + "/{id}",
            arguments = listOf(navArgument("id"){type = NavType.LongType})
        ){
            DetailScreen(selectedId = it.arguments?.getLong("id") ?: -1) {
                navController.navigateUp()
            }
        }
    }
}