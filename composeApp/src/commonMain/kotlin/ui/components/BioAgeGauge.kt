package ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import org.jetbrains.compose.resources.painterResource
import viaclara.composeapp.generated.resources.Res
import viaclara.composeapp.generated.resources.guage

@Composable
fun BioAgeGauge(
    age: Int,
    leftProgress: Float,   // 0f..1f
    rightProgress: Float   // 0f..1f
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(300.dp).fillMaxSize(),
    ) {
        Box(
            modifier = Modifier.size(300.dp)
        ) {
            Image(
                painterResource(Res.drawable.guage),
                "background",
                modifier = Modifier.fillMaxSize()
            )
            Canvas(
                modifier = Modifier.fillMaxSize()) {
                val strokeWidth = 28.dp.toPx()
                val radius = size.minDimension / 2.6
                val topLeft = Offset(
                    ((size.width - radius * 2) / 2).toFloat(),
                    ((size.height - radius * 2) / 2).toFloat()
                )

                drawArc(
                    brush = Brush.linearGradient(
                        listOf(Color(0xFFFF4815), Color(0xFFFF6804))
                    ),
                    startAngle = 135f,
                    sweepAngle = 270f * leftProgress,
                    useCenter = false,
                    style = Stroke(strokeWidth, cap = StrokeCap.Round),
                    size = Size((radius * 2).toFloat(), (radius * 2).toFloat()),
                    topLeft = topLeft
                )

                drawArc(
                    brush = Brush.linearGradient(
                        listOf(Color(0xFF4CAF50), Color(0xFF8BC34A))
                    ),
                    startAngle = 135f + 270f * (1 - rightProgress),
                    sweepAngle = 270f * rightProgress,
                    useCenter = false,
                    style = Stroke(strokeWidth, cap = StrokeCap.Round),
                    size = Size((radius * 2).toFloat(), (radius * 2).toFloat()),
                    topLeft = topLeft
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
                Text(
                    text = age.toString(),
                    fontSize = 52.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text("Years old", fontSize = 15.sp, color = Color(0xFF4F4F4F))
                Spacer(Modifier.height(12.dp))
                Text("Bioage", color = Color(0xFF4F4F4F))
            }
        }

    }
}
