package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/**
 * WelcomeHeader Component
 *
 * Matches exact Figma specifications:
 * - Width: 382dp (Fixed)
 * - Height: 80dp (Hug)
 * - Padding: 8dp
 * - Gap: 4dp
 * - Radius: 16dp
 * - Background: #2D2C31
 * - Inner shadow: X=-4, Y=-4, Blur=10, Spread=0, Color=#FFFFFF 4%
 *
 * @param name User's display name
 * @param subtitle Optional subtitle text (e.g., "24h ago")
 * @param avatarImage Optional avatar image resource
 * @param settingsIcon Optional settings icon resource
 * @param onSettingsClick Callback invoked when settings button is clicked
 * @param modifier Modifier for customizing the component's appearance
 */
@Composable
fun WelcomeHeader(
    name: String,
    modifier: Modifier = Modifier,
    subtitle: String = "",
    avatarImage: DrawableResource? = null,
    settingsIcon: DrawableResource? = null,
    onSettingsClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)              // Hug height from Figma: 80px
            .shadow(
                elevation = 0.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false
            )
            .background(
                color = Color(0xFFFFFFF),  // Background: #2D2C31
                shape = RoundedCornerShape(16.dp)  // Radius: 16dp
            )
            .padding(20.dp),             // Padding: 8dp from Figma
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)  // Gap: 4dp from Figma
    ) {
        // Left: Avatar (64dp including padding)
        Avatar(
            avatarImage = avatarImage,
            contentDescription = "$name's avatar"
        )

        // Center: Welcome text
        WelcomeText(
            name = name,
            subtitle = subtitle,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        )

        // Right: Settings button (64dp including padding)
        SettingsButton(
            settingsIcon = settingsIcon,
            onClick = onSettingsClick,
            contentDescription = "Settings"
        )
    }
}

/**
 * Avatar Component
 *
 * Circular avatar with lime green background
 * Size: 64dp (to fit within 80dp height with 8dp padding)
 */
@Composable
private fun Avatar(
    avatarImage: DrawableResource?,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(Color(0xFFB4E830)),
        contentAlignment = Alignment.Center
    ) {
        if (avatarImage != null) {
            Image(
                painter = painterResource(avatarImage),
                contentDescription = contentDescription,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        } else {
            // Fallback emoji
            Text(
                text = "👤",
                fontSize = 30.sp
            )
        }
    }
}

/**
 * Welcome Text Component
 *
 * Displays welcome message, user name, and optional subtitle
 * Uses Figma color specifications
 */
@Composable
private fun WelcomeText(
    name: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome Back",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF6D6D6D),  // Updated gray color from Figma
            fontSize = 13.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Normal
        )

        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF242424),  // Updated gray color from Figma
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = 28.sp
        )

        if (subtitle.isNotEmpty()) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF6D6D6D),  // Same gray as welcome text
                fontSize = 11.sp,
                lineHeight = 14.sp
            )
        }
    }
}

/**
 * Settings Button Component
 *
 * Circular button with lime green background
 * Size: 64dp (to fit within 80dp height with 8dp padding)
 */
@Composable
private fun SettingsButton(
    settingsIcon: DrawableResource?,
    onClick: () -> Unit,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(Color(0xFF87E64C))  // Updated green color
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        if (settingsIcon != null) {
            Image(
                painter = painterResource(settingsIcon),
                contentDescription = contentDescription,
                modifier = Modifier.size(20.dp),
                contentScale = ContentScale.Fit
            )
        } else {
            // Fallback emoji
            Text(
                text = "⚙️",
                fontSize = 32.sp
            )
        }
    }
}

// ============================================
// FIGMA DESIGN SYSTEM COLORS
// ============================================

/**
 * Exact colors from Figma design
 */
object FigmaColors {
    val Background = Color(0xFF2D2C31)      // Main background
    val AvatarGreen = Color(0xFF87E64C)     // Avatar & Settings background
    val TextPrimary = Color(0xFF6D6D6D)     // Name text (white)
    val TextSecondary = Color(0xFF6D6D6D)   // Welcome & subtitle text (gray)
    val InnerShadow = Color(0xFF242424)     // Shadow color: #FFFFFF at 4% opacity
}

// ============================================
// RESPONSIVE VARIANT (Optional)
// ============================================

/**
 * Responsive WelcomeHeader that adapts to screen width
 * Use this if you need the component to work on different screen sizes
 */
@Composable
fun WelcomeHeaderResponsive(
    name: String,
    modifier: Modifier = Modifier,
    subtitle: String = "",
    avatarImage: DrawableResource? = null,
    settingsIcon: DrawableResource? = null,
    onSettingsClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()             // Responsive width
            .height(80.dp)              // Keep fixed height from Figma
            .background(
                color = FigmaColors.Background,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Avatar(
            avatarImage = avatarImage,
            contentDescription = "$name's avatar"
        )

        WelcomeText(
            name = name,
            subtitle = subtitle,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        )

        SettingsButton(
            settingsIcon = settingsIcon,
            onClick = onSettingsClick,
            contentDescription = "Settings"
        )
    }
}

// ============================================
// CUSTOM COLORS VARIANT (Optional)
// ============================================

/**
 * WelcomeHeader with customizable colors
 * Useful for different themes or states
 */
@Composable
fun WelcomeHeaderCustom(
    name: String,
    modifier: Modifier = Modifier,
    subtitle: String = "",
    avatarImage: DrawableResource? = null,
    settingsIcon: DrawableResource? = null,
    backgroundColor: Color = FigmaColors.Background,
//    accentColor: Color = FigmaColors.AvatarGreen,
    textColor: Color = FigmaColors.TextPrimary,
    secondaryTextColor: Color = FigmaColors.TextSecondary,
    onSettingsClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .width(382.dp)
            .height(80.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // Avatar with custom color
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            if (avatarImage != null) {
                Image(
                    painter = painterResource(avatarImage),
                    contentDescription = "$name's avatar",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            } else {
                Text(text = "👤", fontSize = 32.sp)
            }
        }

        // Text with custom colors
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = "Welcome Back",
                color = secondaryTextColor,
                fontSize = 13.sp,
                lineHeight = 16.sp
            )
            Text(
                text = name,
                color = textColor,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 28.sp
            )
            if (subtitle.isNotEmpty()) {
                Text(
                    text = subtitle,
                    color = secondaryTextColor,
                    fontSize = 11.sp,
                    lineHeight = 14.sp
                )
            }
        }

        // Settings with custom color
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .clickable(onClick = onSettingsClick),
            contentAlignment = Alignment.Center
        ) {
            if (settingsIcon != null) {
                Image(
                    painter = painterResource(settingsIcon),
                    contentDescription = "Settings",
                    modifier = Modifier.size(32.dp)
                )
            } else {
                Text(text = "⚙️", fontSize = 32.sp)
            }
        }
    }
}