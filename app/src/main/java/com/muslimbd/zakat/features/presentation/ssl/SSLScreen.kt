package com.muslimbd.zakat.features.presentation.ssl

import android.annotation.SuppressLint
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.muslimbd.zakat.core.components.Loader
import com.muslimbd.zakat.core.theme.BackGroundColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val sslSuccessUrl = "https://micropay.v4technologiesbd.com/SSLPaySuccessCallBack/Get"


const val sslFailedUrl = "https://micropay.v4technologiesbd.com/SSLPayFailCallBack/Get"

@SuppressLint("CoroutineCreationDuringComposition", "SetJavaScriptEnabled")
@Composable
fun SSLScreen(
    navController: NavHostController,
    viewModel: SSLViewModel = hiltViewModel(),
    snackBarHostState: SnackbarHostState = remember { SnackbarHostState() },
    scope: CoroutineScope = rememberCoroutineScope()
) {
    Scaffold(snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
    ) { paddingValues ->

        val state by viewModel.state.collectAsStateWithLifecycle()
        val failed = remember {
            mutableStateOf(false)
        }

        Box(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = BackGroundColor)
            ) {
                AndroidView(factory = {
                    WebView(it).apply {
                        layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                        settings.builtInZoomControls = true
                        settings.javaScriptEnabled = true
                        settings.setSupportZoom(true)
                        settings.userAgentString
                        webChromeClient = WebChromeClient()
                        //webViewClient = object : WebChromeClient() {}

                        webViewClient = object : WebViewClient() {
                            override fun onPageFinished(view: WebView, url: String) {
                                viewModel.onPageLoaded()
                                println(url)

                                if (url == sslFailedUrl
                                    || url.contains("fail") || url.contains("Fail") || url.contains(
                                        "FAIL"
                                    ) || url.contains(
                                        "cancel"
                                    ) || url.contains(
                                        "Cancel"
                                    ) || url.contains(
                                        "CANCEL"
                                    ) || url.contains("Duplicate") || url.contains("Aborted")
                                ) {
                                    scope.launch {
                                        if (!failed.value) {
                                            failed.value = true
                                            delay(3000)
                                            navController.popBackStack()
                                        }
                                    }
                                } else if (url.startsWith(sslSuccessUrl)) {
                                    scope.launch {
                                        delay(3000)
                                        navController.navigateUp()
                                        navController.navigateUp()
                                    }
                                }
                            }
                        }
                        loadUrl(state.url)
                    }
                }, update = {

                })

            }
            if (state.isLoading)
                Loader(paddingValues = paddingValues)
        }


    }
}