package sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import ui.components.WelcomeHeader
import viaclara.composeapp.generated.resources.*

@Composable
fun HeaderSection(
    name: String,
    avatar: DrawableResource,
    settingsIcon: DrawableResource,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        WelcomeHeader(
            name = name,
            avatarImage = avatar,
            settingsIcon = settingsIcon
        )
    }
}
