package screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import org.jetbrains.compose.resources.DrawableResource
import sections.GaugeSection
import sections.HeaderSection
import sections.VerdictSection
import sections.VideosSection
import ui.components.*
import viaclara.composeapp.generated.resources.*

private const val DEFAULT_NAME = "John"
private const val VIDEOS_TITLE = "Videos"
private const val FILTER_TEXT = "Filter"

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
@Preview
fun HomeScreen() {
    var showGauge by rememberSaveable { mutableStateOf(true) }

    val verdictHeading = "You're Younger"
    val verdictText = "Your body is performing better than your age."

    val videoItems = remember {
        listOf(
            Res.drawable.img_1,
            Res.drawable.img_2,
            Res.drawable.img_3,
            Res.drawable.img
        )
    }

    val bg = remember {
        Brush.verticalGradient(
            colors = listOf(Color(0xFF292929), Color(0xFF1E1E1E))
        )
    }

    HomeScreenContent(
        showGauge = showGauge,
        onToggleGauge = { showGauge = !showGauge },
        verdictHeading = verdictHeading,
        verdictText = verdictText,
        videoItems = videoItems,
        background = bg,
        onFilterClick = {}
    )
}

@Composable
private fun HomeScreenContent(
    showGauge: Boolean,
    onToggleGauge: () -> Unit,
    verdictHeading: String,
    verdictText: String,
    videoItems: List<DrawableResource>,
    background: Brush,
    onFilterClick: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom = 40.dp)
    ) {
        item { Spacer(modifier = Modifier.height(60.dp)) }

        item {
            HeaderSection(
                name = DEFAULT_NAME,
                avatar = Res.drawable.avatar_user,
                settingsIcon = Res.drawable.icon_settings
            )
        }

        item { Spacer(modifier = Modifier.height(if (showGauge) 50.dp else 0.dp)) }

        item {
            GaugeSection(
                showGauge = showGauge,
                onToggle = onToggleGauge
            )
        }

        item {
            VerdictSection(
                heading = verdictHeading,
                text = verdictText
            )
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }

        item {
            VideosSection(
                title = VIDEOS_TITLE,
                items = videoItems,
                filterText = FILTER_TEXT,
                onFilterClick = onFilterClick,
                gridHeight = 300.dp
            )
        }
    }
}
