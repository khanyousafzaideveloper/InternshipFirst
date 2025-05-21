package com.example.internship_21_5_24

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.phone_imei.MyNativeAds
import com.facebook.ads.NativeAdLayout

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimUnlockForm(navController: NavController) {
    val context = LocalContext.current
    val activity = remember(context) { context as? Activity }

    // Declare state variables for the TextFields
//    var txtF1 by remember { mutableStateOf("") }
//    var txtF2 by remember { mutableStateOf("") }
//    var txtF3 by remember { mutableStateOf("") }
//    var txtF4 by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(10f)
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "IMEI Inspection",
                modifier = Modifier.padding(top = 16.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFF7F7F7)
                )
            )
            Text(
                text = "Feel free so please Send us your phone IMEI and your issues.",
                modifier = Modifier.padding(vertical = 16.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFF7F7F7)
                ),
                maxLines = 1
            )

            // Use the optimized CustomTextField
            CustomTextField(label = "Your Email")
            CustomTextField(label = "First Name")
            CustomTextField(label = "Last Name")
            CustomTextField(
                label = "Your Feedback",
                maxLines = 2, // Pass maxLines to the composable
                modifier = Modifier.height(91.dp)
            )
            Button(
                onClick = { navController.navigate(ProjectScreens.Success.name) },
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(
                    text = "Submit",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF561F82)
                    )
                )
            }
        }
        AdView(modifier = Modifier.weight(4f), context = LocalContext.current, activity = remember { context as? Activity })
    }
}

@Composable
fun AdView(modifier: Modifier, context: Context, activity: Activity?) {
    val nativeAdLayout = remember { NativeAdLayout(context) }
    AndroidView(
        factory = { nativeAdLayout },
        modifier.fillMaxWidth()
    ) {
        activity?.let {
            val myNativeAds = MyNativeAds(activity)
            myNativeAds.loadNativeAd(
                nativeAdLayout = nativeAdLayout,
                isCustomLayout = true,
                placementId = "937716378294152_937717458294044"
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    label: String,
    maxLines: Int = 1,
    modifier: Modifier = Modifier
) {
    var value by remember { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = {value = it},
        label = { Text(text = label, color = Color.Black) },
        colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        maxLines = maxLines,
        shape = RoundedCornerShape(6.dp),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
    )
}
