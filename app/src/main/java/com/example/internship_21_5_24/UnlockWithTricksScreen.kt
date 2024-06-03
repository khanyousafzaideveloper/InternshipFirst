package com.example.internship_21_5_24

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UnlockWithTricksScreen(cards: List<UnlockTechniquesData>) {
    LazyColumn {
        items(cards) { card ->
            UnlockTechniquesCard(card = card) {}
        }
    }
}

@Composable
@Preview
fun PreviewUWT(){
    UnlockWithTricksScreen(cards = UnlockWithTricksList)
}