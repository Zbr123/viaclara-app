package ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.painterResource
import ui.theme.TextSecondary
import viaclara.composeapp.generated.resources.Res
import viaclara.composeapp.generated.resources.ai_verdict

@Composable
fun BioAgeVerdict(
    verdictHeading: String,
    verdictText: String,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            painter = painterResource(Res.drawable.ai_verdict),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            contentScale = ContentScale.FillWidth
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp, start = 8.dp)
                .padding(horizontal = 80.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = verdictHeading,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Start
            )
            Text(
                text = verdictText,
                fontSize = 11.sp,
                lineHeight = 11.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.width(420.dp),
                color = TextSecondary,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}
