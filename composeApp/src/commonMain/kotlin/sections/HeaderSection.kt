package sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.WelcomeHeader
import viaclara.composeapp.generated.resources.*

@Composable
private fun HeaderSection(
    name: String = "John",
) {
    Box(
        Modifier.fillMaxWidth().padding(horizontal = 20.dp)
    ) {
        WelcomeHeader(
            name = name,
            avatarImage = Res.drawable.avatar_user,
            settingsIcon = Res.drawable.icon_settings
        )
    }
}
