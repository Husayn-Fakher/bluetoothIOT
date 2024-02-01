package com.example.bluetoothapp.compose

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.bluetoothapp.R
import com.example.bluetoothapp.bluetooth.ConnectGATT
import kotlinx.coroutines.launch


enum class AppPage(
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int
) {
    DEVICES(R.string.devices_title, R.drawable.baseline_devices_other_24),
    BLUETOOTH(R.string.bluetooth, R.drawable.baseline_bluetooth_24)
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    pages: Array<AppPage> = AppPage.values()
) {
    val pagerState = rememberPagerState(pageCount = { pages.size })

    HomePagerScreen(
        pagerState = pagerState,
        pages = pages,
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePagerScreen(
    pagerState: PagerState,
    pages: Array<AppPage>,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        val coroutineScope = rememberCoroutineScope()

        // Tab Row
        TabRow(
            selectedTabIndex = pagerState.currentPage
        ) {
            pages.forEachIndexed { index, page ->
                val title = stringResource(id = page.titleResId)
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    text = { Text(text = title) },
                    icon = {
                        Icon(
                            painter = painterResource(id = page.drawableResId),
                            contentDescription = title
                        )
                    },
                    unselectedContentColor = MaterialTheme.colorScheme.secondary
                )
            }
        }

        // Pages
        HorizontalPager(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .testTag("horizontalPagerTag"),
            state = pagerState,
            verticalAlignment = Alignment.Top,

            ) { index ->
            when (pages[index]) {

                AppPage.DEVICES -> {
                    DevicesScreen()
                }

                AppPage.BLUETOOTH -> {
                    ConnectGATT()
                }
            }
        }
    }
}

