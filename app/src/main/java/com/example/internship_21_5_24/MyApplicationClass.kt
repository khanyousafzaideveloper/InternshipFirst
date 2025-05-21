package com.example.internship_21_5_24

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.appopen.AppOpenAd
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date

class MyApplication : Application(), Application.ActivityLifecycleCallbacks, LifecycleObserver {

    private lateinit var appOpenAdManager: AppOpenAdManager
    private var currentActivity: Activity? = null

    interface OnShowAdCompleteListener {
        fun onShowAdComplete()
    }

    override fun onCreate() {
        super.onCreate()
        this.registerActivityLifecycleCallbacks(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        appOpenAdManager = AppOpenAdManager()

        CoroutineScope(Dispatchers.Main).launch {
            initializeMobileAds()
        }
    }

    private suspend fun initializeMobileAds() = withContext(Dispatchers.IO) {
        MobileAds.initialize(this@MyApplication) {
            loadAndShowAppOpenAd()
        }
    }

    private fun loadAndShowAppOpenAd() {
        val request = AdRequest.Builder().build()
        AppOpenAd.load(
            this,
            AppOpenAdManager.AD_UNIT_ID,
            request,
            AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
            object : AppOpenAd.AppOpenAdLoadCallback() {
                override fun onAdLoaded(ad: AppOpenAd) {
                    appOpenAdManager.showAdIfAvailable(currentActivity, object : OnShowAdCompleteListener {
                        override fun onShowAdComplete() {
                            // Handle ad shown complete, if needed
                        }
                    })
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Log.e(TAG, "App open ad failed to load: ${loadAdError.message}")
                }
            }
        )
    }

    // ActivityLifecycleCallback methods
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

    override fun onActivityStarted(activity: Activity) {
        if (!appOpenAdManager.isShowingAd) {
            currentActivity = activity
        }
    }

    override fun onActivityResumed(activity: Activity) {}

    override fun onActivityPaused(activity: Activity) {}

    override fun onActivityStopped(activity: Activity) {}

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

    override fun onActivityDestroyed(activity: Activity) {}

    private class AppOpenAdManager {

        companion object {
            private const val LOG_TAG = "AppOpenAdManager"
            const val AD_UNIT_ID = "ca-app-pub-4235516739414575/6418520337"

        }

        private var appOpenAd: AppOpenAd? = null
        private var isLoadingAd = false
        var isShowingAd = false
            private set

        /** Keep track of the time an app open ad is loaded to ensure you don't show an expired ad. */
        private var loadTime: Long = 0

        /** Load an ad. */
        private fun loadAd(context: Context) {
            // Do not load ad if there is an unused ad or one is already loading.
            if (isLoadingAd || isAdAvailable()) {
                return
            }

            isLoadingAd = true
            val request = AdRequest.Builder().build()
            AppOpenAd.load(
                context,
                AD_UNIT_ID,
                request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                object : AppOpenAd.AppOpenAdLoadCallback() {
                    /** Called when an app open ad has loaded. */
                    override fun onAdLoaded(ad: AppOpenAd) {
                        appOpenAd = ad
                        isLoadingAd = false
                        loadTime = Date().time

                        Log.d(LOG_TAG, "onAdLoaded.")
                        // Toast.makeText(context, "onAdLoaded", Toast.LENGTH_SHORT).show()

                        val activity = context as? Activity

                        Handler().postDelayed({
                            if (appOpenAd != null) {
                                appOpenAd?.show(activity!!)
                            } else {
                                Toast.makeText(activity, "appOpenAd is not loaded", Toast.LENGTH_SHORT).show()
                            }
                        }, 20)
                    }

                    /** Called when an app open ad has failed to load. */
                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        isLoadingAd = false
                        Log.d(LOG_TAG, "onAdFailedToLoad: ${loadAdError.message}")
                        Toast.makeText(context, "onAdFailedToLoad", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }

        /** Check if ad exists and can be shown. */
        private fun isAdAvailable(): Boolean {
            return appOpenAd != null
        }

        fun showAdIfAvailable(
            activity: Activity?,
            onShowAdCompleteListener: OnShowAdCompleteListener
        ) {
            // If the app open ad is already showing, do not show the ad again.
            if (isShowingAd) {
                Log.d(LOG_TAG, "The app open ad is already showing.")
                return
            }

            // If the app open ad is not available yet, invoke the callback then load the ad.
            if (!isAdAvailable()) {
                Log.d(LOG_TAG, "The app open ad is not ready yet.")
                onShowAdCompleteListener.onShowAdComplete()
                loadAd(activity as Context)
                return
            }

            Log.d(LOG_TAG, "Will show ad.")

            appOpenAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                /** Called when full screen content is dismissed. */
                override fun onAdDismissedFullScreenContent() {
                    // Set the reference to null so isAdAvailable() returns false.
                    appOpenAd = null
                    isShowingAd = false

                    Log.d(LOG_TAG, "onAdDismissedFullScreenContent.")
                    Toast.makeText(activity, "onAdDismissedFullScreenContent", Toast.LENGTH_SHORT).show()

                    onShowAdCompleteListener.onShowAdComplete()
                    if (activity != null) {
                        loadAd(activity)
                    }
                }

                /** Called when fullscreen content failed to show. */
                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    appOpenAd = null
                    isShowingAd = false

                    Log.d(LOG_TAG, "onAdFailedToShowFullScreenContent: ${adError.message}")
                    Toast.makeText(activity, "onAdFailedToShowFullScreenContent", Toast.LENGTH_SHORT).show()

                    onShowAdCompleteListener.onShowAdComplete()
                    if (activity != null) {
                        loadAd(activity)
                    }
                }

                /** Called when fullscreen content is shown. */
                override fun onAdShowedFullScreenContent() {
                    Log.d(LOG_TAG, "onAdShowedFullScreenContent.")
                    Toast.makeText(activity, "onAdShowedFullScreenContent", Toast.LENGTH_SHORT).show()
                }
            }

            isShowingAd = true

            // Check if appOpenAd is not null before calling the show method
            activity?.let { appOpenAd?.show(it) } ?: Log.e(LOG_TAG, "appOpenAd is null, cannot show the ad.")
        }
    }

    companion object {
        private const val TAG = "MyApplication"
    }
}