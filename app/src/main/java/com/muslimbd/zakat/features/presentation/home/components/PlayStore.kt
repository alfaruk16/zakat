package com.muslimbd.zakat.features.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muslimbd.zakat.R
import com.muslimbd.zakat.core.theme.Gray
import com.muslimbd.zakat.core.theme.Primary

const val muslimBdLink = "https://play.google.com/store/apps/details?id=com.muslimbd.muslimbd&hl=en"
const val holyTuneLink =
    "https://play.google.com/store/apps/details?id=com.v4technologiesbd.holy_tune"
const val alQuranLink = "https://play.google.com/store/apps/details?id=com.muslimbd.al_quran"
const val duaLink = "https://play.google.com/store/apps/details?id=com.muslimbd.dua"

@Composable
fun PlayStore() {

    val uriHandler = LocalUriHandler.current

    Column {
        Row(
            Modifier
                .clickable { uriHandler.openUri(muslimBdLink) }
                .background(Color.White, RoundedCornerShape(15)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.muslim_bd_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
            )
            Text(
                text = stringResource(id = R.string.play_store_text_muslim_bd),
                color = Gray,
                fontSize = 13.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.play_store_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(15))
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            PlayStoreItem(
                image = R.drawable.al_quran,
                name = stringResource(id = R.string.al_quran_bn),
                onTap = { uriHandler.openUri(alQuranLink) }
            )
            PlayStoreItem(
                image = R.drawable.dua,
                name = stringResource(id = R.string.dua_bn),
                onTap = { uriHandler.openUri(duaLink) }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            Modifier
                .clickable { uriHandler.openUri(holyTuneLink) }
                .background(Primary, RoundedCornerShape(15)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.holy_tune_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(15))
            )
            Text(
                text = stringResource(id = R.string.play_store_text_holy_tune),
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.play_store_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(15))
            )
        }
    }
}

@Composable
fun PlayStoreItem(image: Int, name: String, onTap: () -> Unit) {

    Box(contentAlignment = Alignment.BottomEnd) {
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(80.dp)
                .clickable {
                    onTap()
                }
                .shadow(10.dp, spotColor = Primary, shape = RoundedCornerShape(10.dp)),
        )

        Column(
            modifier = Modifier
                .height(60.dp)
                .width(90.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = image), contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = name, fontSize = 14.sp, fontWeight = FontWeight.W600,
                color = Primary
            )
        }
    }

}