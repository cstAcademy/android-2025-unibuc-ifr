package com.cst.unibucifr2025.utils.extensions

import android.util.Log

fun String.logErrorMessage(tag: String = "TAG") {
    Log.e(tag, this)
}
