package com.example.internship_21_5_24


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView

@Composable
fun HomeScreenW(
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit,
    onClickIcloud: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {

    val context: Context = LocalContext.current
    val activity = remember(context) { context as? Activity }
    LaunchedEffect(Unit) {
        activity?.let {
            loadInterstitialAd(context)
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {

        HeaderText()
        WelcomeText()
        SubtitleText()

        Row(modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, top=12.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(start = 6.dp, end = 8.dp)) {

                CustomCard(
                    text = "Unlock IMEI",
                    description = "Get your IMEI Inspection for Free",
                    imageResource = R.drawable.group_1_,
                    backgroundColor = Color(0xFFF6AC57),
                    height = 180.dp,
                    onClick = {
                        if(adIsReady) {
                            showInterstitialAd(context)
                        }
                        onClick3()
                    }
                )
                CustomCard(
                    text = "Unlock Technique",
                    description = "Unlock the Lock of your Mobile Device",
                    imageResource = R.drawable.group_503,
                    backgroundColor = Color(0xFF2BB2AC),
                    height = 180.dp,
                    onClick = {
                        if (adIsReady) {
                            showInterstitialAd(context)
                        }
                        onClick1()
                    }
                )
                CustomCard(
                    text = "More Apps",
                    description = "Check our more useful application for free",
                    imageResource = R.drawable.more_app_icon,
                    backgroundColor = Color(0xFF00A06A),
                    height = 160.dp,
                    onClick = { viewModel.moreApps(context) }
                )
            }
            Column(modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp, end = 6.dp)) {
                CustomCard(
                    text = "Unlock iCloud",
                    description = "Unlock the Locks your Mobile Device",
                    imageResource = R.drawable.group_502,
                    backgroundColor = Color(0xFF6F7BF1),
                    height = 180.dp,
                    onClick = {
                        if (adIsReady) {
                            showInterstitialAd(context)
                        }
                        onClickIcloud()
                    }
                )
                CustomCard(
                    text = "Secret Codes",
                    description = "Learn about the Secret Code of other User",
                    imageResource = R.drawable.group,
                    backgroundColor = Color(0xFFED776D),
                    height = 160.dp,
                    onClick = {
                        onClick2()
                    }
                )

                CustomCard(
                    text = "Share App",
                    description = "Share our app with your friends and Family",
                    imageResource = R.drawable.share_app_icon,
                    backgroundColor = Color(0xFF276DF7),
                    height = 180.dp,
                    onClick = { viewModel.shareApp(context) }
                )
            }
        }

        // Native Ad
        NativeAdMediaView(
            nativeAdId = "ca-app-pub-4235516739414575/6434590951",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun HeaderText() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Free IMEI Checker & iCloud Bypass",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            fontWeight = FontWeight(700),
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Composable
fun WelcomeText() {
    Text(
        text = "Welcome",
        modifier = Modifier
            .padding(top = 8.dp, start = 28.dp, bottom = 8.dp),
           // .width(111.dp),
        color = Color(0xFFFFFFFF),
        fontWeight = FontWeight(700),
        fontSize = 24.sp,
      //  style = TextStyle(lineHeight = 15.sp)
    )
}

@Composable
fun SubtitleText() {
    Text(
        text = "A Magical Way to Unlock or bypass",
        modifier = Modifier
            .padding(start = 28.dp),
          //  .width(224.dp),
        color = Color(0xFFFFFFFF),
        fontWeight = FontWeight(600),
        fontSize = 14.sp,
    )
}

@Composable
fun CustomCard(
    text: String,
    description: String,
    imageResource: Int,
    backgroundColor: Color,
    height: Dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp, top =6.dp)
            .height(height)
            .clip(RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
            .background(color = backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(55.dp)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.White
                ),
                textAlign = TextAlign.Center
            )
            Text(
                text = description,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.White
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@SuppressLint("InflateParams", "ResourceType")
@Composable
fun NativeAdMediaView(
    nativeAdId: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var nativeAd by remember { mutableStateOf<NativeAd?>(null) }

    // Load Native Ad
    LaunchedEffect(nativeAdId) {
        val adLoader = AdLoader.Builder(context, nativeAdId)
            .forNativeAd { ad: NativeAd ->
                // Show the ad
                nativeAd = ad
            }
            .withNativeAdOptions(
                NativeAdOptions.Builder().build()
            )
            .withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d("Ad Error", adError.message)
                }
            })
            .build()
        adLoader.loadAd(AdRequest.Builder().build())
    }

    // Display Native Ad
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        nativeAd?.let {
            AndroidView(
                factory = { context ->
                    // Inflate the layout with a valid ViewGroup
                    val parent = FrameLayout(context)
                    LayoutInflater.from(context).inflate(R.layout.gnt_small_template_view, parent, true)
                    parent
                },
                modifier = Modifier
                    .fillMaxSize()
            ) { view ->
                val nativeAdView = view.findViewById<NativeAdView>(com.google.android.ads.nativetemplates.R.id.native_ad_view)
                // val mediaView = view.findViewById<MediaView>(R.id.media_view)

                //  nativeAdView.mediaView = mediaView
                nativeAdView.setNativeAd(it)

                // Get references to the views defined in the XML
                val iconView = view.findViewById<ImageView>(com.google.android.ads.nativetemplates.R.id.icon)

                val primaryTextView = view.findViewById<TextView>(com.google.android.ads.nativetemplates.R.id.primary)
                val adNotificationView = view.findViewById<TextView>(com.google.android.ads.nativetemplates.R.id.ad_notification_view)
                val ratingBar = view.findViewById<RatingBar>(com.google.android.ads.nativetemplates.R.id.rating_bar)
                val callToActionView = view.findViewById<AppCompatButton>(com.google.android.ads.nativetemplates.R.id.cta)

                // Set the views with the ad content
                primaryTextView.text = it.headline ?: "No headline available"
                adNotificationView.text = "Ad" // Set static ad notification text
                callToActionView.text = it.callToAction ?: "No action available"

                // Set the ad's icon, if available
                it.icon?.let { icon ->
                    iconView.setImageDrawable(icon.drawable)
                    iconView.visibility = View.VISIBLE
                } ?: run {
                    iconView.visibility = View.GONE
                }

                // Set the ad's star rating, if available
                it.starRating?.let { rating ->
                    ratingBar.rating = rating.toFloat()
                    ratingBar.visibility = View.VISIBLE
                } ?: run {
                    ratingBar.visibility = View.GONE
                }

                // Set the native ad views to the NativeAdView
                nativeAdView.iconView = iconView
                nativeAdView.headlineView = primaryTextView
                nativeAdView.callToActionView = callToActionView
                nativeAdView.starRatingView = ratingBar
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    BackgroundImage()
    HomeScreenW(onClick1 = {}, onClick2 = {}, onClick3 = {}, onClickIcloud = {})
}
