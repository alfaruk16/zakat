package com.muslimbd.zakat.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.muslimbd.zakat.R
import com.muslimbd.zakat.core.theme.BackGroundDark
import com.muslimbd.zakat.core.theme.Gray
import com.muslimbd.zakat.core.theme.Primary
import com.muslimbd.zakat.core.util.AppConstants


data class ActionItem(val icon: ImageVector? = null, val image: Int? = null, val action: () -> Unit)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    titleColor: Color = Gray,
    icon: Int? = null,
    image: String? = null,
    navController: NavController,
    actions: List<ActionItem> = listOf(),
    onBackPressed: (() -> Unit)? = null,
    isBack: Boolean = true,
    openDrawer: (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    isMiddle: Boolean = false,
    navToDonate: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Primary,
        shadowElevation = 5.dp,
        content =
        {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Primary),
                title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        if (title != AppConstants.zakat)
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 10.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.donate_small),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .border(1.dp, Color.Black, shape = CircleShape)
                                        .padding(8.dp).clickable {
                                            navToDonate()
                                        }
                                )
                            }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {

                            if (isBack)
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowBackIos,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(start = 5.dp)
                                        .clickable {
                                            navController.navigateUp()
                                            if (onBackPressed != null) {
                                                onBackPressed()
                                            }
                                        },
                                    tint = Color.White
                                )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ) {
                                    navController.navigateUp()
                                    if (onBackPressed != null) {
                                        onBackPressed()
                                    } else if (openDrawer != null) {
                                        openDrawer()
                                    }
                                }

                            ) {
                                if (icon != null) {
                                    Icon(
                                        painter = painterResource(id = icon),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(end = 8.dp)
                                            .fillMaxHeight()
                                            .size(24.dp),
                                        tint = Color.White
                                    )
                                } else if (image != null) {
                                    AsyncImage(
                                        model = image, contentDescription = null,
                                        modifier = Modifier
                                            .height(24.dp)
                                            .width(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                }

                                if (title == stringResource(id = R.string.app_name))
                                    AppName()

                                if (title != stringResource(id = R.string.app_name))
                                    Text(
                                        text = title,
                                        color = Color.White,
                                        fontWeight = FontWeight.W700,
                                        fontSize = 18.sp
                                    )
                            }

                            if (!isMiddle)
                                Spacer(modifier = Modifier.weight(1f))

                            for (item in actions) {
                                Box(modifier = Modifier.padding(horizontal = 5.dp)) {
                                    Box(
                                        modifier = Modifier
                                            .background(
                                                color = BackGroundDark,
                                                shape = CircleShape
                                            )
                                            .size(28.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (item.icon != null)
                                            Icon(
                                                item.icon, contentDescription = null,
                                                modifier = Modifier
                                                    .clickable {
                                                        item.action()
                                                    }
                                                    .padding(2.dp), tint = Color.White
                                            )
                                        else if (item.image != null) {
                                            Image(painter = painterResource(id = item.image),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .clickable {
                                                        item.action()
                                                    }
                                                    .padding(3.dp)
                                            )

                                        }
                                    }
                                }
                            }
                            if (suffix != null) {
                                Spacer(modifier = Modifier.width(10.dp))
                                suffix()
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        })
}