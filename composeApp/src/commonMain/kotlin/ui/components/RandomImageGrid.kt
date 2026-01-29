package ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import androidx.compose.foundation.lazy.staggeredgrid.*
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource

import kotlin.random.Random

data class TileSpec(
    val span: Int,          // 1 or 2 columns
    val aspect: Float       // width / height
)


fun buildRandomSpecs(
    count: Int,
    seed: Int = 1234
): List<TileSpec> {
    val rnd = Random(seed)

    return List(count) {
        val roll = rnd.nextFloat()

        when {
            roll < 0.20f -> TileSpec(span = 2, aspect = rnd.nextFloat().lerp(2.6f, 2.2f)) // wide
            roll < 0.55f -> TileSpec(span = 1, aspect = rnd.nextFloat().lerp(0.65f, 0.90f)) // tall
            else         -> TileSpec(span = 1, aspect = rnd.nextFloat().lerp(1.0f, 1.4f))   // normal
        }
    }
}

private fun Float.lerp(a: Float, b: Float) = a + (b - a) * this


//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun RandomImageGrid(
//    items: List<DrawableResource>, // your image URLs / IDs
//    seed: Int = 2026
//) {
//    val specs = remember(items.size, seed) { buildRandomSpecs(items.size, seed) }
//
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        contentPadding = PaddingValues(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(12.dp),
//        verticalArrangement = Arrangement.spacedBy(12.dp),
//    ) {
//        items(
//            count = items.size,
//            span = { index -> GridItemSpan(specs[index].span) }
//        ) { index ->
//            val spec = specs[index]
//
//            Box(
//                Modifier
//                    .fillMaxWidth()
//                    .aspectRatio(spec.aspect)   // 핵: makes it tall/wide/normal
//                    .clip(RoundedCornerShape(18.dp))
//                    .background(Color(0xFF2A2A2A))
//            ) {
//                // put your image here (AsyncImage/Kamel/etc)
//                Image(
//                    painter = painterResource(items[index]),
//                    contentDescription = null,
//                )
//            }
//        }
//    }
//}
@Composable
fun RandomImageGrid(
    items: List<DrawableResource>,
    seed: Int = 2026
) {
    // We only need the aspect ratio for staggered flow;
    // span is less common in masonry but supported via 'FullLine'
    val specs = remember(items.size, seed) { buildRandomSpecs(items.size, seed) }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalItemSpacing = 12.dp, // Use this instead of verticalArrangement
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(items) { index, item ->
            val spec = specs[index]

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(spec.aspect)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFF2A2A2A))
            ) {
                Image(
                    painter = painterResource(item),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop // Ensures image fills the aspect ratio box
                )
            }
        }
    }
}
