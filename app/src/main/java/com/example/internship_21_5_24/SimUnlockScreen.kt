package com.example.internship_21_5_24

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SimUnlockScreen(cards: List<UnlockTechniquesData>) {
    LazyColumn() {
        items(cards) { card ->
            UnlockTechniquesCard(card = card)
        }
    }
}


//@Preview(showBackground = true, name = "Small Phone", widthDp = 320, heightDp = 480)
//@Composable
//fun SmallPhonePreview_UnlockTech() {
//    BackgroundImage()
//    UnlockTechListScreen(cards = SimUnlockList)
//}
//
//@Preview(showBackground = true, name = "Normal Phone", widthDp = 360, heightDp = 640)
//@Composable
//fun NormalPhonePreview_UnlockTech() {
//    BackgroundImage()
//    UnlockTechListScreen(cards = SimUnlockList)
//}
//
//@Preview(showBackground = true, name = "Large Phone", widthDp = 400, heightDp = 800)
//@Composable
//fun LargePhonePreview_UnlockTech() {
//    BackgroundImage()
//    UnlockTechListScreen(cards = SimUnlockList)
//}
//
//@Preview(showBackground = true, name = "Extra Large Phone", widthDp = 480, heightDp = 853)
//@Composable
//fun ExtraLargePhonePreview_UnlockTech() {
//    BackgroundImage()
//    UnlockTechListScreen(cards = SimUnlockList)
//}
//
//@Preview(showBackground = true, name = "Large Tablet", widthDp = 800, heightDp = 1280)
//@Composable
//fun LargeTabletPreview_UnlockTech() {
//    BackgroundImage()
//    UnlockTechListScreen(cards = SimUnlockList)
//}
//
//@Preview(showBackground = true, name = "Full HD TV", widthDp = 1920, heightDp = 1080)
//@Composable
//fun FullHdTvPreview_UnlockTech() {
//    BackgroundImage()
//    UnlockTechListScreen(cards = SimUnlockList)
//}
