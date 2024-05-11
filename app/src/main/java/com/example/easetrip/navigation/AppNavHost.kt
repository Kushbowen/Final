package com.example.easetrip.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.easetrip.ui.theme.animation.AnimationScreen
import com.example.easetrip.ui.theme.dashboard.DashboardScreen
import com.example.easetrip.ui.theme.screens.home.HomeScreen
import com.example.easetrip.ui.theme.screens.login.LoginScreen
import com.example.easetrip.ui.theme.signup.SignUpScreen
import com.example.easetrip.ui.theme.splash.SplashScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController:NavHostController = rememberNavController(), startDestination:String = ROUT_SPLASH) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }

        composable(ROUT_LOGIN) {
            LoginScreen(navController)
        }

        composable(ROUT_SIGNUP) {
            SignUpScreen(navController)
        }


        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }

        composable(ROUT_ANIMATION) {
            AnimationScreen(navController)
        }



    }
}