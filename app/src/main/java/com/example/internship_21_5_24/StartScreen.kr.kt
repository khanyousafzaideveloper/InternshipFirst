package com.example.internship_21_5_24

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun StartScreen(onClick: ()->Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = R.drawable.splashscreen_logo),
            contentDescription =null,
            )
        Spacer(modifier = Modifier.padding(12.dp))
        Text(
            text = "Free IMEI Checker & ICloud Bypass",
            color = Color(0xFFFFFFFF),
            fontWeight = FontWeight(700),
            fontSize = 22.sp
        )
        Spacer(
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = "Unlock iCloud-locked devices with ease using our IMEI Checker & iCloud Bypass app. Gain full control in a few simple steps",
            color = Color(0xFFFFFFFF),
            fontSize = 16.sp
        )
        Spacer(
            modifier = Modifier.padding(12.dp)
        )
        Button(
            onClick =  onClick,
            Modifier.fillMaxWidth() .size(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp),
        ) {
        Text(
            "Start",
            fontSize = 16.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFF370098)
            )
        }
    }
}

@Preview
@Composable
fun Preview(){
    BackgroundImage()
    StartScreen(onClick = {})
}