package com.example.internship_21_5_24

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Preview
@Composable
fun WebPage_Icloud(){
    val isLoading = remember { mutableStateOf(true) } // Track the loading state
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        LaunchedEffect(Unit) {
            showInterstitialAd(context = context)
        }
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true
                    webViewClient = object : WebViewClient() {
                        override fun onPageStarted(
                            view: WebView?,
                            url: String?,
                            favicon: Bitmap?
                        ) {
                            super.onPageStarted(view, url, favicon)
                            isLoading.value = true // Show loading indicator
                        }

                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)
                            isLoading.value = false // Hide loading indicator
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxSize(),
            update = { webView ->
                webView.loadUrl("https://imei.appifytechnologies.com/icloud-bypass/")
            }
        )

        // Loading Indicator
        if (isLoading.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFA705E1).copy(alpha = 0.4f)), // Optional dim background
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = Color(0xFF7A00E7) // Set your desired color
                )
            }
        }
    }
}