package com.example.internship_21_5_24

data class UnlockTechniquesData(
    val title: String,
    val info: String,
    val id: Int
)

val UnlockTechDataList = listOf(
    UnlockTechniquesData("Unlock By Software", "In this information you will learn who to unlock the lock of mobile or device.", 1),
    UnlockTechniquesData("Unlock With Tricks", "In this information you will learn who to unlock the lock of mobile or device.",2),
    UnlockTechniquesData("SIM Unlock", "In this information you will learn who to unlock the lock of mobile or device.",3),
    UnlockTechniquesData("Unlock Network of your Phone", "In this information you will learn who to unlock the lock of mobile or device.",4),
)

val UnlockBySoftwareList = listOf(
    UnlockTechniquesData("Tool Lab UnlockGo", "In this information you will learn how to unlock the lock of mobile or device.",1),
    UnlockTechniquesData("Pass Fab Android Unlocker", "In this information you will learn how to unlock the lock of mobile or device.",2),
    UnlockTechniquesData("Android Boot loader Unlocker", "In this information you will learn how to unlock the lock of mobile or device.",3),
    UnlockTechniquesData("Sky Soft Toolbox for Android", "In this information you will learn how to unlock the lock of mobile or device.",4),
    UnlockTechniquesData("Unlock Phone", "In this information you will learn how to unlock the lock of mobile or device.",5),
    UnlockTechniquesData("iMyFone LockWiper", "In this information you will learn how to unlock the lock of mobile or device.",6),
    UnlockTechniquesData("Tenorshare 4u Key for Android", "In this information you will learn how to unlock the lock of mobile or device.",7),

    )

val SimUnlockList = listOf(
    UnlockTechniquesData("Android SIM Unlock", "This information you will learn how to unlock the lock of mobile device.",1),
    UnlockTechniquesData("Galax SIM Unlock", "This information you will learn how to unlock the lock of mobile device.",2),
    UnlockTechniquesData("Samsung SIM Unlock", "This information you will learn how to unlock the lock of mobile device.",3),
    UnlockTechniquesData("HTC SIM Unlock", "This information you will learn how to unlock the lock of mobile device.",4),
    UnlockTechniquesData("SIM Unlock with App", "This information you will learn how to unlock the lock of mobile device.",5),
)

val UnlockWithTricksList = listOf(
    UnlockTechniquesData("Unlock a Verizon Phone", "In this information you will learn how to unlock the lock of mobile device.",1),
    UnlockTechniquesData("Unlock Kitkat and Early Version", "In this information you will learn how to unlock the lock of mobile device.",1),
    UnlockTechniquesData("Boot into a Safe Mode to bypass Third-Party Lock Screen", "In this information you will learn how to unlock the lock of mobile device.",2),
    UnlockTechniquesData("Crash the Lock Screen UI", "In this information you will learn how to unlock the lock of mobile device.",3),
    UnlockTechniquesData("Factory Reset", "In this information you will learn how to unlock the lock of mobile device.",4),

)

val UnlockNetworkOfYourPhoneList = listOf(
    UnlockTechniquesData("Android Sim Unlock Software", "In this information you will learn how to unlock the lock of mobile device.", 1),
    UnlockTechniquesData("Galaxy Sim Unlock App", "In this information you will learn how to unlock the lock of mobile device.", 2),
    UnlockTechniquesData("Unlock You Phone Fast and Secure", "In this information you will learn how to unlock the lock of mobile device.", 3),
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

data class SecretCodes(
    val title: String,
    val number: String
)

val secretCodesList_Samsung= listOf(
    SecretCodes("Display IMEI Number","*#06#"),
    SecretCodes("General Test Mode","*#0*#"),
    SecretCodes("Software & WH Info","*#12580*369#"),
    SecretCodes("Bluetooth Address Info","*#232337#"),
    SecretCodes("Proximity Sensor Test Mode","*#0588#"),
    SecretCodes("Data Create Menu","*#273283*255*3282*#"),
    SecretCodes("Software Version Info","*#44336#"),
    )


