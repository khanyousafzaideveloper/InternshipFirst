package com.example.internship_21_5_24

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.phone_imei.MyInterstitialAdsFB

@Composable
fun SuccessScreen(navController: NavController) {
    val context = LocalContext.current
    val myInterstitialAds = remember { MyInterstitialAdsFB(context as Activity) }
    LaunchedEffect(Unit) {
        myInterstitialAds.loadInterstitialAdsFB("937716378294152_937717321627391")// Use test ID here
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.check),
            contentDescription = "Task complete icon",
            modifier = Modifier
                .size(180.dp)
                .padding(top = 20.dp, bottom = 20.dp)
        )
        Spacer(
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Your Request Submitted Successfully",
            modifier = Modifier.padding(12.dp),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight(700),
            color = Color.White,
        )
        Spacer(
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "Your phone unlock Request is submitted successfully. We will notify you once its done. Please wait for unlocking notification. The process will take 24-hours. \nThanks.",
            modifier = Modifier.padding(vertical = 12.dp),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
        )
        Spacer(
            modifier = Modifier.padding(20.dp)
        )
        Button(onClick = {
            navController.navigate(ProjectScreens.Home.name)
            myInterstitialAds.showInterstitialAdsFB {  }
                         } ,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFF370098)
            ),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(
                text = "Back to Home",
                fontSize = 18.sp,
                fontWeight = FontWeight(600)
            )
        }
    }
}