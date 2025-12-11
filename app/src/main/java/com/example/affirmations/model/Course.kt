package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course (
    @DrawableRes val imageId: Int,
    @StringRes val nameId: Int,
    val number: Int
)
