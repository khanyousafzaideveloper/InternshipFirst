package com.example.internship_21_5_24

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectApp(
   navController: NavHostController = rememberNavController()
){
   Scaffold(
      topBar ={}
   ) {
   contentPadding ->
      BackgroundImage()
      NavHost(
         navController = navController,
         startDestination = ProjectScreens.Home.name,
         modifier = Modifier.padding(contentPadding)
      ){
         composable(route=ProjectScreens.Home.name){
            HomeScreen(
               onClick1 = { navigateTo(navController, ProjectScreens.UnlockTechniques) },
               onClick2 = { navigateTo(navController, ProjectScreens.SelectBrand) },
               onClick3 = { navigateTo(navController, ProjectScreens.SimUnlockForm) },
               onClickIcloud = { navigateTo(navController, ProjectScreens.IcloudWebPage) }
            )
         }
         composable(route=ProjectScreens.UnlockTechniques.name){
            UnlockTechListScreen(cards = UnlockTechDataList, onClick = {
               box ->
                 when(box.id){
                    1 -> navigateTo(navController, ProjectScreens.UnlockBySoftware)
                    2 -> navigateTo(navController, ProjectScreens.UnlockWithTricks)
                    3 -> navigateTo(navController, ProjectScreens.SimUnlock)
                    4 -> navigateTo(navController, ProjectScreens.UnlockNetworkOfYourPhone)
                 }
               }
            )
         }
         composable(route=ProjectScreens.UnlockBySoftware.name){
            UnlockBySoftware(
               cards = UnlockBySoftwareList, onClick = {
                  card ->
                  when(card.id){
                     1 -> navigateTo(navController, ProjectScreens.AssetScreen)
                  }
               }
            )
         }
         composable(route=ProjectScreens.SimUnlock.name){
            SimUnlockScreen(cards = SimUnlockList)
         }
         composable(route=ProjectScreens.SelectBrand.name){
            SelectBrandListScreen(
               brands = brandNamesEnum.values().toList(),
               navController = navController
            )
         }
         composable(route="brand/{codes}"){backStackEntry ->
            val codes =  backStackEntry.arguments?.getString("codes")
            if (codes != null) {
               SecretCodeListScreen(selectedBrand = codes)
            }
         }
//         composable(route="UnlockBySoftware{cardes}"){backStackEntry ->
//            val cards =  backStackEntry.arguments?.getString("cards")
//            if (cards != null) {
//               Assets(cards)
//            }
//         }
         composable(route=ProjectScreens.SimUnlockForm.name){
            SimUnlockForm()
         }
         composable(route=ProjectScreens.UnlockWithTricks.name){
            UnlockWithTricksScreen(cards = UnlockWithTricksList)
         }
         composable(route=ProjectScreens.UnlockNetworkOfYourPhone.name){
            UnlockWithTricksScreen(cards = UnlockNetworkOfYourPhoneList)
         }
         composable(route=ProjectScreens.IcloudWebPage.name){
            WebPage_Icloud()
         }
         composable(route = ProjectScreens.AssetScreen.name){
            Assets()
         }
      }
   }
}

private fun navigateTo(navController: NavHostController, screen: ProjectScreens) {
   navController.navigate(screen.name)
}

enum class ProjectScreens() {
   Home,
   UnlockTechniques,
   UnlockBySoftware,
   SimUnlock,
   SimUnlockForm,
   SelectBrand,
   SecretCodes,
   UnlockWithTricks,
   UnlockNetworkOfYourPhone,
   IcloudWebPage,
   AssetScreen
}