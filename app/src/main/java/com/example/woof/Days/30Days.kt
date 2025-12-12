package com.example.woof.Days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.woof.data.DaysDatasource
import com.example.woof.model.Day
import com.example.woof.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SuperheroesTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //HeroApp()
                    dayApp()
                }
            }

        }
    }
}

@Composable
fun DayCard(day: Day, daynum: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)

    ) {
        Column(
            modifier = Modifier


        ) {
            Text(
                text = "Day $daynum",
                style = MaterialTheme.typography.bodySmall,
                        modifier = modifier
                        .padding(8.dp)
            )
            Text(
                text = stringResource(day.TitleId),
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier
                    .padding(start = 8.dp, bottom = 8.dp)
            )
            Image(
                painter = painterResource(day.PictureId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Text(
                text = stringResource(day.TextId),
                style = MaterialTheme.typography.bodySmall,
                modifier = modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun dayList(daylist: List<Day>, modifier: Modifier = Modifier) {
    var dayNum = 1
    LazyColumn(modifier = modifier) {
        items(daylist) { day ->
            DayCard(day, dayNum)
            ++dayNum
        }
    }
}

@Composable
fun dayApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection)
            )

    ) {

            dayList(DaysDatasource().getDays())

    }
}