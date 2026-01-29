//package ui.components
//
//import androidx.compose.foundation.Canvas
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Paint
//import androidx.compose.ui.graphics.StrokeCap
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun GlowingArc(
//    modifier: Modifier,
//    color: Color = Color(0xFFFF5A2A),
//    startAngle: Float = 220f,
//    sweepAngle: Float = 120f,
//) {
//    Canvas(modifier) {
//        val strokeCore = 20.dp.toPx()
//        val strokeGlow = strokeCore * 1.6f
//        val blur = 18.dp.toPx()
//
//        // Keep the arc inside bounds (account for thick glow stroke)
//        val pad = strokeGlow / 2f
//        val topLeft = Offset(pad, pad)
//        val size = Size(this.size.width - 2 * pad, this.size.height - 2 * pad)
//
//        // 1) Glow pass (blurred)
//        drawIntoCanvas { canvas ->
//            val glowPaint = Paint().apply {
//                this.color = color.copy(alpha = 0.55f)
//            }
//
//            // This is the key: set blur on underlying paint
//            setPlatformBlur(glowPaint, blur)
//
//            canvas.drawArc(
//                topLeft = topLeft,
//                size = size,
//                startAngle = startAngle,
//                sweepAngle = sweepAngle,
//                useCenter = false,
//                paint= glowPaint,
////                paint = glowPaint,
//                style = Stroke(width = strokeGlow, cap = StrokeCap.Round),
//            )
//        }
//
//        // 2) Core pass (sharp)
//        drawArc(
//            color = color,
//            startAngle = startAngle,
//            sweepAngle = sweepAngle,
//            useCenter = false,
//            topLeft = topLeft,
//            size = size,
//            style = Stroke(width = strokeCore, cap = StrokeCap.Round)
//        )
//    }
//}
