package com.example.internship_21_5_24

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@SuppressLint("SuspiciousIndentation")
@Composable
fun MainList(navController:NavController, path:String, cards: List<UnlockTechniquesData>, showAd:Boolean){
    val items by remember {
        mutableStateOf(cards)
    }
    val context = LocalContext.current

    LazyColumn {
        items(items, key = { it.id }) { card ->
            UnlockTechniquesCard(card = card, onClick = {
                if(showAd){
                    if(adIsReady)
                    showInterstitialAd(context)
                }
                navController.navigate("${path}/${card.id}")
            })
        }
    }
}

@Composable
fun MainListTwo(cards: List<UnlockTechniquesData>, onClick: (UnlockTechniquesData) -> Unit){

    val items by remember {
        mutableStateOf(cards)
    }
    LazyColumn {
        items(items, key = { it.id }) { card ->
            UnlockTechniquesCard(card = card, onClick = onClick)
        }
    }
}