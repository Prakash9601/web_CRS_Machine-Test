package com.softland.machinetest.Screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp



@Composable
fun Space(dp: Dp?) {
    dp?.let { Modifier.height(it) }?.let { Spacer(modifier = it) }
}