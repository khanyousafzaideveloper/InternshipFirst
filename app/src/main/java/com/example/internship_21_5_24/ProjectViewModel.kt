package com.example.internship_21_5_24

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProjectViewModel: ViewModel() {
    private val _currentRoute = MutableStateFlow<String?>(null)
    val currentRoute: StateFlow<String?> = _currentRoute

    fun setCurrentRoute(route: String?) {
        _currentRoute.value = route
    }

    fun getTitleForRoute(route: String?): String {
        return when (route) {
            ProjectScreens.UnlockTechniques.name -> "Unlock Techniques"
            ProjectScreens.UnlockBySoftware.name -> "Unlock By Software"
            ProjectScreens.SimUnlock.name -> "SIM Unlock"
            ProjectScreens.SimUnlockForm.name -> "IMEI Inspection"
            ProjectScreens.UnlockWithTricks.name -> "Unlock with Tricks"
            ProjectScreens.SelectBrand.name -> "Select Brand"
            ProjectScreens.UnlockNetworkOfYourPhone.name -> "Unlock Network of your Phone"
            "brand/{codes}" -> "Secrets Codes"
            else -> ""
        }
    }

    fun showTopAppBar(route: String?): Boolean {
        return when (route) {
            ProjectScreens.Start.name -> false
            ProjectScreens.Home.name -> false
            ProjectScreens.IcloudWebPage.name -> false
            "UnlockBySoftware/{cardId}" -> false
            "UnlockNetworkPhone/{cardId}" -> false
            "SimUnlock/{cardId}" -> false
            "UnlockByTricks/{cardId}" -> false
            else -> true
        }
    }

    val fontRaleway = FontFamily(
        Font(R.font.raleway_bold, FontWeight.Normal)
    )
    val fontRoboto = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Normal)
    )
}