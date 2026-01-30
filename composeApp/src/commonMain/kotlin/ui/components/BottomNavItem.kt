package com.example.viaclara.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viaclara.navigation.TabItem
import org.jetbrains.compose.resources.painterResource

/**
 * Individual Bottom Navigation Item Component
 *
 * FIXED: Using Image with ColorFilter instead of Icon with tint
 * This ensures compatibility with Material3 and PNG resources
 */
@Composable
fun BottomNavItem(
    tab: TabItem,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Background color animation
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) {
            Color(0xFF4CAF50).copy(alpha = 0.2f)
        } else {
            Color.Transparent
        },
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "background_color"
    )

    // Icon color animation
    val iconColor by animateColorAsState(
        targetValue = if (isSelected) {
            Color(0xFF4CAF50)
        } else {
            Color(0xFF757575)
        },
        animationSpec = tween(durationMillis = 300),
        label = "icon_color"
    )

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(backgroundColor)
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(
                horizontal = if (isSelected) 16.dp else 12.dp,
                vertical = 12.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // ICON - Using Image with ColorFilter for PNG compatibility
        Image(
            painter = painterResource(tab.icon),
            contentDescription = tab.label,
            colorFilter = ColorFilter.tint(iconColor),
            modifier = Modifier.size(24.dp)
        )

        // LABEL - Animated visibility
        AnimatedVisibility(
            visible = isSelected,
            enter = fadeIn(animationSpec = tween(300)) +
                    expandHorizontally(animationSpec = tween(300)),
            exit = fadeOut(animationSpec = tween(200)) +
                    shrinkHorizontally(animationSpec = tween(200))
        ) {
            Text(
                text = tab.label,
                color = Color(0xFF4CAF50),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}