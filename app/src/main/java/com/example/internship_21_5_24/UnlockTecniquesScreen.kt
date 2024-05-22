package com.example.internship_21_5_24

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun UnlockTechniquesScreen() {

        Box(modifier= Modifier
            .padding(start = 20.dp, top = 95.dp, end = 20.dp)
            //.width(320.dp)
            //.height(76.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color(0xFFFFFFFF))

        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.group_507),
                    contentDescription =null,
                    modifier = Modifier
                        .padding(8.dp)
                        .width(54.dp)
                        .height(50.48.dp)

                    )
                Column {
                    Text(
                        text = "Unlock By Software",
                        modifier = Modifier
                            .padding(top = 4.dp, start = 4.dp)
                            .width(134.dp),
                        fontWeight = FontWeight(800),
                        fontSize = 14.sp,
                        style = TextStyle(
                            lineHeight = 13.sp
                        )
                    )
                    Text(
                        text = "In this information you will learn who to unlock the lock of mobile or device.",
                        modifier = Modifier
                            .padding(4.dp)
                            .width(209.dp),
                        fontWeight = FontWeight(400),
                        fontSize = 12.sp,
                        style = TextStyle(
                            lineHeight = 15.sp
                        )
                    )
                }
            }
        }
    }
