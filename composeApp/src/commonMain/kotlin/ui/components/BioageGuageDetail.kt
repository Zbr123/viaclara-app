package ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import viaclara.composeapp.generated.resources.Res
import viaclara.composeapp.generated.resources.guage
import viaclara.composeapp.generated.resources.guage_mini
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
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MetricGauge(
            size = 80.dp,
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
        modifier = Modifier.width(size + 20.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(size)) {
            Image(
                painterResource(Res.drawable.guage),
                "background",
                modifier = Modifier.fillMaxSize()
            )
            GaugeArc(
                progress = progress,
                startAngle = 135f,
                sweepTotal = 270f,
                arcBrush = arcBrush,
                trackColor = Color(0xFF2A2A2A),
                stroke = 7.dp,
                glow = true
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
                    modifier = Modifier.padding(bottom = 6.dp, start = 2.dp)
                )
            }
        }

        Spacer(Modifier.height(10.dp))

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
                    fontSize = 58.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Text(
                    text = "Years old",
                    fontSize = 16.sp,
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
    progress: Float,
    startAngle: Float,
    sweepTotal: Float,
    arcBrush: Brush,
    trackColor: Color,
    stroke: Dp,
    glow: Boolean
) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val strokePx = stroke.toPx()
        val radius = (size.minDimension / 2f) - strokePx
        val arcSize = Size(radius * 2f, radius * 2f)
        val topLeft = Offset((size.width - arcSize.width) / 2f, (size.height - arcSize.height) / 2f)

        // Track
        drawArc(
            color = trackColor,
            startAngle = startAngle,
            sweepAngle = sweepTotal,
            useCenter = false,
            topLeft = topLeft,
            size = arcSize,
            style = Stroke(width = strokePx, cap = StrokeCap.Round)
        )

        val sweep = sweepTotal * progress

        // Glow (draw same arc a few times behind it)
        if (glow && sweep > 0f) {
            val glowSteps = listOf(
                22.dp.toPx() to 0.10f,
                18.dp.toPx() to 0.14f,
                14.dp.toPx() to 0.18f,
            )
            glowSteps.forEach { (w, a) ->
                drawArc(
                    brush = arcBrush,
                    startAngle = startAngle,
                    sweepAngle = sweep,
                    useCenter = false,
                    topLeft = topLeft,
                    size = arcSize,
                    alpha = a,
                    style = Stroke(width = w, cap = StrokeCap.Round)
                )
            }
        }

        // Main arc
        if (sweep > 0f) {
            drawArc(
                brush = arcBrush,
                startAngle = startAngle,
                sweepAngle = sweep,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = Stroke(width = strokePx, cap = StrokeCap.Round)
            )
        }
    }
}
