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
    showGauge: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.clickable(onClick = onToggle)) {
        AnimatedVisibility(visible = showGauge) {
            BioAgeGauge(
                age = 22,
                leftProgress = 0.46f,
                rightProgress = 0.46f
            )
        }
        AnimatedVisibility(visible = !showGauge) {
            BioAgeGaugeDetail(
                age = 22,
                loadProgress = 76f,
                recoveryProgress = 46f
            )
        }
    }
}