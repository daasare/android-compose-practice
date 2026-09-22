package com.khaysolutions.superheroes.model

import com.khaysolutions.superheroes.R

object HeroesRepository {
    val heroes = listOf(
        Hero(
            nameRes = R.string.hero1,
            description = R.string.description1,
            imageRes = R.drawable.android_superhero1
        ),
        Hero(
            nameRes = R.string.hero2,
            description = R.string.description2,
            imageRes = R.drawable.android_superhero2
        ),
        Hero(
            nameRes = R.string.hero3,
            description = R.string.description3,
            imageRes = R.drawable.android_superhero3
        ),
        Hero(
            nameRes = R.string.hero4,
            description = R.string.description4,
            imageRes = R.drawable.android_superhero4
        ),
        Hero(
            nameRes = R.string.hero5,
            description = R.string.description5,
            imageRes = R.drawable.android_superhero5
        ),
        Hero(
            nameRes = R.string.hero6,
            description = R.string.description6,
            imageRes = R.drawable.android_superhero6
        )
    )
}