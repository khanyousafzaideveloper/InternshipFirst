package com.example.phone_imei

import android.app.Activity
import android.widget.Toast
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.InterstitialAdListener


class MyInterstitialAdsFB(private val activity: Activity) {
    private var interstitialAds : com.facebook.ads.InterstitialAd? = null

    fun loadInterstitialAdsFB(placementId:String){
        interstitialAds = com.facebook.ads.InterstitialAd(activity, placementId)
        interstitialAds?.loadAd()
    }

    fun showInterstitialAdsFB(afterSomeCode: () -> Unit) {
        if (interstitialAds != null && interstitialAds?.isAdLoaded == true){
            interstitialAds?.buildLoadAdConfig()?.withAdListener(object : InterstitialAdListener{
                override fun onError(ad: Ad?, adError: AdError?) {
                    activity.longToastShow("${adError?.errorMessage}")
                }

                override fun onAdLoaded(ad: Ad?) {
                    activity.longToastShow("AdLoaded")
                }

                override fun onAdClicked(ad: Ad?) {
                    activity.longToastShow("AdClicked")
                }

                override fun onLoggingImpression(ad: Ad?) {
                    activity.longToastShow("onLoggingImpression")
                }

                override fun onInterstitialDisplayed(ad: Ad?) {
                    activity.longToastShow("Interstitial Displayed")
                }

                override fun onInterstitialDismissed(ad: Ad?) {
                    interstitialAds = null
                    afterSomeCode()
                }

            })?.build()
            interstitialAds?.show()
        }else{
            afterSomeCode()
        }

    }

}
fun Activity.longToastShow(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
