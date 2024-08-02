package com.example.internship_21_5_24

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@SuppressLint("SuspiciousIndentation", "SetJavaScriptEnabled")
@Composable
fun UnlockTechniquesCard(card: UnlockTechniquesData, onClick: (UnlockTechniquesData) -> Unit) {

    val fontRaleway = FontFamily(
        Font(R.font.raleway_bold, FontWeight.Normal)
    )
    val fontRoboto = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal)
    )
        Box(modifier = Modifier
            .padding(start = 20.dp, top = 16.dp, end = 20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onClick(card)
            }
            .background(color = Color(0xFFFFFFFF))

        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.group_507),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .width(54.dp)
                        .height(50.48.dp)

                )
                Column {
                    Text(
                        text = card.title,
                        modifier = Modifier
                            .padding(top = 4.dp, start = 8.dp),
                        fontWeight = FontWeight(800),
                        fontFamily = fontRaleway,
                        fontSize = 14.sp,
                        style = TextStyle(
                            lineHeight = 13.sp
                        )
                    )
                    Text(
                        text = card.info,
                        modifier = Modifier
                            .padding(start = 8.dp, top = 4.dp, bottom = 4.dp, end = 20.dp),
                        //  .width(209.dp)
                        fontWeight = FontWeight(400),
                        fontFamily = fontRoboto,
                        fontSize = 12.sp,
                        style = TextStyle(
                            lineHeight = 15.sp
                        )
                    )
                }
            }
        }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun UnlockTechListScreen(cards: List<UnlockTechniquesData>, onClick: (UnlockTechniquesData) -> Unit) {

    val context = LocalContext.current
        LazyColumn {
            items(cards) { card ->
                loadInterstitialAd(context)
                UnlockTechniquesCard(card = card, onClick = onClick)
            }
        }
}


@Preview
@Composable
fun UnlockTechniquesPreview() {
    BackgroundImage()
    UnlockTechListScreen(UnlockTechDataList, onClick = {})
}
