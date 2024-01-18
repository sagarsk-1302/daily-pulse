package com.example.dailypulse

import kotlinx.coroutines.CoroutineScope

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect open class BaseViewModel() {
    val scope: CoroutineScope
}