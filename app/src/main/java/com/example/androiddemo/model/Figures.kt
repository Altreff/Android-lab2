package com.example.androiddemo.model

import android.icu.text.IDNA
import java.util.UUID

data class Figures(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val title: String,
    val info: Info
) {
    data class Info(
    val born: String,
    val died: String,
    val father: String,
    val mother: String
    )
}



