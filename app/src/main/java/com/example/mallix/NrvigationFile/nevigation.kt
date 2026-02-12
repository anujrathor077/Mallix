package com.example.mallix.NavigationFile

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mallix.Favorite.FavoritesScreen
import com.example.mallix.MainScreens.HomeScreenSingle1
import com.example.mallix.MainScreens.HomeScreenSingle2
import com.example.mallix.MainScreens.HomeScreenSingle3
import com.example.mallix.MyBag.MyBag_Screen
import com.example.mallix.MainScreens.Filter
import com.example.mallix.Screens.Forgot1
//import com.example.mallix.Screens.LoginScreen
import com.example.mallix.Myprofile.My_order
import com.example.mallix.Screens.LoginScreen

import com.example.mallix.Screens.RegistrationScreen
import com.example.mallix.MainScreens.Women_Top
import com.example.mallix.MainScreens.mainpage1_module.AllViewModel
import com.example.mallix.ProductCard.Product_Card
import com.example.mallix.Search.VisualSearchScreen
import com.example.mallix.Search.visualSearch.Cropitem
import com.example.mallix.Search.visualSearch.FindingResultsScreen
import com.example.mallix.Search.visualSearch.SearchByPhotoScreen
import com.example.mallix.category.Categories1
import com.example.mallix.category.Categories2
//import com.example.mallix.category.Categories3
import com.example.mallix.profile.Profile_1


@Composable
fun MyApp() {

    val navController = rememberNavController()
    val viewModel: AllViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "registration"
    ) {
  composable(route = "login") {
            LoginScreen(navController)
        }


        // main Screen

        composable(route = "main_page1") {
            HomeScreenSingle1(navController,viewModel)
        }

        composable(route = "main_page2") {
            HomeScreenSingle2(navController)
        }
        composable(route = "main_page3") {
            HomeScreenSingle3(navController)
        }

        // category

        composable(route = "category_first") {
            Categories1(navController)
        }

        composable(route = "category_second") {
            Categories2(navController)
        }
      /*  composable(route = "category_third") {
            Categories3(navController)
        }*/


        //Screens



        composable(route = "forgot_password") {
            Forgot1(navController)
        }
        composable ( route="filter"){
            Filter(navController)
        }

        composable(route="my_order"){
            My_order(navController)
        }

        composable(route="profile") {
            Profile_1(navController)
        }

        composable(route="registration") {
            RegistrationScreen(navController)
        }

        composable(route = "women_top") {
            Women_Top(navController)
        }

        // Search

        composable  ( route="cropitem"){
            Cropitem(navController)
        }

        composable (route="findItem"){
            FindingResultsScreen(navController)
        }

        composable(route = "taking_photo") {
            SearchByPhotoScreen(navController)
        }

        composable(route="visual_search"){
            VisualSearchScreen(navController)

        }

        // favorite

        composable  (route="favorite"){
            FavoritesScreen(navController)
        }



        //BAg

        composable  (route="myBag_screen"){
            MyBag_Screen(navController)
        }


        // ADD To Cart

        composable  (route="product_card"){
            Product_Card(navController,viewModel)
        }


    }
}












