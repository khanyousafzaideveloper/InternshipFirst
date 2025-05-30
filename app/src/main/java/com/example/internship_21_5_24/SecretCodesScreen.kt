package com.example.internship_21_5_24

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
        .background(color = Color(0xFFFFFFFF)),
    ) {
        Column {
            Text(
                text = secretCodes.title,
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp)
                    .fillMaxWidth(),
                fontWeight = FontWeight(700),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = secretCodes.number,
                modifier = Modifier
                    .padding(start = 12.dp, top = 12.dp)
                    .fillMaxWidth(),
                fontWeight = FontWeight(500),
                style = MaterialTheme.typography.bodyMedium

            )
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(end = 12.dp, bottom = 12.dp), horizontalArrangement = Arrangement.End){

                IconButton(
                    iconResId = R.drawable.file2,
                    onClick = { clipboardManager.setText(AnnotatedString(secretCodes.number)) }
                )
                IconButton(
                    iconResId = R.drawable.share2,
                    onClick = { viewModel.shareEMEICode(context, secretCodes.number, secretCodes.title) }
                )

                IconButton(
                    iconResId = R.drawable.group_307,
                    onClick = { viewModel.shareEMEICodeToCall(context, secretCodes.number) }
                )

            }
        }
    }
}
@Composable
fun IconButton(iconResId: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = iconResId),
        contentDescription = null,
        modifier = Modifier
            .padding(end = 8.dp)
            .size(24.dp)
            .clip(RoundedCornerShape(4.dp))
            .clickable { onClick() }
    )
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
    LazyColumn(userScrollEnabled = true){
        items(secretCodes) { secret ->
            secret?.let {
                SecretCodeCard(it)
            }
        }
    }
}



@Preview
@Composable
fun SecretCodesPreview(){
    BackgroundImage()
    SecretCodeListScreen(selectedBrand = "SAMSUNG")
}
