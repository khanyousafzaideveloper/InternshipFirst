package com.example.internship_21_5_24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import com.example.internship_21_5_24.ui.theme.Internship21524Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Internship21524Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    BackgroundImage()
                    HomeScreen()
                  //  UnlockTechListScreen(cards = UnlockTechDataList)
                 //   UnlockBySoftware(cards = UnlockBySoftwareList)
                 //   SimUnlockScreen(cards = SimUnlockList)
                 //   SimUnlockScreen(cards = SimUnlockList)
                  //  SimUnlockForm()
                  //  SecretCodeListScreen(secretCodes = secretCodesList)
                }
            }
        }
    }
}

@Composable
fun BackgroundImage(){
    Box(modifier = Modifier.fillMaxSize() ) {
        Image(
            painter = painterResource(id = R.drawable.home_8),
            contentDescription = "null",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}