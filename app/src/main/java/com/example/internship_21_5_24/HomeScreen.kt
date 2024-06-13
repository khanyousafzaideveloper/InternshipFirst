package com.example.internship_21_5_24

import android.app.Activity
import android.content.Context
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
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
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(onClick1: () ->Unit, onClick2: () -> Unit, onClick3:()->Unit, onClickIcloud: () -> Unit){
    val viewModel: HomeViewModel = viewModel()
    val context: Context = LocalContext.current
    val activity = context as? Activity
    Column(modifier=Modifier.fillMaxSize()) {
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
        LaunchedEffect(Unit) {
            activity?.let {
                loadAndShowInterstitialAd(it)
                delay(6800)
            }
        }
//        Button(onClick = {
//            activity?.let { loadAndShowInterstitialAd(it) }
//            }
//        ) {
//            Text("Show add")
//        }
        Text(
            text = "Welcome",
            modifier = Modifier
                .padding(top = 28.dp, start = 28.dp, bottom = 8.dp)
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
             //   .fillMaxSize()
                .padding(8.dp)
        ) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    //  .fillMaxHeight()
                    .padding(start = 4.dp, end = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .padding(bottom = 4.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { onClick1() }
                        .background(color = Color(0xFF2BB2AC))
                ) {
                    Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.unlock_technique_icon),
                            contentDescription = null,
                            modifier = Modifier
                                //  .padding(top = 187.dp - 174.dp, start = 66.dp - 20.dp)
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
                                    //.width(129.dp)
                                    //  .height(15.dp)
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
                                    //.width(126.dp)
                                    //.height(32.dp),
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
                        .padding(bottom = 4.dp)
                        .width(150.dp)
                        .height(180.dp)
                        .clickable { onClickIcloud() }
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color(0xFF6F7BF1))
                ) {
                    Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.unlock_icloud_icon_1_),
                            contentDescription = null,
                            modifier = Modifier
                                // .padding(top = 187.dp - 174.dp, start = 66.dp - 20.dp)
                                .padding(top = 16.dp)
                                .align(Alignment.CenterHorizontally)
                                .width(58.96.dp)
                                .height(59.52.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Unlock iCloud",
                                modifier = Modifier,
                                    //  .padding(top = 275.dp - 174.dp, start = 31.dp - 20.dp)
                                    //.width(129.dp),
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
                                   // .width(126.dp)
                                    //.height(32.dp),
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
                                .height(59.52.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "More Apps",
                                modifier = Modifier
                                    //  .padding(top = 275.dp - 174.dp, start = 31.dp - 20.dp)
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
                                    //.width(126.dp)
                                    //.height(32.dp),
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
                    //  .fillMaxHeight()
                    .padding(start = 4.dp, end = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .padding(bottom = 4.dp)
                        .width(150.dp)
                        .height(160.dp)
                        .clickable { onClick2() }
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = Color(0xFFED776D))
                ) {
                    Column( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.secret_code_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .align(Alignment.CenterHorizontally)
                                //.width(58.96.dp)
                                //.height(59.52.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Secret Codes",
                                modifier = Modifier
                                    //  .padding(top = 275.dp - 174.dp, start = 31.dp - 20.dp)
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
                        .padding(bottom = 4.dp)
                        .width(150.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable { onClick3() }
                        .background(color = Color(0xFFF6AC57))
                ) {
                    Column ( modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                        Image(
                            painter = painterResource(id = R.drawable.ulock_imei_icon),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .align(Alignment.CenterHorizontally)
                                .width(58.96.dp)
                                .height(59.52.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Unlock IMEI",
                                modifier = Modifier,
                                    //  .padding(top = 275.dp - 174.dp, start = 31.dp - 20.dp)
                                   // .width(129.dp),
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
                                   // .width(126.dp)
                                   // .height(32.dp),
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
                                .height(59.52.dp)
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Share App",
                                modifier = Modifier,
                                    //  .padding(top = 275.dp - 174.dp, start = 31.dp - 20.dp)
                                    //.width(129.dp),
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
                                    //.width(126.dp)
                                    //.height(32.dp),
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
    //   BannerAd(modifier = Modifier.fillMaxWidth(), adID ="ca-app-pub-3940256099942544/9214589741")
    }
}

@Composable
fun BannerAd(modifier:Modifier, adID: String){
    val context = LocalContext.current
    val adView = remember {
        AdView(context).apply {
            adUnitId = adID
            setAdSize(AdSize.BANNER)
            loadAd(AdRequest.Builder().build())
        }
    }

    AndroidView(factory = { adView },modifier.padding(4.dp))
}
@Preview
//@Preview(showBackground = true, name = "Small Phone", widthDp = 320, heightDp = 480)
//@Preview(showBackground = true, name = "Normal Phone", widthDp = 360, heightDp = 640)
//@Preview(showBackground = true, name = "Large Phone", widthDp = 400, heightDp = 800)
//@Preview(showBackground = true, name = "Extra Large Phone", widthDp = 480, heightDp = 853)
//@Preview(showBackground = true, name = "Large Tablet", widthDp = 800, heightDp = 1280)
//@Preview(showBackground = true, name = "Full HD TV", widthDp = 1920, heightDp = 1080)
@Composable
fun Previews(){
    BackgroundImage()
    HomeScreen(onClick1 = {}, onClick2 = {}, onClick3 = {}, onClickIcloud = {})
}

