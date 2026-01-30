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
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import ui.theme.AccentColor

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
            .height(80.dp)
            .background(
                color = Color(0xFF2D2C31), // Keeping white as per design in file
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 20.dp),
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
            Text(text = "👤", fontSize = 20.sp)
        }
    }
}

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
            color = Color(0xFF6D6D6D),
            fontSize = 13.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Normal
        )

        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF242424),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            lineHeight = 28.sp
        )

        if (subtitle.isNotEmpty()) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF6D6D6D),
                fontSize = 11.sp,
                lineHeight = 14.sp
            )
        }
    }
}

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
            .background(AccentColor)
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
            Text(text = "⚙️", fontSize = 20.sp)
        }
    }
}
