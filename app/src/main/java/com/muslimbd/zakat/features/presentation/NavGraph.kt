package com.muslimbd.zakat.features.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.muslimbd.zakat.features.presentation.donate.DonateScreen
import com.muslimbd.zakat.features.presentation.home.HomeScreen
import com.muslimbd.zakat.features.presentation.splash.SplashScreen
import com.muslimbd.zakat.features.presentation.ssl.SSLScreen
import com.muslimbd.zakat.features.presentation.zakat_calculator.ZakatCalculatorScreen

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    //coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String,
    navAction: NavigationActions = remember(navController) {
        NavigationActions(navController)
    }
) {
    //val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    //val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(
            ScreenRoute.Splash.route
        ) {
            SplashScreen(
                navController = navController,
                navToHome = navAction::navToHome
            )
        }

        composable(
            ScreenRoute.Home.route
        ) {
            HomeScreen(
                navController = navController,
                navToContent = {},
                navToZakatCalculator = navAction::navToZakatCalculator,
                navToDonate = navAction::navToDonate
            )
        }

        composable(ScreenRoute.ZakatCalculator.route) {
            ZakatCalculatorScreen(
                navController = navController,
                navToDonate = navAction::navToDonate
            )
        }

        composable(ScreenRoute.Donate.route) {
            DonateScreen(
                navController = navController,
                navToSSL = navAction::navToSSL
            )
        }


        composable(
            ScreenRoute.SSL.route,
            arguments = listOf(navArgument(ScreenArgs.TITLE) { type = NavType.StringType })
        ) { SSLScreen(navController = navController) }
    }
}