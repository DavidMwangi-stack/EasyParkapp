package com.david.easypark.ui.theme.screens.about

import androidx.annotation.DrawableRes
import com.david.easypark.R

data class Page(
    val  title: String,
    val description: String,
    @DrawableRes val image :Int
)

val pages = listOf(
    Page(
        title = "Why EasyPark?",
        description = "Its fast, reliable and saves you time.",
        image = R.drawable.onboarding3
    ),
    Page(
        title = "Your security is guaranteed!",
        description = "Worry-no-more of car theft, our surveillance's are 24/7.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Start parking with us Today!",
        description = "",
        image = R.drawable.onboarding1
    ),
)