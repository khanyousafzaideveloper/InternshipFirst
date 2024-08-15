package com.example.internship_21_5_24

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@SuppressLint("SuspiciousIndentation", "InvalidColorHexValue")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectApp( viewModel: ProjectViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
   var navController:NavHostController= rememberNavController()
  // val currentBackStackEntry = navController.currentBackStackEntryAsState().value
  // val currentRoute = currentBackStackEntry?.destination?.route ?: ""
   val currentRoute by viewModel.currentRoute.collectAsState()
   val navBackStackEntry by navController.currentBackStackEntryAsState()
   LaunchedEffect(navBackStackEntry) {
      navBackStackEntry?.destination?.route?.let { route ->
         viewModel.setCurrentRoute(route)
      }
   }
   val activity = (LocalContext.current as? Activity)

   BackHandler {
      navController.navigate(ProjectScreens.Home.name) {
         popUpTo(0) { inclusive = true }
      }
   }

   Scaffold(
      topBar = {
         if (viewModel.showTopAppBar(currentRoute)) {
            CenterAlignedTopAppBar(
               title = {
                  Text(
                     text = viewModel.getTitleForRoute(currentRoute),
                     color = Color.White,
                     fontWeight = FontWeight(700)
                  )
               },
               colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xFF561F7F)),
               navigationIcon = {
                  IconButton(onClick = { navController.popBackStack() }) {
                     Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "icon",
                        tint = Color.White
                     )
                  }
               },
            )
         }
      }
   ) {
   contentPadding ->
      BackgroundImage()
      NavHost(
         navController = navController,
         startDestination = ProjectScreens.Start.name,
         modifier = Modifier.padding(contentPadding)
      ){
         var cards = 0
         composable(route = ProjectScreens.Start.name){
            StartScreen(onClick = { navigateTo(navController, ProjectScreens.Home) })
         }
         composable(route=ProjectScreens.Home.name){
            HomeScreenW(
               onClick1 = { navigateTo(navController, ProjectScreens.UnlockTechniques) },
               onClick2 = { navigateTo(navController, ProjectScreens.SelectBrand) },
               onClick3 = { navigateTo(navController, ProjectScreens.SimUnlockForm) },
               onClickIcloud = { navigateTo(navController, ProjectScreens.IcloudWebPage) }
            )
            BackHandler {
               if(currentRoute == ProjectScreens.Home.name){
                  activity?.finish()
               }
            }
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
               cards = UnlockBySoftwareList, navController = navController
            )
         }
         composable(route=ProjectScreens.SimUnlock.name){
            SimUnlockScreen(cards = SimUnlockList, navController)
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
         composable(
            route="UnlockBySoftware/{cardId}",
            arguments = listOf(navArgument("cardId") { type = NavType.IntType })
         ){ backStackEntry ->
               cards =  backStackEntry.arguments?.getInt("cardId") ?: 0
               Assets(cards)
         }

         composable(
            route="UnlockByTricks/{cardId}",
            arguments = listOf(navArgument("cardId") { type = NavType.IntType })
         ){ backStackEntry ->
            cards =  backStackEntry.arguments?.getInt("cardId") ?: 0
            AssetsUnlockByTricks(cards)
         }

         composable(
            route="SimUnlock/{cardId}",
            arguments = listOf(navArgument("cardId") { type = NavType.IntType })
         ){ backStackEntry ->
            cards =  backStackEntry.arguments?.getInt("cardId") ?: 0
            Assets3(cards)
         }

         composable(
            route="UnlockNetworkPhone/{cardId}",
            arguments = listOf(navArgument("cardId") { type = NavType.IntType })
         ){ backStackEntry ->
            cards =  backStackEntry.arguments?.getInt("cardId") ?: 0
            Assets4(cards)
         }

         composable(route=ProjectScreens.SimUnlockForm.name){
            SimUnlockForm()
           // loadInterstitialAd(context = context)
         }
         composable(route=ProjectScreens.UnlockWithTricks.name){
            UnlockWithTricksScreen(cards = UnlockWithTricksList, navController)
         }
         composable(route=ProjectScreens.UnlockNetworkOfYourPhone.name){
            UnlockWithTricksScreen(cards = UnlockNetworkOfYourPhoneList, navController)
         }
         composable(route=ProjectScreens.IcloudWebPage.name){
            WebPage_Icloud()
         }
      }
   }
}

private fun navigateTo(navController: NavHostController, screen: ProjectScreens) {
   navController.navigate(screen.name)
}

enum class ProjectScreens {
   Start,
   Home,
   UnlockTechniques,
   UnlockBySoftware,
   SimUnlock,
   SimUnlockForm,
   SelectBrand,
   UnlockWithTricks,
   UnlockNetworkOfYourPhone,
   IcloudWebPage,
}

//fun getTitleForRoute(route: String?): String {
//   return when (route) {
//      ProjectScreens.UnlockTechniques.name -> "Unlock Techniques"
//      ProjectScreens.UnlockBySoftware.name -> "Unlock By Software"
//      ProjectScreens.SimUnlock.name -> "SIM Unlock"
//      ProjectScreens.SimUnlockForm.name -> "IMEI Inspection"
//      ProjectScreens.UnlockWithTricks.name -> "Unlock with Tricks"
//      ProjectScreens.SelectBrand.name -> "Select Brand"
//      ProjectScreens.UnlockNetworkOfYourPhone.name -> "Unlock Network of your Phone"
//      "brand/{codes}" -> "Secrets Codes"
//      else -> ""
//   }
//}
//
//fun showTopAppBar(route: String?): Boolean {
//   return when (route) {
//      ProjectScreens.Start.name -> false
//      ProjectScreens.Home.name -> false
//      ProjectScreens.IcloudWebPage.name -> false
//      "UnlockBySoftware/{cardId}" ->false
//      "UnlockNetworkPhone/{cardId}" -> false
//      "SimUnlock/{cardId}" -> false
//      "UnlockByTricks/{cardId}" -> false
//      else -> true
//   }
//}
