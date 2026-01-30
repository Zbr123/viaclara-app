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
import org.jetbrains.compose.resources.painterResource
import viaclara.composeapp.generated.resources.Res
import viaclara.composeapp.generated.resources.ai_verdict

@Composable
fun BioAgeVerdict(
    verdictHeading: String = "You’re Younger",
    verdictText: String = "Your body is performing better than your age."
){
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Image(
            painter = painterResource(Res.drawable.ai_verdict),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            contentScale = ContentScale.FillWidth
        )
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start =10.dp)
                .padding(horizontal = 80.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = verdictHeading,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(verdictText,
                fontSize = 10.sp,
                lineHeight = 10.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.width(220.dp),
                color = Color.Gray,
                fontFamily = FontFamily.Default)
        }
    }
}