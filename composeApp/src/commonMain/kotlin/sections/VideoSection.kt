package sections

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import ui.components.RandomImageGrid


@Composable
fun VideosSection(
    title: String,
    items: List<DrawableResource>,
    filterText: String,
    onFilterClick: () -> Unit,
    gridHeight: Dp,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF2B2B2B),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .padding(top = 20.dp)
    ) {
        Column {
            VideosHeaderRow(
                title = title,
                filterText = filterText,
                onFilterClick = onFilterClick
            )

            Spacer(modifier = Modifier.height(20.dp))

            RandomImageGrid(
                modifier = Modifier.height(gridHeight),
                items = items
            )
        }
    }
}



@Composable
private fun VideosHeaderRow(
    title: String,
    filterText: String,
    onFilterClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            title,
            style = TextStyle(fontSize = 20.sp, color = Color.White)
        )

        FilterButton(text = filterText, onClick = onFilterClick)
    }
}

@Composable
private fun FilterButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(80.dp)
            .height(28.dp)
            .border(
                color = Color.White,
                width = 1.dp,
                shape = RoundedCornerShape(6.dp)
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text,
            color = Color.White,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier.padding(start = 10.dp),
            textAlign = TextAlign.Start
        )
    }
}
