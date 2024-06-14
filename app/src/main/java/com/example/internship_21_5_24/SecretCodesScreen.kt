package com.example.internship_21_5_24

import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SecretCodeCard(secretCodes: SecretCodes ){
    val clipboardManager: androidx.compose.ui.platform.ClipboardManager = LocalClipboardManager.current
    val context: Context = LocalContext.current
    val viewModel:HomeViewModel = viewModel()
    Box(modifier= Modifier
        .padding(start = 20.dp, top = 16.dp, end = 20.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .clickable { }
        .background(color = Color(0xFFFFFFFF)),
    ) {
            Column {
                Text(
                    text = secretCodes.title,
                    modifier = Modifier
                        .padding(start = 12.dp, top = 12.dp)
                        .fillMaxWidth()
                        .width(160.dp),
                    fontWeight = FontWeight(700),
                    fontSize = 16.sp,
                    style = TextStyle(
                        lineHeight = 16.sp
                    )
                )
                Text(
                    text = secretCodes.number,
                    modifier = Modifier
                        .padding(start = 12.dp, top = 12.dp)
                        .fillMaxWidth()
                        .width(40.dp),
                    fontWeight = FontWeight(500),
                    fontSize = 14.sp,
                    style = TextStyle(
                        lineHeight = 12.sp
                    )
                )
                Row(modifier= Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp, bottom = 12.dp), horizontalArrangement = Arrangement.End){

                    Image(
                        painter = painterResource(id = R.drawable.file2),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .border(width = 1.dp, color = Color(0xFF582085))
                            .height(18.dp)
                            .width(18.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .clickable { clipboardManager.setText(AnnotatedString(secretCodes.number)) }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.share2),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .border(width = 1.dp, color = Color(0xFF582085))
                            .height(18.dp)
                            .width(18.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .clickable { viewModel.shareEMEICode(context, secretCodes.number, secretCodes.title) }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.group_307),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .border(width = 1.dp, color = Color(0xFF582085))
                            .height(18.dp)
                            .width(18.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .clickable { viewModel.shareEMEICodeToCall(context, secretCodes.number)}
                    )

                }
            }
    }
}
@Composable
fun SecretCodeListScreen( selectedBrand: String) {

    val secretCodes = remember {
        when (selectedBrand) {
            brandNamesEnum.SAMSUNG.toString() -> secretCodesList_Samsung
            brandNamesEnum.RealMe.toString() -> secretCodes_realme
            brandNamesEnum.HTC.toString() -> secretCodesList_HTC
            brandNamesEnum.LENOVO.toString() -> secretCodesList_Lenovo
            brandNamesEnum.SONY.toString() -> secretCodesList_sony
            brandNamesEnum.INFINIX.toString() -> secretCodesList_infinix
            brandNamesEnum.MOTOROLA.toString() -> secretCodesList_motorola
            brandNamesEnum.BLACKBERRY.toString() -> secretCodesList_blackberry
            brandNamesEnum.LG.toString() -> secretCodesList_lg
            brandNamesEnum.XIAOMI.toString() -> secretCodesList_xiaomi
            brandNamesEnum.OPPO.toString() -> secretCodes_oppo
            brandNamesEnum.QMOBILE.toString()-> secretCodesList_qmobile
            brandNamesEnum.CHINA.toString()-> secretCodesList_china
            brandNamesEnum.GENERIC.toString()-> secretCodesList_Generic
            brandNamesEnum.MICROSOFTWINDOW.toString()-> secretCodesList_microsoft_windows
            brandNamesEnum.VIVO.toString()-> secretCodesList_vivo
            brandNamesEnum.ACER.toString()-> secretCodesList_acer
            brandNamesEnum.NOKIA.toString()-> secretCodesList_nokia
            brandNamesEnum.Tecno.toString()-> secretCodeList_techno
            brandNamesEnum.ASUS.toString()-> secretCodesList_asus
            brandNamesEnum.Honor.toString()-> secretCodesList_honor
            brandNamesEnum.HUAWEI.toString() -> secretCodesList_Huawei
            brandNamesEnum.IPHONE.toString()-> secretCodesList_iphone
            brandNamesEnum.ZTE.toString()-> secretCodes_zte
            brandNamesEnum.OnePlus.toString()-> secretCodes_oneplus
            brandNamesEnum.Plam.toString()-> secretCodesList_plam
            brandNamesEnum.AMOL.toString()-> secretCodes_amol
            brandNamesEnum.BQ.toString()-> secretCodesList_bq
            brandNamesEnum.IMobile.toString()-> secretCodes_imobile
            brandNamesEnum.LEECO.toString()-> secretCodesList_leeco

            else -> emptyList()
        }
    }
    LazyColumn{
        items(secretCodes) { secret ->
            secret?.let {
                SecretCodeCard(it)
            }
        }
    }
}



@Preview
//@Preview(showBackground = true, name = "Small Phone", widthDp = 320, heightDp = 480)
//@Preview(showBackground = true, name = "Normal Phone", widthDp = 360, heightDp = 640)
//@Preview(showBackground = true, name = "Large Phone", widthDp = 400, heightDp = 800)
//@Preview(showBackground = true, name = "Extra Large Phone", widthDp = 480, heightDp = 853)
//@Preview(showBackground = true, name = "Large Tablet", widthDp = 800, heightDp = 1280)
//@Preview(showBackground = true, name = "Full HD TV", widthDp = 1920, heightDp = 1080)
//@Preview(showBackground = true, name = "Normal Phone", widthDp = 360, heightDp = 640)
@Composable
fun SecretCodesPreview(){
    BackgroundImage()
    SecretCodeListScreen(selectedBrand = "SAMSUNG")
}
