package com.example.internship_21_5_24

data class UnlockTechniquesData(
    val title: String,
    val info: String
)

val UnlockTechDataList = listOf(
    UnlockTechniquesData("Unlock By Software", "In this information you will learn who to unlock the lock of mobile or device."),
    UnlockTechniquesData("Unlock With Tricks", "In this information you will learn who to unlock the lock of mobile or device."),
    UnlockTechniquesData("SIM Unlock", "In this information you will learn who to unlock the lock of mobile or device."),
    UnlockTechniquesData("Unlock Network of your Phone", "In this information you will learn who to unlock the lock of mobile or device."),
)

val UnlockBySoftwareList = listOf(
    UnlockTechniquesData("Tool Lab UnlockGo", "In this information you will learn how to unlock the lock of mobile or device."),
    UnlockTechniquesData("Pass Fab Android Unlocker", "In this information you will learn how to unlock the lock of mobile or device."),
    UnlockTechniquesData("Android Boot loader Unlocker", "In this information you will learn how to unlock the lock of mobile or device."),
    UnlockTechniquesData("Sky Soft Toolbox for Android", "In this information you will learn how to unlock the lock of mobile or device."),
    UnlockTechniquesData("Unlock Phone", "In this information you will learn how to unlock the lock of mobile or device."),
    UnlockTechniquesData("iMyFone LockWiper", "In this information you will learn how to unlock the lock of mobile or device."),
    UnlockTechniquesData("Tenorshare 4u Key for Android", "In this information you will learn how to unlock the lock of mobile or device."),

    )

val SimUnlockList = listOf(
    UnlockTechniquesData("Android SIM Unlock", "This information you will learn how to unlock the lock of mobile device."),
    UnlockTechniquesData("Galax SIM Unlock", "This information you will learn how to unlock the lock of mobile device."),
    UnlockTechniquesData("Samsung SIM Unlock", "This information you will learn how to unlock the lock of mobile device."),
    UnlockTechniquesData("HTC SIM Unlock", "This information you will learn how to unlock the lock of mobile device."),
    UnlockTechniquesData("SIM Unlock with App", "This information you will learn how to unlock the lock of mobile device."),
)


data class BrandNames (
    val name: String
)
val brandNameList = listOf(
    BrandNames("SAMSUNG"),
    BrandNames( "REAlME"),
    BrandNames("INFINIX"),
    BrandNames("LENOVO"),
    BrandNames("BLACKBERRY"),
    BrandNames("MOTOROLA")
)