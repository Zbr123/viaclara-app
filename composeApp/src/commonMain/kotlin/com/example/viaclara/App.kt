//package com.example.viaclara
//import androidx.compose.runtime.*
//import androidx.compose.ui.tooling.preview.Preview
//import screens.HomeScreen
//
//@Composable
//@Preview
//fun App() {
//    HomeScreen()
//}

package com.example.viaclara

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viaclara.ui.components.BottomNavBar
import com.example.viaclara.navigation.TabItem
import screens.CalendarScreen
import screens.HomeScreen
import screens.ShareScreen

@Composable
@Preview
fun App() {
    // Initialize with Home tab - using object reference directly
    var selectedTab by remember { mutableStateOf<TabItem>(TabItem.Home) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF292929),
                        Color(0xFF1E1E1E)
                    ),
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Dynamic content based on selected tab
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            when (selectedTab) {
                TabItem.Home -> HomeScreen()
                TabItem.Calendar -> CalendarScreen()
                TabItem.Share -> ShareScreen()
                else -> HomeScreen() // Fallback
            }
        }

        // Bottom Navigation Bar
        BottomNavBar(
            selectedTab = selectedTab,
            onTabSelected = { tab ->
                selectedTab = tab
            },
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )
    }
}