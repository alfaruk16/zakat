package com.muslimbd.zakat.features.presentation.splash

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.muslimbd.zakat.R
import com.muslimbd.zakat.core.theme.BackGroundColor
import com.muslimbd.zakat.features.data.remote.model.CategoryDtoItem
import kotlinx.coroutines.delay

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel(),
    category: CategoryDtoItem? = null,
    navController: NavController,
    navToHome: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->

        val width = LocalConfiguration.current.screenWidthDp.dp

        LaunchedEffect(Unit) {
            delay(2000)
            navToHome()
        }

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(brush = Brush.verticalGradient(listOf(BackGroundColor, Color.White)))
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.zakat_logo),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(width / 2)
            )

        }
    }
}
