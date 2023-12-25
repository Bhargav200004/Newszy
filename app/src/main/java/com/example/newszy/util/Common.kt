package com.example.newszy.util

import android.os.Build
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun String?.formatDateString(): String {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
        val dateTime = LocalDateTime.parse(this, DateTimeFormatter.ISO_DATE_TIME)
        return dateTime.format(formatter)
    }
    return "Not Available?.."

}