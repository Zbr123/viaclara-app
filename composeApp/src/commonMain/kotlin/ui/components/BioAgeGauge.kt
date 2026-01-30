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

private const val LEFT_START = 260f
private const val RIGHT_START = -80f
private const val SWEEP_TOTAL = 90f
@Composable
fun BioAgeGauge(
    age: Int,
    leftProgress: Float,   // 0f..1f
    rightProgress: Float,  // 0f..1f
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(300.dp),
    ) {
        Box(
            modifier = Modifier.size(300.dp)
        ) {
            Image(
                painterResource(Res.drawable.guage),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Canvas(modifier = Modifier.fillMaxSize()) {

                val strokeWidth = 20.dp.toPx()
                val radius = size.minDimension / 2.6f

                val arcSize = Size(radius * 2f, radius * 2f)
                val topLeft = Offset(
                    (size.width - arcSize.width) / 2f,
                    (size.height - arcSize.height) / 2f
                )

                // Negating sweep for anticlockwise direction
                val leftSweep = -(SWEEP_TOTAL * leftProgress.coerceIn(0f, 1f))-100 // anti-clockwise sweep
                val rightSweep = SWEEP_TOTAL * rightProgress.coerceIn(0f, 1f)+100 // clockwise sweep

                val leftBrush = Brush.linearGradient(listOf(Color(0xFFFF4815), Color(0xFFFF6804)))
                val rightBrush = Brush.linearGradient(listOf(Color(0xFF4CAF50), Color(0xFF8BC34A)))

                val glowSteps = listOf(
                    (strokeWidth + 18.dp.toPx()) to 0.10f,
                    (strokeWidth + 10.dp.toPx()) to 0.14f,
                    (strokeWidth + 4.dp.toPx())  to 0.18f,
                )

                fun drawGlowArc(brush: Brush, start: Float, sweep: Float) {
                    if (sweep == 0f) return
                    glowSteps.forEach { (w, a) ->
                        drawArc(
                            brush = brush,
                            startAngle = start,
                            sweepAngle = sweep,
                            useCenter = false,
                            topLeft = topLeft,
                            size = arcSize,
                            alpha = a,
                            style = Stroke(width = w, cap = StrokeCap.Round)
                        )
                    }
                }

                // ---- GLOW FIRST (behind) ----
                drawGlowArc(leftBrush, LEFT_START, leftSweep)
                drawGlowArc(rightBrush, RIGHT_START, rightSweep)

                // ---- MAIN ARCS (front) ----
                if (leftSweep != 0f) {
                    drawArc(
                        brush = leftBrush,
                        startAngle = LEFT_START,
                        sweepAngle = leftSweep,
                        useCenter = false,
                        topLeft = topLeft,
                        size = arcSize,
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                    )
                }

                if (rightSweep != 0f) {
                    drawArc(
                        brush = rightBrush,
                        startAngle = RIGHT_START,
                        sweepAngle = rightSweep,
                        useCenter = false,
                        topLeft = topLeft,
                        size = arcSize,
                        style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
                    )
                }
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = age.toString(),
                    fontSize = 60.sp,
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
