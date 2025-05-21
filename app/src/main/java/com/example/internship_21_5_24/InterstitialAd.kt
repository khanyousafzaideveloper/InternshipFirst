package com.example.internship_21_5_24

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


var minterstitialAd: InterstitialAd? = null
val adUnitId: String = "ca-app-pub-4235516739414575/6733139707"
var adIsReady: Boolean = false
fun loadInterstitialAd(context: Context) {
    val adRequest = AdRequest.Builder().build()
    InterstitialAd.load(context, adUnitId, adRequest, object : InterstitialAdLoadCallback() {
        override fun onAdFailedToLoad(p0: LoadAdError) {
            super.onAdFailedToLoad(p0)
            Log.d("adssss", "ssssss")
            minterstitialAd = null
            adIsReady = false
        }

        override fun onAdLoaded(p0: InterstitialAd) {
            super.onAdLoaded(p0)
            minterstitialAd = p0
            adIsReady = true
        }
    })
}

fun showInterstitialAd(
    context: Context,
    onAdDismissed: (() -> Unit)? = null
) {
    minterstitialAd?.let { ad ->
        ad.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
                super.onAdDismissedFullScreenContent()
                minterstitialAd = null
                onAdDismissed?.invoke()

                loadInterstitialAd(context)
            }

            override fun onAdImpression() {
                super.onAdImpression()
            }

            override fun onAdClicked() {
                super.onAdClicked()
            }
        }
        ad.show(context as Activity)
    }
//        ?: run {
//        // Optionally handle the case when the ad isn't ready to be shown
//        Toast.makeText(context, "Ad is not ready yet", Toast.LENGTH_SHORT).show()
//        onAdDismissed?.invoke() // Ensure callback is called even if ad is not shown
//    }
}
