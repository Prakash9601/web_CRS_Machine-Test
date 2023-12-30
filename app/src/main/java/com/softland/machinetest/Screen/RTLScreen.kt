package com.softland.machinetest.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(device = Devices.NEXUS_6P, showSystemUi = true)
@Composable
fun RTLScreen() {
    MaterialTheme {
        Surface {
            Column(horizontalAlignment = Alignment.End) {
                SimpleButton(
                    text = "RTL Friendly",
                    shape = CutCornerShape(
                        topStartPercent = 50,
                        bottomStartPercent = 50
                    ),
                )

                SimpleButton(
                    text = "RTL Friendly",
                    shape = RoundedCornerShape(
                        topStartPercent = 50,
                        bottomStartPercent = 50
                    ),
                )

                SimpleButton(
                    text = "Absolute",
                    shape = AbsoluteCutCornerShape(
                        topLeftPercent = 50,
                        bottomLeftPercent = 50
                    )
                )

                SimpleButton(
                    text = "Absolute",
                    shape = AbsoluteRoundedCornerShape(
                        topLeftPercent = 50,
                        bottomLeftPercent = 50
                    )
                )
            }
        }
    }
}

@Composable
fun SimpleButton(text: String, shape: Shape) {
    Surface(
        shape = shape,
        color = Color.LightGray,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(
                start = 24.dp,
                end = 8.dp,
                top = 6.dp,
                bottom = 6.dp
            ),
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}