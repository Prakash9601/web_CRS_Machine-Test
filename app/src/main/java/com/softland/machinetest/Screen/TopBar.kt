package com.softland.machinetest.Screen


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.softland.machinetest.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(id = R.color.Header)),

    )
}