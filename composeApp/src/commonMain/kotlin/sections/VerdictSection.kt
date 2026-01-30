package sections

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.components.BioAgeVerdict

@Composable
fun VerdictSection(
    heading: String,
    text: String,
    modifier: Modifier = Modifier
) {
    BioAgeVerdict(
        verdictHeading = heading,
        verdictText = text,
        modifier = modifier
    )
}
