package com.example.internship_21_5_24

import android.app.Activity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun UnlockBySoftware(cards: List<UnlockTechniquesData>, navController: NavController) {
    val context = LocalContext.current
    loadInterstitialAd(context as Activity)
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