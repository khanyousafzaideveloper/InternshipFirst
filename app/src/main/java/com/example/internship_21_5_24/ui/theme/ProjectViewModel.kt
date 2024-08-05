package com.example.internship_21_5_24.ui.theme

import androidx.lifecycle.ViewModel
import com.example.internship_21_5_24.ProjectScreens
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
}