package com.example.internship_21_5_24

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun HomeScreen(){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.home_8),
            contentDescription = "null",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Free IMEI Checker & iCloud Bypass",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(top = 56.dp, start = 39.dp, end = 39.dp)
                .width(282.dp),
            color = Color.White,
            fontWeight = FontWeight(700),
            fontSize = 17.sp,
//            style = TextStyle(
//                lineHeight = 15.sps
//            ),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Welcome",
            modifier = Modifier
                .padding(top = 97.dp, start = 20.dp)
                .width(111.dp),
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight(700),
            fontSize = 24.sp,
            style = TextStyle(
                lineHeight = 15.sp
            )
        )
        Text(
            text = "A Magical Way to Unlock or bypas",
            modifier = Modifier
                .padding(top = 130.dp, start = 20.dp)
                .width(224.dp),
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight(600),
            fontSize = 14.sp,
            style = TextStyle(
                lineHeight = 14.sp
            )
        )

            Box(
                modifier = Modifier
                    .padding(top = 174.dp, start = 20.dp)
                    .width(150.dp)
                    .height(180.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color(0xFF2BB2AC))
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.group_503),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 187.dp - 174.dp, start = 66.dp - 20.dp)
                            .width(58.96.dp)
                            .height(59.52.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Column {
                        Text(
                            text = "Unlock Technique",
                            modifier = Modifier
                                //  .padding(top = 275.dp - 174.dp, start = 31.dp - 20.dp)
                                .width(129.dp)
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
                    .padding(top = 174.dp, start = 189.dp)
                    .width(150.dp)
                    .height(160.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color(0xFFED776D))
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.group11),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 187.dp - 174.dp, start = 66.dp - 20.dp)
                            .width(58.96.dp)
                            .height(59.52.dp)
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
                    .padding(top = 374.dp, start = 20.dp)
                    .width(150.dp)
                    .height(180.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color(0xFF6F7BF1))
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.group_502),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 187.dp - 174.dp, start = 66.dp - 20.dp)
                            .width(58.96.dp)
                            .height(59.52.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Unlock iCloud",
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
                            text = "Unlock the Locks your Mobile Device",
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
                    .padding(top = 354.dp, start = 189.dp)
                    .width(150.dp)
                    .height(180.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color(0xFFF6AC57))
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.group),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 187.dp - 174.dp, start = 66.dp - 20.dp)
                            .width(58.96.dp)
                            .height(59.52.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Unlock IMEI",
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
                            text = "Get your IMEI Inspection for Free",
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
                    .padding(top = 568.dp, start = 20.dp)
                    .width(150.dp)
                    .height(160.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color(0xFF00A06A))
            ) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.more_app_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 187.dp - 174.dp, start = 66.dp - 20.dp)
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
                    .padding(top = 548.dp, start = 189.dp)
                    .width(150.dp)
                    .height(180.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color(0xFF276DF7))
            ) {
                Column() {
                    Image(
                        painter = painterResource(id = R.drawable.share_app_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 187.dp - 174.dp, start = 66.dp - 20.dp)
                            .width(58.96.dp)
                            .height(59.52.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Share App",
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
                            text = "Share our app with your friends and Family",
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
        }
    
}