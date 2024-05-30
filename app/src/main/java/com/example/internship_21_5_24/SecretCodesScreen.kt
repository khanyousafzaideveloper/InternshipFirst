package com.example.internship_21_5_24

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecretCodeCard(secretCodes: SecretCodes ){
    Box(modifier= Modifier
        .padding(start = 20.dp, top = 16.dp, end = 20.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .clickable { }
        .background(color = Color(0xFFFFFFFF)),
    ) {
            Column {
                Text(
                    text = secretCodes.title,
                    modifier = Modifier
                        .padding(start = 12.dp, top = 12.dp)
                        .fillMaxWidth()
                        .width(160.dp),
                    fontWeight = FontWeight(700),
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 16.sp
                    )
                )
                Text(
                    text = secretCodes.number,
                    modifier = Modifier
                        .padding(start = 12.dp, top = 12.dp)
                        .fillMaxWidth()
                        .width(40.dp),
                    fontWeight = FontWeight(500),
                    fontSize = 14.sp,
                    style = TextStyle(
                        lineHeight = 12.sp
                    )
                )
                Row(modifier= Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp, bottom = 12.dp), horizontalArrangement = Arrangement.End){

                    Image(
                        painter = painterResource(id = R.drawable.file2),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .border(width = 1.dp, color = Color(0xFF582085))
                            .height(18.dp)
                            .width(18.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .clickable {  }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.share2),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .border(width = 1.dp, color = Color(0xFF582085))
                            .height(18.dp)
                            .width(18.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .clickable {  }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.call2),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .border(width = 1.dp, color = Color(0xFF582085))
                            .height(18.dp)
                            .width(18.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .clickable {  }
                    )

                }
            }
    }
}
@Composable
fun SecretCodeListScreen(secretCodes: List<SecretCodes>) {
    LazyColumn(
    ) {
        items(secretCodes) { secret ->
            SecretCodeCard(secret)
        }
    }
}



@Preview
//@Preview(showBackground = true, name = "Small Phone", widthDp = 320, heightDp = 480)
//@Preview(showBackground = true, name = "Normal Phone", widthDp = 360, heightDp = 640)
//@Preview(showBackground = true, name = "Large Phone", widthDp = 400, heightDp = 800)
//@Preview(showBackground = true, name = "Extra Large Phone", widthDp = 480, heightDp = 853)
//@Preview(showBackground = true, name = "Large Tablet", widthDp = 800, heightDp = 1280)
//@Preview(showBackground = true, name = "Full HD TV", widthDp = 1920, heightDp = 1080)
//@Preview(showBackground = true, name = "Normal Phone", widthDp = 360, heightDp = 640)
@Composable
fun SecretCodesPreview(){
    BackgroundImage()
    SecretCodeListScreen(secretCodes = secretCodesList_Samsung)
}
