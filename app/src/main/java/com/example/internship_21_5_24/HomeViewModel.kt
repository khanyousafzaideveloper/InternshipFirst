package com.example.internship_21_5_24

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel:ViewModel() {

    fun moreApps(context: Context){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://play.google.com/store/apps/developer?id=FA+Apps+Mania&hl=en")
        context.startActivity(intent)
    }

    fun shareApp(context: Context){
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT,"Hey check out my app at: https://play.google.com/store/apps/details?id=com.faappsmania.checkimiedevice")
        }
        context.startActivity(intent)
    }


    fun shareEMEICode(context: Context, code:String, detail:String){
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT,"Code: $code\nDetail: $detail")
        }

        context.startActivity(intent)
    }
    fun shareEMEICodeToCall(context: Context, code:String){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$code")
        context.startActivity(intent)
    }
//    fun shareIMEI(context: Context, email: String, fname:String, lname:String, feedBack:String){
//        val intent = Intent(Intent.ACTION_SEND).apply {
//            type = "text/plain"
//            putExtra(Intent.EXTRA_TEXT, "Email: $email\nFirst Name: $fname\nLast Name: $lname\nFeed back: $feedBack")
//        }
//        context.startActivity(intent)
//    }
}