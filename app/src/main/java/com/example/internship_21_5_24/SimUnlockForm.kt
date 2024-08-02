package com.example.internship_21_5_24

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimUnlockForm() {

    var txtF1 by remember { mutableStateOf("") }
    var txtF2 by remember { mutableStateOf("") }
    var txtF3 by remember { mutableStateOf("") }
    var txtF4 by remember { mutableStateOf("") }
    val context: Context = LocalContext.current
    loadInterstitialAd(context)
    val viewModel: HomeViewModel = viewModel()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Text(
                text = "IMEI Inspection",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(116.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    lineHeight = 16.sp,
                    color = Color(0xFFF7F7F7)
                )
            )
            Text(
                text = "Feel free so please Send us your phone IMEI and your issues.",
                modifier = Modifier
                    .padding(top = 123.dp - 95.dp)
                    .width(243.dp)
                    .height(40.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 20.sp,
                    color = Color(0xFFF7F7F7)
                )
            )
            TextField(
                value = txtF1,
                onValueChange = { txtF1 = it },
                label = {
                    Text(
                        text = "Your Email",
                        color = Color(0xFF444444)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFFFFFFF)),
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(6.dp)
                    ),
            )
            TextField(
                value = txtF2,
                onValueChange = { txtF2 = it },
                label = {
                    Text(
                        text = "First Name",
                        color = Color(0xFF444444)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFFFFFFF)),
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(6.dp)
                    )
            )
            TextField(
                value = txtF3,
                onValueChange = { txtF3 = it },
                label = {
                    Text(
                        text = "Last Name",
                        color = Color(0xFF444444)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFFFFFFF)),
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)

                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(6.dp)
                    )
            )
            TextField(
                value = txtF4,
                onValueChange = { txtF4 = it },
                label = {
                    Text(
                        text = "Your Feedback",
                        color = Color(0xFF444444)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFFFFFFF)),
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
                    .height(91.dp)
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(6.dp)
                    )
            )
            Button(
                onClick = { viewModel.shareIMEI(context, txtF1, txtF2, txtF3, txtF4) },
                shape = RectangleShape,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(
                        RoundedCornerShape(6.dp)
                    ),
                colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
            )
            {
                Text(
                    text = "Submit",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700),
                        lineHeight = 16.sp,
                        color = Color(0xFF561F82)
                    )
                )
            }
        }

}
@Preview
@Composable
fun Preview4(){
    BackgroundImage()
    SimUnlockForm()
}