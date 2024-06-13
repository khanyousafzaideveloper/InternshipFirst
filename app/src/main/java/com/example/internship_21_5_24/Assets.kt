package com.example.internship_21_5_24

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun Assets(card: Int){
    val url = remember {
        when (card) {
            1 -> "file:///android_asset/tool_lab.html"
            2 ->  "file:///android_asset/pas_fab.html"
            3 -> "file:///android_asset/king_root.html"
            4 -> "file:///android_asset/isky.html"
            5 -> "file:///android_asset/UnLockPhone.html"
            6 -> "file:///android_asset/iMyFoneLockWiper.html"
            7 -> "file:///android_asset/Tenorshare4uKeyforAndroid.html"
            else -> ""
        }
    }
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.textZoom = 250
                settings.loadsImagesAutomatically = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                webViewClient = WebViewClient()
            }
        },
        modifier = Modifier.fillMaxSize(),
        update = { webView ->
            webView.loadUrl(url)
        }
    )
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun AssetsUnlockByTricks(card: Int){

    val url = remember {
        when (card) {
            1 -> "file:///android_asset/Verizon_phone.html"
            2 -> "file:///android_asset/kitkat.html"
            3 -> "file:///android_asset/Bypass.html"
            4 -> "file:///android_asset/CrashLockScreen.html"
            5 -> "file:///android_asset/FactoryReset.html"
            6 -> "file:///android_asset/UseADBPasswordFile.html"
            7 -> "file:///android_asset/findmydevice.html"
            8 -> "file:///android_asset/UseSamsungService.html"
            9 -> "file:///android_asset/useforgetfeature.html"
            10 -> "file:///android_asset/EEmobile.html"
            11 -> "file:///android_asset/wirless.html"
            12 -> "file:///android_asset/use_command.html"
            13 -> "file:///android_asset/vergin_mobile.html"
            14 -> "file:///android_asset/without_loss.html"
            15 -> "file:///android_asset/without_gmail.html"
            else -> ""
        }
    }
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.textZoom = 250
                settings.loadsImagesAutomatically = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                webViewClient = WebViewClient()
            }
        },
        modifier = Modifier.fillMaxSize(),
        update = { webView ->
            webView.loadUrl(url)
        }
    )
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun Assets3(card: Int){

    val url = remember {
        when (card) {
            1 -> "file:///android_asset/AndroidSIMUnlock.html"
            2 -> "file:///android_asset/GalaxSimUnlock.html"
            3 -> "file:///android_asset/SamsungSIMUnlock.html"
            4 -> "file:///android_asset/SIMUnlockforHTCPhones.html"
            5 -> "file:///android_asset/Unlockyourphonebyapp.html"
            else -> ""
        }
    }
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.textZoom = 250
                settings.loadsImagesAutomatically = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                webViewClient = WebViewClient()
            }
        },
        modifier = Modifier.fillMaxSize(),
        update = { webView ->
            webView.loadUrl(url)
        }
    )
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun Assets4(card: Int){

    val url = remember {
        when (card) {
            1 -> "file:///android_asset/AndroidSIMunlocksoftware.html"
            2 -> "file:///android_asset/GalxSimUnlockapp.html"
            3 -> "file:///android_asset/Unlockyourphonefastandsecureapp.html"
            else -> ""
        }
    }
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.textZoom = 250
                settings.loadsImagesAutomatically = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                webViewClient = WebViewClient()
            }
        },
        modifier = Modifier.fillMaxSize(),
        update = { webView ->
            webView.loadUrl(url)
        }
    )
}
