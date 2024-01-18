package com.example.dailypulse


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Platform{
    actual val osName: String
        get() = "IOS"
    actual val osVersion: String
        get() = TODO("Not yet implemented")
    actual val deviceModel: String
        get() = TODO("Not yet implemented")
    actual val density: Int
        get() = TODO("Not yet implemented")

    actual fun logSystemInfo() {
    }

}