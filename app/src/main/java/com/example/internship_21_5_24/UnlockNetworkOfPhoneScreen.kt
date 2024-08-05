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
fun UnlockNetworkOfYourPhone(cards: List<UnlockTechniquesData>, navController: NavController){
//    val items by remember {
//        mutableStateOf(cards)
//    }
//    LazyColumn{
//        items(items, key = { it.id }) { card ->
//            UnlockTechniquesCard(card = card, onClick = {navController.navigate("UnlockNetworkPhone/${card.id}\"")})
//        }
//    }
    MainList(navController = navController, path = "UnlockNetworkPhone", cards = cards, showAd = false)
}

@Preview
@Composable
fun PreviewNetworkOf(){
    UnlockNetworkOfYourPhone(cards = UnlockNetworkOfYourPhoneList, navController = fakeNavController())
}