package com.softland.machinetest.navigation




import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ArcRotationWithAlpha(loadingProgressBar: Boolean) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val arcColor = Blue
    val arcAngle1 by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 180F,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val arcAngle2 by infiniteTransition.animateFloat(
        initialValue = 180F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )


    val arc by infiniteTransition.animateFloat(
        initialValue =0F,
        targetValue = 90F,
        animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    AnimatedVisibility(
        visible = loadingProgressBar,
        enter = fadeIn(animationSpec = tween(2000)),
        exit = fadeOut(animationSpec = tween(2000))
    ){
        Box(
            modifier = Modifier.fillMaxSize(),
                //.background(color = Color.White),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .padding(12.dp)
                    .size(50.dp)
            ) {
                drawArc(
                    color = arcColor,
                    startAngle = arcAngle1,
                    sweepAngle = arc,
                    useCenter = false,
                    style = Stroke(width = 9f, cap = StrokeCap.Round),
                )

                drawArc(
                    color = arcColor,
                    startAngle = arcAngle2,
                    sweepAngle = arc,
                    useCenter = false,
                    style = Stroke(width = 9f, cap = StrokeCap.Round),

                    )
            }
        }
    }
}
@Preview
@Composable
fun PreviewArcRotationWithAlpha(){
    ArcRotationWithAlpha(true)
}