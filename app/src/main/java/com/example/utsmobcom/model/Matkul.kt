package com.example.utsmobcom.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes


data class Matkul(
    @StringRes val matkul: Int,
    @StringRes val sks: Int,
    @DrawableRes val image: Int
)
