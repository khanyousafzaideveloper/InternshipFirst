package com.example.internship_21_5_24

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun UnlockBySoftware(cards: List<UnlockTechniquesData>, navController: NavController) {

    val context = LocalContext.current
 //   val items by remember {
   //     mutableStateOf(cards)
  //  }
//    LazyColumn {
//        items(items, key = { it.id }) { card ->
//            UnlockTechniquesCard(card = card, onClick = {
//                navController.navigate("UnlockBySoftware/${card.id}")
//                loadInterstitialAd(context)
//                showInterstitialAd(context)
//            })
//        }
//    }
//
    loadInterstitialAd(context)
    MainList(navController = navController, path = "UnlockBySoftware", cards = cards, showAd = true)
  //  showInterstitialAd(context)
}

@Preview
@Composable
fun Preview2() {
    BackgroundImage()
    val items = UnlockBySoftwareList
    UnlockBySoftware(cards = items, navController = fakeNavController())
}