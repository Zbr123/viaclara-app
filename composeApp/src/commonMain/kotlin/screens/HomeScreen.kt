////package screens
////
////import androidx.compose.animation.AnimatedVisibility
////import androidx.compose.foundation.background
////import androidx.compose.foundation.border
////import androidx.compose.foundation.clickable
////import androidx.compose.foundation.layout.Arrangement
////import androidx.compose.foundation.layout.Box
////import androidx.compose.foundation.layout.Column
////import androidx.compose.foundation.layout.PaddingValues
////import androidx.compose.foundation.layout.Row
////import androidx.compose.foundation.layout.Spacer
////import androidx.compose.foundation.layout.defaultMinSize
////import androidx.compose.foundation.layout.fillMaxHeight
////import androidx.compose.foundation.layout.fillMaxWidth
////import androidx.compose.foundation.layout.height
////import androidx.compose.foundation.layout.padding
////import androidx.compose.foundation.layout.size
////import androidx.compose.foundation.layout.width
////import androidx.compose.foundation.shape.RoundedCornerShape
////import androidx.compose.material3.Button
////import androidx.compose.material3.ButtonDefaults
////import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
////import androidx.compose.material3.MaterialExpressiveTheme
////import androidx.compose.material3.Text
////import androidx.compose.runtime.*
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.graphics.Brush
////import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.text.TextStyle
////import androidx.compose.ui.text.style.TextAlign
////import androidx.compose.ui.tooling.preview.Preview
////import androidx.compose.ui.unit.dp
////import androidx.compose.ui.unit.sp
////import ui.components.BioAgeGauge
////import ui.components.BioAgeGaugeDetail
////import ui.components.BioAgeVerdict
////import ui.components.RandomImageGrid
////import ui.components.WelcomeHeader
////import viaclara.composeapp.generated.resources.Res
////import viaclara.composeapp.generated.resources.img
////import viaclara.composeapp.generated.resources.img_1
////import viaclara.composeapp.generated.resources.img_2
////import viaclara.composeapp.generated.resources.img_3
////import viaclara.composeapp.generated.resources.avatar_user
////import viaclara.composeapp.generated.resources.icon_settings
////
////@OptIn(ExperimentalMaterial3ExpressiveApi::class)
////@Composable
////@Preview
////fun HomeScreen() {
////    MaterialExpressiveTheme {
////        var showContent by remember { mutableStateOf(true) }
////
////        Column(
////            modifier = Modifier
//////                .verticalScroll(rememberScrollState())
////                .background(brush = Brush.verticalGradient(
////                    colors = listOf(Color(0xFF292929), Color(0xFF1E1E1E)),
////                )),
////            horizontalAlignment = Alignment.CenterHorizontally,
////        ) {
////            Spacer(modifier = Modifier.height(60.dp))
////
////            // ============================================
////            // USING YOUR FIGMA PNG ICONS
////            // ============================================
////
////            Box(
////                modifier = Modifier.fillMaxWidth()
////                    .padding(horizontal = 20.dp)
////            ){
////                WelcomeHeader(
////                    name = "John",
////                    avatarImage = Res.drawable.avatar_user,
////                    settingsIcon = Res.drawable.icon_settings
////                )
////            }
////
////            Spacer(modifier = Modifier.height(50.dp))
////
////            AnimatedVisibility(showContent) {
////                Box(
////                    Modifier.clickable(true, onClick = {showContent=!showContent})
////                ){
////                    BioAgeGauge(
////                        age = 22,
////                        leftProgress = 0.46f,
////                        rightProgress = 0.46f
////                    )
////                }
////
////            }
////
////            AnimatedVisibility(!showContent) {
////                Box(
////                    Modifier.clickable(true, onClick = {showContent=!showContent})
////                ){
////                    BioAgeGaugeDetail(
////                        age = 22,
////                        loadProgress = 76f,
////                        recoveryProgress = 46f
////                    )
////                }
////
////            }
////
////                BioAgeVerdict(
////                    verdictHeading = "You’re Younger",
////                    verdictText = "Your body is performing better than your age."
////                )
////                Spacer(
////                    Modifier.size(20.dp)
////                )
////                Box(
////                    modifier = Modifier.fillMaxWidth().fillMaxHeight()
////                        .background(
////                            Color(0xFF2B2B2B), shape = RoundedCornerShape(
////                                topStart = 24.dp,
////                                topEnd = 24.dp,
////                                bottomEnd = 0.dp,
////                                bottomStart = 0.dp
////                            )
////                        )
////                        .padding(top = 20.dp),
////                ) {
////                    Column {
////                        Row(
////                            modifier = Modifier.fillMaxWidth()
////                                .padding(horizontal = 20.dp, vertical = 10.dp),
////                            horizontalArrangement = Arrangement.SpaceBetween
////                        ) {
////                            Text(
////                                "Videos",
////                                style = TextStyle(fontSize = 20.sp, color = Color(0xFF242424)),
////                            )
////                            Button(
////                                modifier = Modifier
////                                    .width(100.dp)
////                                    .height(24.dp) // Below 24.dp, text will almost always clip
////                                    .defaultMinSize(minHeight = 1.dp)
////                                    .border(
////                                        color = Color.White,
////                                        width = 1.dp,
////                                        shape = RoundedCornerShape(10.dp)
////                                    ),
////                                colors = ButtonDefaults.buttonColors( // Use ButtonDefaults for better KMP compatibility
////                                    containerColor = Color.Transparent,
////                                    contentColor = Color.White
////                                ),
////                                // 1. Remove default centering padding
////                                contentPadding = PaddingValues(start = 8.dp, end = 0.dp),
////                                onClick = {}
////                            ) {
////                                Text(
////                                    "Filter",
////                                    style = TextStyle(fontSize = 12.sp),
////                                    modifier = Modifier.fillMaxWidth(), // 2. Fill width to allow alignment
////                                    textAlign = TextAlign.Start        // 3. Justify to start
////                                )
////                            }
////
////                        }
////                        Spacer(
////                            Modifier.size(20.dp)
////                        )
////                        RandomImageGrid(
////                            items = listOf(
////                                Res.drawable.img_1,
////                                Res.drawable.img_2,
////                                Res.drawable.img_3,
////                                Res.drawable.img
////                            )
////                        )
////                    }
////                }
////
////                BioAgeVerdict(
////                    verdictHeading = "You’re Younger",
////                    verdictText = "Your body is performing better than your age."
////                )
////                Spacer(
////                    Modifier.size(20.dp)
////                )
////                Box(
////                    modifier = Modifier.fillMaxWidth().fillMaxHeight()
////                        .background(
////                            Color(0xFF2B2B2B), shape = RoundedCornerShape(
////                                topStart = 24.dp,
////                                topEnd = 24.dp,
////                                bottomEnd = 0.dp,
////                                bottomStart = 0.dp
////                            )
////                        )
////                        .padding(top = 20.dp),
////                ) {
////                    Column {
////                        Row(
////                            modifier = Modifier.fillMaxWidth()
////                                .padding(horizontal = 20.dp, vertical = 10.dp),
////                            horizontalArrangement = Arrangement.SpaceBetween
////                        ) {
////                            Text(
////                                "Videos",
////                                style = TextStyle(fontSize = 20.sp, color = Color(0xFF242424)),
////                            )
////                            Box(
////                                modifier = Modifier
////                                    .width(80.dp)
////                                    .height(28.dp)
////                                    .border(
////                                        color = Color.White,
////                                        width = 1.dp,
////                                        shape = RoundedCornerShape(6.dp)
////                                    )
////                                    .clickable(true, onClick = {
////                                        // TODO()
////                                    }),
////                                contentAlignment = Alignment.Center
////                                ) {
////                                Text(
////                                    "Filter",
////                                    color = Color.White,
////                                    style = TextStyle(fontSize = 12.sp),
////
////                                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp), // 2. Fill width to allow alignment
////                                    textAlign = TextAlign.Start        // 3. Justify to start
////                                )
////                            }
////
////                        }
////                        Spacer(
////                            Modifier.size(20.dp)
////                        )
////                        RandomImageGrid(
////                            modifier = Modifier.weight(1f), // 🔥 fixes infinity height
////                            items = listOf(
////                                Res.drawable.img_1,
////                                Res.drawable.img_2,
////                                Res.drawable.img_3,
////                                Res.drawable.img
////                            )
////                        )
////                    }
////                }
////
////                Spacer(modifier = Modifier.height(16.dp))
////            }
////
////        }
////
////}
//
//
//package screens
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.defaultMinSize
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
//import androidx.compose.material3.MaterialExpressiveTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import ui.components.BioAgeGauge
//import ui.components.BioAgeGaugeDetail
//import ui.components.BioAgeVerdict
//import ui.components.RandomImageGrid
//import ui.components.WelcomeHeader
//import viaclara.composeapp.generated.resources.Res
//import viaclara.composeapp.generated.resources.img
//import viaclara.composeapp.generated.resources.img_1
//import viaclara.composeapp.generated.resources.img_2
//import viaclara.composeapp.generated.resources.img_3
//import viaclara.composeapp.generated.resources.avatar_user
//import viaclara.composeapp.generated.resources.icon_settings
//
//@OptIn(ExperimentalMaterial3ExpressiveApi::class)
//@Composable
//fun HomeScreen() {
//    MaterialExpressiveTheme {
//        var showContent by remember { mutableStateOf(true) }
//
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .verticalScroll(rememberScrollState()),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Spacer(modifier = Modifier.height(60.dp))
//
//            // Welcome Header
//            Box(
//                modifier = Modifier.fillMaxWidth()
//                    .padding(horizontal = 20.dp)
//            ) {
//                WelcomeHeader(
//                    name = "John",
//                    avatarImage = Res.drawable.avatar_user,
//                    settingsIcon = Res.drawable.icon_settings
//                )
//            }
//
//            Spacer(modifier = Modifier.height(50.dp))
//
//            // Bio Age Gauge Toggle
//            AnimatedVisibility(showContent) {
//                Box(
//                    Modifier.clickable(true, onClick = { showContent = !showContent })
//                ) {
//                    BioAgeGauge(
//                        age = 22,
//                        leftProgress = 0.46f,
//                        rightProgress = 0.46f
//                    )
//                }
//            }
//
//            AnimatedVisibility(!showContent) {
//                Box(
//                    Modifier.clickable(true, onClick = { showContent = !showContent })
//                ) {
//                    BioAgeGaugeDetail(
//                        age = 22,
//                        loadProgress = 76f,
//                        recoveryProgress = 46f
//                    )
//                }
//            }
//
//            // Bio Age Verdict
//            BioAgeVerdict(
//                verdictHeading = "You're Younger",
//                verdictText = "Your body is performing better than your age."
//            )
//
//            Spacer(Modifier.size(20.dp))
//
//            // Videos Section
//            Box(
//                modifier = Modifier.fillMaxWidth()
//                    .background(
//                        Color(0xFF2B2B2B), shape = RoundedCornerShape(
//                            topStart = 24.dp,
//                            topEnd = 24.dp,
//                            bottomEnd = 0.dp,
//                            bottomStart = 0.dp
//                        )
//                    )
//                    .padding(top = 20.dp),
//            ) {
//                Column {
//                    Row(
//                        modifier = Modifier.fillMaxWidth()
//                            .padding(horizontal = 20.dp, vertical = 10.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(
//                            "Videos",
//                            style = TextStyle(fontSize = 20.sp, color = Color.White),
//                        )
//                        Box(
//                            modifier = Modifier
//                                .width(80.dp)
//                                .height(28.dp)
//                                .border(
//                                    color = Color.White,
//                                    width = 1.dp,
//                                    shape = RoundedCornerShape(6.dp)
//                                )
//                                .clickable(true, onClick = {
//                                    // TODO: Filter action
//                                }),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Text(
//                                "Filter",
//                                color = Color.White,
//                                style = TextStyle(fontSize = 12.sp),
//                                modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
//                                textAlign = TextAlign.Start
//                            )
//                        }
//                    }
//
//                    Spacer(Modifier.size(20.dp))
//
//                    RandomImageGrid(
//                        items = listOf(
//                            Res.drawable.img_1,
//                            Res.drawable.img_2,
//                            Res.drawable.img_3,
//                            Res.drawable.img
//                        )
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(40.dp))
//        }
//    }
//}


package screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.components.BioAgeGauge
import ui.components.BioAgeGaugeDetail
import ui.components.BioAgeVerdict
import ui.components.RandomImageGrid
import ui.components.WelcomeHeader
import viaclara.composeapp.generated.resources.Res
import viaclara.composeapp.generated.resources.avatar_user
import viaclara.composeapp.generated.resources.icon_settings
import viaclara.composeapp.generated.resources.img
import viaclara.composeapp.generated.resources.img_1
import viaclara.composeapp.generated.resources.img_2
import viaclara.composeapp.generated.resources.img_3

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeScreen() {
    // Removed MaterialExpressiveTheme as it's likely already in App.kt
    var showContent by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()), // The entire screen is scrollable
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        // Welcome Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            WelcomeHeader(
                name = "John",
                avatarImage = Res.drawable.avatar_user,
                settingsIcon = Res.drawable.icon_settings
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        // Bio Age Gauge Toggle
        AnimatedVisibility(showContent) {
            Box(
                Modifier.clickable(true, onClick = { showContent = !showContent })
            ) {
                BioAgeGauge(
                    age = 22,
                    leftProgress = 0.46f,
                    rightProgress = 0.46f
                )
            }
        }

        AnimatedVisibility(!showContent) {
            Box(
                Modifier.clickable(true, onClick = { showContent = !showContent })
            ) {
                BioAgeGaugeDetail(
                    age = 22,
                    loadProgress = 76f,
                    recoveryProgress = 46f
                )
            }
        }

        // Bio Age Verdict
        BioAgeVerdict(
            verdictHeading = "You're Younger",
            verdictText = "Your body is performing better than your age."
        )

        Spacer(Modifier.size(20.dp))

        // Videos Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xFF2B2B2B), shape = RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
                .padding(top = 20.dp),
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Videos",
                        style = TextStyle(fontSize = 20.sp, color = Color.White),
                    )
                    Box(
                        modifier = Modifier
                            .width(80.dp)
                            .height(28.dp)
                            .border(
                                color = Color.White,
                                width = 1.dp,
                                shape = RoundedCornerShape(6.dp)
                            )
                            .clickable(true, onClick = {
                                // TODO: Filter action
                            }),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Filter",
                            color = Color.White,
                            style = TextStyle(fontSize = 12.sp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp),
                            textAlign = TextAlign.Start
                        )
                    }
                }

                Spacer(Modifier.size(20.dp))

                // 🔥 FIX: Added a fixed height to the scrollable grid
                RandomImageGrid(
                    modifier = Modifier.height(300.dp), // This constrains the height
                    items = listOf(
                        Res.drawable.img_1,
                        Res.drawable.img_2,
                        Res.drawable.img_3,
                        Res.drawable.img
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}
