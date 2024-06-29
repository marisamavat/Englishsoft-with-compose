package com.example.englishsoft

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItemstate(
    val title: String,
    val selectedicon: ImageVector,
    val unselectedicon: ImageVector,
    val hasbage: Boolean,
    val badgenumber: Int

)
