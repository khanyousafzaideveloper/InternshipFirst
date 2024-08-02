package com.example.internship_21_5_24

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun SimUnlockScreen(cards: List<UnlockTechniquesData>, navController: NavController) {
    LazyColumn() {
        items(cards) { card ->
            UnlockTechniquesCard(card = card, onClick = {navController.navigate("SimUnlock/${card.id}")})
        }
    }
}


@Preview
@Composable
fun SmallPhonePreview_UnlockTech() {
    BackgroundImage()
    SimUnlockScreen(cards = SimUnlockList, navController = fakeNavController())
}

