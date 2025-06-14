package com.muslimbd.zakat.features.presentation

import androidx.navigation.NavController
import com.muslimbd.zakat.R
import com.muslimbd.zakat.features.presentation.Screens.DONATE_SCREEN
import com.muslimbd.zakat.features.presentation.Screens.HOME_SCREEN
import com.muslimbd.zakat.features.presentation.Screens.SPLASH_SCREEN
import com.muslimbd.zakat.features.presentation.Screens.SSL_SCREEN
import com.muslimbd.zakat.features.presentation.Screens.ZAKAT_CALCULATOR_SCREEN


object Screens {
    const val SPLASH_SCREEN = "splashScreen"
    const val HOME_SCREEN = "homeScreen"
    const val ZAKAT_CALCULATOR_SCREEN = "zakatCalculatorScreen"
    const val DONATE_SCREEN = "donateScreen"
    const val SSL_SCREEN = "sslScreen"
}

object ScreenArgs {
    const val TITLE = "title"
    const val CATEGORY = "category"
    const val CONTENT = "content"
}

sealed class ScreenRoute(
    val route: String,
    val title: Int,
    val icon: Int,
) {

    data object Splash : ScreenRoute(
        SPLASH_SCREEN,
        R.string.app_name,
        R.drawable.zakat
    )
    data object Home : ScreenRoute(
        HOME_SCREEN,
        R.string.app_name,
        R.drawable.zakat
    )

    data object ZakatCalculator :
        ScreenRoute(ZAKAT_CALCULATOR_SCREEN, R.string.zakat_calculator, R.drawable.zakat)

    data object Donate : ScreenRoute(DONATE_SCREEN, R.string.donation, R.drawable.donate)

    data object SSL :
        ScreenRoute(
            "${SSL_SCREEN}?${ScreenArgs.TITLE}={${ScreenArgs.TITLE}}",
            R.string.ssl,
            R.drawable.zakat
        )
}

class NavigationActions(private val navController: NavController) {
    fun navToZakatCalculator() {
        navController.navigate(ZAKAT_CALCULATOR_SCREEN) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navToHome() {
        navController.navigate(HOME_SCREEN) {
            launchSingleTop = true
            restoreState = true
            popUpTo(0)
        }
    }

    fun navToDonate() {
        navController.navigate(
            DONATE_SCREEN
        ) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navToSSL(url: String) {
        navController.navigate("${SSL_SCREEN}?${ScreenArgs.TITLE}=${url}")
    }

}