package com.example.internship_21_5_24

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.compose.BackHandler
import androidx.appcompat.widget.AppCompatButton
import android.graphics.Color as AndroidColor
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
fun HomeScreen(
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3:()-> Unit,
    onClickIcloud: () -> Unit
){

    val viewModel: HomeViewModel = viewModel()
    val context: Context = LocalContext.current
    val activity = remember(context) { context as? Activity }


    Column(
        modifier=Modifier.fillMaxSize()
    ) {
        Text(
            text = "Free IMEI Checker & iCloud Bypass",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            color = Color.White,
            fontWeight = FontWeight(700),
            fontSize = 17.sp,
            textAlign = TextAlign.Center
        )


        // InterstitialAd
        LaunchedEffect(Unit) {
            activity?.let {
                loadInterstitialAd(context)
            }
        }

        Text(
            text = "Welcome",
            modifier = Modifier
                .padding(top = 8.dp, start = 28.dp, bottom = 8.dp)
                .width(111.dp),
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight(700),
            fontSize = 24.sp,
            style = TextStyle(
                lineHeight = 15.sp
            )
        )

        Text(
            text = "A Magical Way to Unlock or bypass",
            modifier = Modifier
                .padding(start = 28.dp)
                .width(224.dp),
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight(600),
            fontSize = 14.sp,
            style = TextStyle(
                lineHeight = 14.sp
            )
        )

        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 6.dp, end = 4.dp)
            ) {
                //8.2.2
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .padding(bottom = 6.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable {
                                showInterstitialAd(context as Activity)
                                onClick1()
                        }
                        .background(color = Color(0xFF2BB2AC))
                ) {
                    Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.group_503),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .align(Alignment.CenterHorizontally)
                                .width(58.96.dp)
                                .height(59.52.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Unlock Technique",
                                modifier = Modifier
                                    .padding(4.dp)
                                    .align(Alignment.CenterHorizontally),
                                style = TextStyle(
                                    fontWeight = FontWeight(700),
                                    fontSize = 15.sp,
                                    lineHeight = 15.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Unlock the Lock of your Mobile Device",
                                modifier = Modifier
                                    .padding(8.dp),
                                style = TextStyle(
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .padding(bottom = 6.dp)
                        .width(150.dp)
                        .height(180.dp)
                        .clickable { onClickIcloud() }
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color(0xFF6F7BF1))
                ) {
                    Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.group_502),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .align(Alignment.CenterHorizontally)
                                .width(70.dp)
                                .height(48.14.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Unlock iCloud",
                                modifier = Modifier,
                                style = TextStyle(
                                    fontWeight = FontWeight(700),
                                    fontSize = 15.sp,
                                    lineHeight = 15.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Unlock the Locks your Mobile Device",
                                modifier = Modifier
                                    .padding(8.dp),
                                style = TextStyle(
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .width(150.dp)
                        .height(160.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { viewModel.moreApps(context) }
                        .background(color = Color(0xFF00A06A))
                ) {
                    Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.more_app_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .align(Alignment.CenterHorizontally)
                                .width(58.96.dp)
                                .height(49.52.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "More Apps",
                                modifier = Modifier
                                    .width(129.dp),
                                style = TextStyle(
                                    fontWeight = FontWeight(700),
                                    fontSize = 15.sp,
                                    lineHeight = 15.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Check our more useful application for free",
                                modifier = Modifier
                                    .padding(8.dp),
                                style = TextStyle(
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp, end = 6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .padding(bottom = 6.dp)
                        .width(150.dp)
                        .height(160.dp)
                        .clickable { onClick2() }
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color(0xFFED776D))
                ) {
                    Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.group),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Secret Codes",
                                modifier = Modifier
                                    .width(129.dp),
                                style = TextStyle(
                                    fontWeight = FontWeight(700),
                                    fontSize = 15.sp,
                                    lineHeight = 15.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Learn about the Secret Code of other User",
                                modifier = Modifier
                                    .padding(8.dp)
                                    .width(126.dp)
                                    .height(32.dp),
                                style = TextStyle(
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .padding(bottom = 6.dp)
                        .width(150.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable {
                            showInterstitialAd(context)
                            onClick3()
                        }
                        .background(color = Color(0xFFF6AC57))
                ) {
                    Column ( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                        Image(
                            painter = painterResource(id = R.drawable.group_1_),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .align(Alignment.CenterHorizontally)
                                .width(58.96.dp)
                                .height(44.52.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Unlock IMEI",
                                modifier = Modifier,
                                style = TextStyle(
                                    fontWeight = FontWeight(700),
                                    fontSize = 15.sp,
                                    lineHeight = 15.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Get your IMEI Inspection for Free",
                                modifier = Modifier
                                    .padding(8.dp),
                                style = TextStyle(
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .clickable { viewModel.shareApp(context) }
                        .width(150.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color(0xFF276DF7))
                ) {
                    Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.share_app_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .align(Alignment.CenterHorizontally)
                                .width(58.96.dp)
                                .height(49.52.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Share App",
                                modifier = Modifier,
                                style = TextStyle(
                                    fontWeight = FontWeight(700),
                                    fontSize = 15.sp,
                                    lineHeight = 15.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "Share our app with your friends and Family",
                                modifier = Modifier
                                    .padding(8.dp),
                                style = TextStyle(
                                    fontWeight = FontWeight(400),
                                    fontSize = 12.sp,
                                    lineHeight = 16.sp,
                                    color = Color(0xFFFFFFFF),
                                ),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }
            }
        }

        //Native Add
       NativeAdMediaView(nativeAdId = "ca-app-pub-4235516739414575/7671478288", modifier = Modifier.fillMaxWidth())
    }
}

@SuppressLint("InflateParams")
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
            .padding(top = 8.dp)
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
                    .fillMaxWidth()
            ) { view ->
                val nativeAdView = view.findViewById<NativeAdView>(R.id.native_ad_view)
                val mediaView = view.findViewById<MediaView>(R.id.media_view)

                nativeAdView.mediaView = mediaView
                nativeAdView.setNativeAd(it)

                // Get references to the views defined in the XML
                val iconView = view.findViewById<ImageView>(R.id.icon)
                val primaryTextView = view.findViewById<TextView>(R.id.primary)
                val adNotificationView = view.findViewById<TextView>(R.id.ad_notification_view)
                val ratingBar = view.findViewById<RatingBar>(R.id.rating_bar)
                val callToActionView = view.findViewById<AppCompatButton>(R.id.cta)

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

@Preview
@Composable
fun Previews(){
    BackgroundImage()
    HomeScreen(onClick1 = {}, onClick2 = {}, onClick3 = {}, onClickIcloud = {})
}

