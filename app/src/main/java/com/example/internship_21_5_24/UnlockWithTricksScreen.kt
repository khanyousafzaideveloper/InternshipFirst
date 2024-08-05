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
fun UnlockWithTricksScreen(cards: List<UnlockTechniquesData>, navController: NavController) {
//    val items by remember {
//        mutableStateOf(cards)
//    }
//    LazyColumn {
//        items(items, key = { it.id }) { card ->
//            UnlockTechniquesCard(card = card, onClick = {navController.navigate("UnlockByTricks/${card.id}")})
//        }
//    }
    MainList(navController = navController, path ="UnlockByTricks" , cards = cards, showAd = false)
}

@Composable
@Preview
fun PreviewUWT(){
    UnlockWithTricksScreen(cards = UnlockWithTricksList, navController = fakeNavController())
}