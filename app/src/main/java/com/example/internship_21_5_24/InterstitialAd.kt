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
val adUnitId: String = "ca-app-pub-4235516739414575/6016881189"
fun loadInterstitialAd(context: Context) {
    val adRequest = AdRequest.Builder().build()
    InterstitialAd.load(context, adUnitId, adRequest, object : InterstitialAdLoadCallback() {
        override fun onAdFailedToLoad(p0: LoadAdError) {
            super.onAdFailedToLoad(p0)
            Log.d("adssss","ssssss")
            minterstitialAd = null
           // adStatus.invoke(false)
        }

        override fun onAdLoaded(p0: InterstitialAd) {
            super.onAdLoaded(p0)
            minterstitialAd = p0
           // adStatus.invoke(true)
        }
    })
}

fun showInterstitialAd(context: Context) {
    minterstitialAd.let { ad ->

        if (ad != null) {
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()
                    minterstitialAd = null
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
    }
}