package com.bosch

import android.os.Build

actual fun platformName(): String {
    return "${Build.VERSION.RELEASE}"
}