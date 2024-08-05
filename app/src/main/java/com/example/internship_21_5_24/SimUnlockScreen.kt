package com.example.internship_21_5_24

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun SimUnlockScreen(cards: List<UnlockTechniquesData>, navController: NavController) {

//    val rememberedCards by remember { mutableStateOf(cards) }
//    LazyColumn{
//        items(rememberedCards, key = { it.id }) { card ->
//            UnlockTechniquesCard(card = card, onClick = {navController.navigate("SimUnlock/${card.id}")})
//        }
//    }
    MainList(navController = navController, path = "SimUnlock", cards = cards, showAd = false)
}


@Preview
@Composable
fun SmallPhonePreview_UnlockTech() {
    BackgroundImage()
    SimUnlockScreen(cards = SimUnlockList, navController = fakeNavController())
}

