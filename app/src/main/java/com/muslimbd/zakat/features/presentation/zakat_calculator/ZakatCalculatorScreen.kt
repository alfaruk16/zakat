package com.muslimbd.zakat.features.presentation.zakat_calculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.muslimbd.zakat.core.components.AppBar
import com.muslimbd.zakat.core.components.TextFieldK
import com.muslimbd.zakat.core.theme.BackGroundColor
import com.muslimbd.zakat.core.theme.Gray
import com.muslimbd.zakat.core.theme.Primary
import com.muslimbd.zakat.features.presentation.zakat_calculator.components.ZakatDialogue

@Composable
fun ZakatCalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: ZakatCalculatorViewModel = hiltViewModel(),
    navController: NavController,
    navToDonate: () -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            AppBar(
                title = stringResource(id = R.string.zakat_calculator),
                navController = navController,
                icon = R.drawable.zakat,
                isMiddle = true,
                navToDonate = navToDonate
            )
        }
    ) { paddingValues ->

        val width = (LocalConfiguration.current.screenWidthDp / 1.75).dp

        if (state.zakat.isNotEmpty())
            ZakatDialogue(total = state.total, zakat = state.zakat) {
                viewModel.closeZakatDialogu()
            }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(BackGroundColor)
        ) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.zakat_banner),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                }

                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
                    Text(
                        text = stringResource(id = R.string.chandra_bosore),
                        color = Gray, fontSize = 16.sp
                    )
                    Label(label = "নগদ টাকা")
                    Item(
                        text = "নগদ টাকা",
                        value = state.nagadTaka,
                        onValueChange = viewModel::nagadTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "ব্যাংক অ্যাকাউন্টে নগদ টাকা",
                        value = state.bankTaka,
                        onValueChange = viewModel::bangkTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Label(label = "স্বর্ণের সমতুল্য টাকার পরিমান")
                    Item(
                        text = "স্বর্ণ",
                        value = state.shornoTaka,
                        onValueChange = viewModel::shornoTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "রুপা",
                        value = state.rupaTaka,
                        onValueChange = viewModel::rupaTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Label(label = "বিনিয়োগ")
                    Item(
                        text = "শেয়ার বাজার",
                        value = state.shareBazarTaka,
                        onValueChange = viewModel::shareBazarTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "অন্যান্য বিনিয়োগ",
                        value = state.onnanoBiniog,
                        onValueChange = viewModel::onnannoBiniogTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Label(label = "সম্পত্তি")
                    Item(
                        text = "বাসা ভাড়া",
                        value = state.bashaVara,
                        onValueChange = viewModel::bashaVaraTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "সম্পত্তি",
                        value = state.shompotti,
                        onValueChange = viewModel::shommottiTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Label(label = "ব্যবসা")
                    Item(
                        text = "নগদ ব্যবসা",
                        value = state.nagadBabsha,
                        onValueChange = viewModel::nagadBabshaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "পণ্য",
                        value = state.ponno,
                        onValueChange = viewModel::ponnoTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Label(label = "অন্যান্য")
                    Item(
                        text = "পেনশন",
                        value = state.pension,
                        onValueChange = viewModel::pensionTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "পারিবারিক ঋণ এবং অন্যান্য",
                        value = state.paribarikRin,
                        onValueChange = viewModel::paribarikTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "অন্যান্য মূলধন",
                        value = state.onnannoMuldhon,
                        onValueChange = viewModel::onnannoMuldhonTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Label(label = "কৃষিকাজ")
                    Item(
                        text = "টাকার পরিমান",
                        value = state.krishiTaka,
                        onValueChange = viewModel::krishiTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Label(label = "দায়", color = Color.Red)
                    Item(
                        text = "ক্রেডিট কার্ড পেমেন্ট",
                        value = state.creditCard,
                        onValueChange = viewModel::creditTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "গাড়ির পেমেন্ট",
                        value = state.gariPayment,
                        onValueChange = viewModel::gariPaymentTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "ব্যবসার পেমেন্ট",
                        value = state.babshaPayment,
                        onValueChange = viewModel::babshaPaymentTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "ফ্যামিলি ঋণ",
                        value = state.familyRin,
                        onValueChange = viewModel::familyRinTakaChange,
                        focusRequester = FocusRequester()
                    )
                    Item(
                        text = "অন্যান্য ঋণ",
                        value = state.onnanoRin,
                        onValueChange = viewModel::onnanoRinTakaChange,
                        focusRequester = FocusRequester()
                    )

                    Box(
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .background(color = Primary, shape = RoundedCornerShape(8.dp))
                            .fillMaxWidth()
                            .clickable {
                                viewModel.calculateZakat()
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.hishab_korun),
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W500,
                            modifier = Modifier.padding(vertical = 12.dp)
                        )
                    }

                }

            }
        }
    }

}

@Composable
private fun Label(label: String, color: Color = Gray) {
    Text(
        text = label, fontSize = 18.sp, fontWeight = FontWeight.W600,
        color = color,
        modifier = Modifier.padding(top = 15.dp, bottom = 2.dp, start = 5.dp)
    )
}

@Composable
private fun Item(
    text: String,
    value: String,
    onValueChange: (String) -> Unit,
    focusRequester: FocusRequester
) {
    val width = (LocalConfiguration.current.screenWidthDp).dp

    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 15.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text, modifier = Modifier.width(width / 3))
        Spacer(modifier = Modifier.width(10.dp))
        TextFieldK(
            value = value,
            label = R.string.empty,
            onValueChange = onValueChange,
            leadingIcon = {
                Text(
                    text = "৳",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W600,
                    color = Primary
                )
            },
            focusRequester = focusRequester,
            height = 40.dp,
            keyboardType = KeyboardType.Number
        )
    }

}
