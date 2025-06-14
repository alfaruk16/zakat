package com.muslimbd.zakat.features.presentation.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.muslimbd.zakat.R
import com.muslimbd.zakat.core.components.AppBar
import com.muslimbd.zakat.core.components.ExitDialogue
import com.muslimbd.zakat.core.components.Loader
import com.muslimbd.zakat.core.components.NoInternet
import com.muslimbd.zakat.core.theme.BackGroundColor
import com.muslimbd.zakat.core.theme.Primary
import com.muslimbd.zakat.core.util.AppConstants
import com.muslimbd.zakat.core.util.isOnline
import com.muslimbd.zakat.features.data.remote.model.TextContentDtoItem
import com.muslimbd.zakat.features.presentation.home.components.ContentDialogue
import com.muslimbd.zakat.features.presentation.home.components.ContentItem
import com.muslimbd.zakat.features.presentation.home.components.PlayStore

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    navToContent: (TextContentDtoItem) -> Unit,
    navController: NavController,
    scrollState: LazyGridState = rememberLazyGridState(),
    navToZakatCalculator: () -> Unit,
    navToDonate: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            AppBar(
                title = AppConstants.zakat,
                navController = navController,
                icon = R.drawable.zakat,
                isBack = false,
                isMiddle = true,
                navToDonate = {}
            )
        }
    ) { paddingValues ->

        val state by viewModel.state.collectAsStateWithLifecycle()
        val width = (LocalConfiguration.current.screenWidthDp).dp
        val context = LocalContext.current
        val activity = context as Activity

        val isExit = remember {
            mutableStateOf(false)
        }

        BackHandler {
            isExit.value = true
        }

        if (isExit.value)
            ExitDialogue(activity) {
                isExit.value = false
            }

        if (!state.currentContent.id.isNullOrEmpty())
            ContentDialogue(
                content = state.currentContent,
                textFontSize = state.textFontSize,
                arabicFontSize = state.arabicFontSize,
                increase = viewModel::increase,
                decrease = viewModel::decrease
            ) {
                viewModel.closeContentDialogue()
            }


        if (!isOnline(context) && state.categoryContents.data.isNullOrEmpty())
            Box(modifier = Modifier.padding(paddingValues)) {
                NoInternet {
                    if (isOnline(context)) {
                        viewModel.init()
                    }
                }
            }
        else
            Column {

                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .background(color = BackGroundColor)
                        .weight(1f),
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.home_image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp),
                        contentScale = ContentScale.FillWidth,
                    )

                    if (state.isLoading)
                        Loader(PaddingValues())
                    else
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2), state = scrollState,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp)
                        ) {

                            item(span = { GridItemSpan(2) }) { Spacer(modifier = Modifier.height((width / 3 * 2))) }

                            if (state.categoryContents.data != null)
                                items(count = state.categoryContents.data?.size ?: 0,
                                    itemContent = { index ->
                                        ContentItem(
                                            categoryItem = state.categoryContents.data?.get(index),
                                            viewModel::itemSelected,
                                            state.currentContent
                                        )

                                    })

                            item(span = { GridItemSpan(2) }) {
                                Card(
                                    Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            navToZakatCalculator()
                                        },
                                    shape = RoundedCornerShape(8.dp),
                                    colors = CardDefaults.cardColors(containerColor = Primary),
                                    elevation = CardDefaults.cardElevation(2.dp)
                                ) {
                                    Row(
                                        Modifier
                                            .padding(15.dp)
                                            .fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.zakat_calculator),
                                            contentDescription = null,
                                            modifier = Modifier.size(100.dp)
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Text(
                                            text = stringResource(id = R.string.zakat_calculator),
                                            fontSize = 24.sp,
                                            color = Color.White,
                                            maxLines = 1
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))

                                    }
                                }

                            }
                            item(span = { GridItemSpan(2) }) {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Row(
                                        Modifier
                                            .padding(15.dp)
                                            .clickable { navToDonate() },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = stringResource(id = R.string.donation),
                                            color = Color.White,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.W500
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Image(
                                            painter = painterResource(id = R.drawable.donate),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(45.dp)
                                                .border(1.dp, Color.Black, shape = CircleShape)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                            }
                            item(span = { GridItemSpan(2) }) {
                                PlayStore()
                            }
                            item(span = { GridItemSpan(2) }) {
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                }
            }
    }
}
