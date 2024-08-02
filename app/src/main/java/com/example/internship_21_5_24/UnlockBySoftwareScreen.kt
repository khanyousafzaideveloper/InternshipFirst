package com.example.internship_21_5_24

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun UnlockBySoftware(cards: List<UnlockTechniquesData>, navController: NavController) {

    val context = LocalContext.current
    LazyColumn() {
        items(cards) { card ->
            UnlockTechniquesCard(card = card, onClick = {
                navController.navigate("UnlockBySoftware/${card.id}")
                loadInterstitialAd(context)
                showInterstitialAd(context)
            })
        }

    }
}

@Preview
@Composable
fun Preview2() {
    BackgroundImage()
    val items = UnlockBySoftwareList
    UnlockBySoftware(cards = items, navController = fakeNavController())
}