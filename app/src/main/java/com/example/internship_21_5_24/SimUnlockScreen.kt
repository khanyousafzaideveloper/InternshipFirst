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
//@Preview(showBackground = true, name = "Small Phone", widthDp = 320, heightDp = 480)
//@Preview(showBackground = true, name = "Normal Phone", widthDp = 360, heightDp = 640)
//@Preview(showBackground = true, name = "Large Phone", widthDp = 400, heightDp = 800)
//@Preview(showBackground = true, name = "Extra Large Phone", widthDp = 480, heightDp = 853)
//@Preview(showBackground = true, name = "Large Tablet", widthDp = 800, heightDp = 1280)
//@Preview(showBackground = true, name = "Full HD TV", widthDp = 1920, heightDp = 1080)
@Composable
fun SmallPhonePreview_UnlockTech() {
    BackgroundImage()
    SimUnlockScreen(cards = SimUnlockList, navController = fakeNavController())
}

