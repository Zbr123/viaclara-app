package sections

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.components.BioAgeGauge
import ui.components.BioAgeGaugeDetail


@Composable
fun GaugeSection(
    age: Int,
    leftProgress: Float,
    rightProgress: Float,
    showGauge: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.clickable(onClick = onToggle)) {
        AnimatedVisibility(visible = showGauge) {
            BioAgeGauge(
                age = age,
                leftProgress = leftProgress/2,
                rightProgress = rightProgress/2
            )
        }
        AnimatedVisibility(visible = !showGauge) {
            BioAgeGaugeDetail(
                age = age,
                loadProgress = leftProgress*100,
                recoveryProgress = rightProgress*100
            )
        }
    }
}