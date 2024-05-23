package com.example.internship_21_5_24

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun SelectBrandScreen(brand: BrandNames){
    Box(modifier= Modifier
        .padding(start = 20.dp, top = 16.dp, end = 20.dp)
        //.width(320.dp)
        //.height(76.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .clickable {  }
        .background(color = Color(0xFFFFFFFF)),
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.group_507),
                contentDescription =null,
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                    .width(54.dp)
                    .height(50.48.dp)

            )
           // Box(modifier= Modifier.fillMaxWidth() .align(Alignment.CenterVertically)) {
                Text(
                    text = brand.name,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        //.height(18.dp)
                        .fillMaxWidth()

                        .width(90.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(600),
                    fontSize = 18.sp,
                    style = TextStyle(
                        lineHeight = 18.sp
                    ),
                )
            }
    }

}

@Composable
fun SelectBrandListScreen(brands: List<BrandNames>) {
    LazyColumn(
        // contentPadding = PaddingValues(0.dp),
        // verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(brands) { brand ->
            SelectBrandScreen(brand)
        }
    }
}


@Preview
@Composable
fun PreviewSelectBrand(){
    BackgroundImage()

    SelectBrandListScreen(brands = brandNameList)
}