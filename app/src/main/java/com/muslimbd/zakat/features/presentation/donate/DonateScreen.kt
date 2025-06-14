package com.muslimbd.zakat.features.presentation.donate

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.muslimbd.zakat.R
import com.muslimbd.zakat.core.components.TextFieldK
import com.muslimbd.zakat.core.theme.BackGroundColor
import com.muslimbd.zakat.core.theme.Primary
import com.muslimbd.zakat.features.data.remote.model.CategoryDtoItem
import com.muslimbd.zakat.features.presentation.donate.components.AmountItem
import com.muslimbd.zakat.features.presentation.donate.components.DonateButton

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun DonateScreen(
    modifier: Modifier = Modifier,
    viewModel: DonateViewModel = hiltViewModel(),
    category: CategoryDtoItem? = null,
    navController: NavController,
    scrollState: LazyGridState = rememberLazyGridState(),
    navToSSL: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val mobileFocusRequester = FocusRequester()
    val width = LocalConfiguration.current.screenWidthDp.dp

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackGroundColor)
        ) {


            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2), state = scrollState,
                    modifier = Modifier.weight(1f)
                ) {

                    item(span = { GridItemSpan(2) }) {
                        Box {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 40.dp)
                                    .padding(top = 40.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = stringResource(id = R.string.rahmat),
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.W500, color = Color.Black,
                                    modifier = Modifier.weight(1f)
                                )
                                Spacer(modifier = Modifier.width(20.dp))
                                Image(
                                    painter = painterResource(id = R.drawable.donate),
                                    contentDescription = null,
                                    modifier = Modifier.size(width / 3)
                                )
                            }

                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBackIos, contentDescription = null,
                                modifier = Modifier
                                    .padding(20.dp)
                                    .clickable {
                                        navController.navigateUp()
                                    }, tint = Color.White
                            )
                        }
                    }

                    item(span = { GridItemSpan(2) }) {
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    item(span = { GridItemSpan(2) }) {
                        Divider(
                            modifier = Modifier.padding(horizontal = 32.dp, vertical = 20.dp),
                            color = Primary
                        )
                    }

                    item(span = { GridItemSpan(2) }) {
                        Text(
                            text = stringResource(id = R.string.select_any_amount),
                            color = Color.Black,
                            modifier = Modifier.padding(start = 32.dp)
                        )
                    }
                    items(state.amounts.size) {
                        AmountItem(
                            amount = state.amounts[it], state.amount,
                            state.colors[it % state.colors.size]
                        ) { amount ->
                            viewModel.donateChanged(amount)
                        }
                    }

                    item(span = { GridItemSpan(2) }) {
                        Text(
                            text = stringResource(id = R.string.amount) + stringResource(id = R.string.other_amount),
                            modifier = Modifier.padding(start = 32.dp, top = 20.dp),
                            color = Color.Black
                        )
                    }
                    item(span = { GridItemSpan(2) }) {
                        TextFieldK(
                            value = state.amount,
                            label = R.string.amount,
                            focusRequester = mobileFocusRequester,
                            onValueChange = { viewModel.amountChange(it) },
                            keyboardType = KeyboardType.Number,
                            leadingIcon = {
                                Row(
                                    modifier = Modifier.padding(start = 15.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painterResource(id = R.drawable.taka),
                                        contentDescription = null,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(10.dp))
                                }
                            },
                            suffixIcon = {
                                Icon(
                                    Icons.Default.CheckCircle, contentDescription = null,
                                    tint = if (state.amount.isNotEmpty()) Primary else Color.Red,
                                    modifier = Modifier.padding(horizontal = 10.dp)
                                )
                            },
                            error = if (state.isValidate && state.amount.isEmpty()
                            ) stringResource(
                                id = R.string.enter_amout
                            ) else "",
                            modifier = Modifier.padding(horizontal = 30.dp),
                            height = 40.dp
                        )
                    }
                    item { Spacer(modifier = Modifier.height(20.dp)) }
                }

                DonateButton(state.amount, state.isLoading) {
                    viewModel.signUp(navToSSL)
                }

                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}
