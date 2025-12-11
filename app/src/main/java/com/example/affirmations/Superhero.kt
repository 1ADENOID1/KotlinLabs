package com.example.affirmations

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.affirmations.data.Datasource
import com.example.affirmations.ui.theme.SuperheroesTheme

class Heroes (val nameRes: Int, val descriptionRes: Int, val imageRes: Int) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Superheroes",
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier
    )
}

@Composable
fun Hero(nameRes: Int, descriptionRes: Int, imageRes: Int, modifier: Modifier = Modifier) {
    Card(modifier = modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Image(
                painter = painterResource(imageRes),
                contentDescription = stringResource(nameRes),
                modifier = Modifier
                    .height(72.dp)
                    .width(72.dp)
                    .padding(16.dp),
                contentScale = ContentScale.Crop

            )
        }
    }
}

@Composable
fun HeroList(modifier: Modifier = Modifier) {
    val heroes = listOf(
        Heroes(
            nameRes = R.string.course1,
            descriptionRes = R.string.affirmation1,
            imageRes = R.drawable.image1
        ),
        Heroes(
            nameRes = R.string.course2,
            descriptionRes = R.string.affirmation2,
            imageRes = R.drawable.image2
        ),
        Heroes(
            nameRes = R.string.course3,
            descriptionRes = R.string.affirmation3,
            imageRes = R.drawable.image3
        ),
        Heroes(
            nameRes = R.string.course4,
            descriptionRes = R.string.affirmation4,
            imageRes = R.drawable.image4
        ),
        Heroes(
            nameRes = R.string.course5,
            descriptionRes = R.string.affirmation5,
            imageRes = R.drawable.image5
        ),
        Heroes(
            nameRes = R.string.course6,
            descriptionRes = R.string.affirmation6,
            imageRes = R.drawable.image6
        )
    )

    Column {
        Spacer(Modifier.height(70.dp))
        LazyColumn(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),


            ) {
            items(heroes) { hero ->
                Hero(
                    nameRes = hero.nameRes,
                    descriptionRes = hero.descriptionRes,
                    imageRes = hero.imageRes
                )
            }
        }
    }
}

@Composable
fun HeroApp() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ) {
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
            HeroList()

        }
    }
}