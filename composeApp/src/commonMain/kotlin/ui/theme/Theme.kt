package ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = AccentColor,
    surface = SurfaceColor,
    background = DarkGray,
    onPrimary = Color.White,
    onSurface = Color.White,
    onBackground = Color.White
)

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ViaClaraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else DarkColorScheme // Forcing dark for now as per design

    MaterialExpressiveTheme(
        colorScheme = colorScheme,
        content = content
    )
}
