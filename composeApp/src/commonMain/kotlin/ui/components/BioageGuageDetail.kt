package ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import org.jetbrains.compose.resources.painterResource
import viaclara.composeapp.generated.resources.*
import kotlin.math.roundToInt

@Composable
fun BioAgeGaugeDetail(
    age: Int,
    loadProgress: Float,      // 0f..1f
    recoveryProgress: Float,  // 0f..1f
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MetricGauge(
            size = 100.dp,
            progress = loadProgress,
            valueColor = Color(0xFFFF6A00),
            label = "Load",
            dotColor = Color(0xFFFF6A00),
            arcBrush = Brush.linearGradient(listOf(Color(0xFFFF4A1A), Color(0xFFFF7A00))),
        )

        BioAgeCenterGauge(
            gaugeSize = 150.dp,
            age = age,
            label = "Bioage"
        )

        MetricGauge(
            size = 100.dp,
            progress = recoveryProgress,
            valueColor = Color(0xFF9CFF7A),
            label = "Recovery",
            dotColor = Color(0xFF67FF66),
            arcBrush = Brush.linearGradient(listOf(Color(0xFF45E65A), Color(0xFFA6FF5A))),
        )
    }
}

/** Left/Right gauge */
@Composable
private fun MetricGauge(
    size: Dp,
    progress: Float,
    arcBrush: Brush,
    valueColor: Color,
    label: String,
    dotColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.width(size)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(size)) {
            Image(
                painterResource(Res.drawable.guage),
                "background",
                modifier = Modifier.fillMaxSize()
            )

            // right arc
            GaugeArc(
                leftProgress = progress /2,
                rightProgress = progress /2,
                startAngle = -80f,
                sweepTotal = 90f,
                arcBrush = arcBrush,
                stroke = 7.dp,
            )

            // left arc
            GaugeArc(
                leftProgress = progress / 2,
                rightProgress = progress / 2,
                startAngle = 170f,   // mirror of -80°
                sweepTotal = 90f,
                arcBrush = arcBrush,
                stroke = 7.dp,
            )

            val pct = (progress).roundToInt()
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = pct.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = valueColor
                )
                Text(
                    text = "%",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = valueColor,
                    modifier = Modifier.padding(start = 2.dp)
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(dotColor, CircleShape)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = label,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

/** Middle gauge */
@Composable
private fun BioAgeCenterGauge(
    gaugeSize: Dp,
    age: Int,
    label: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.width(gaugeSize)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(gaugeSize)) {
            Image(
                painterResource(Res.drawable.guage_mini),
                "background",
                modifier = Modifier.fillMaxSize()
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = age.toString(),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Text(
                    text = "Years old",
                    fontSize = 12.sp,
                    color = Color(0xFF6B6B6B)
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xFF3B3B3B), CircleShape)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = label,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

/**
 * Arc + track + "fake glow" (KMP friendly)
 */
@Composable
private fun GaugeArc(
    leftProgress: Float,
    rightProgress: Float,
    startAngle: Float,
    sweepTotal: Float,
    arcBrush: Brush,
    stroke: Dp,
) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val strokePx = stroke.toPx()
        val radius = (size.minDimension / 2.1f) - strokePx
        val arcSize = Size(radius * 2f, radius * 2f)
        val topLeft = Offset((size.width - arcSize.width) / 2f, (size.height - arcSize.height) / 2f)


        val startBase = startAngle

        val leftSweep = sweepTotal * leftProgress.coerceIn(0f, 1f)
        val rightSweep = sweepTotal * rightProgress.coerceIn(0f, 1f)
        val rightStart = startBase + sweepTotal * (1f - rightProgress.coerceIn(0f, 1f))

        // same glow steps you liked
            val glowSteps = listOf(
                12.dp.toPx() to 0.10f,
                10.dp.toPx() to 0.14f,
            )

        fun drawGlowArc(brush: Brush, start: Float, sweep: Float) {
            if (sweep <= 0f) return
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
        drawGlowArc(arcBrush, startBase, leftSweep)
        drawGlowArc(arcBrush, rightStart, rightSweep)

        // ---- MAIN ARCS (front) ----
        if (leftSweep > 0f) {
            drawArc(
                brush = arcBrush,
                startAngle = startBase,
                sweepAngle = leftSweep,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = Stroke(width = strokePx, cap = StrokeCap.Round)
            )
        }

        if (rightSweep > 0f) {
            drawArc(
                brush = arcBrush,
                startAngle = rightStart,
                sweepAngle = rightSweep,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = Stroke(width = strokePx, cap = StrokeCap.Round)
            )
        }
    }
}
