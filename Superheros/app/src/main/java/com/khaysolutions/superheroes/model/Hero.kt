package com.khaysolutions.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @StringRes val nameRes: Int,
    @StringRes val description: Int,
    @DrawableRes val imageRes: Int
)
