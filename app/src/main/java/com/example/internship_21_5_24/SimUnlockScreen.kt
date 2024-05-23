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

@Preview
@Composable
fun Preview3(){
    BackgroundImage()
    UnlockTechListScreen(cards = SimUnlockList)
}