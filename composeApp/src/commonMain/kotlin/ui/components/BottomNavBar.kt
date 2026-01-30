package com.example.viaclara.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.viaclara.navigation.TabItem

@Composable
fun BottomNavBar(
    selectedTab: TabItem,
    onTabSelected: (TabItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(
                color = Color(0xFF2B2B2B).copy(alpha = 5f), // Semi-transparent
                shape = RoundedCornerShape(30.dp)
            )
            .padding(horizontal = 5.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        val tabs = TabItem.getAllTabs()

        tabs.forEach { tab ->
            BottomNavItem(
                tab = tab,
                isSelected = selectedTab == tab,
                onClick = { onTabSelected(tab) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}