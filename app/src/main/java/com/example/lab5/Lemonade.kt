package com.example.lab5

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun lemonadeApp(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Lemonade")
                }
            )
        }
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var state by remember { mutableStateOf(1) }
            val picNumber = when (state) {
                1 -> R.drawable.lemon_tree
                2 -> R.drawable.lemon_squeeze
                3 -> R.drawable.lemon_drink
                else -> R.drawable.lemon_restart
            }
            val textNumber = when (state) {
                1 -> R.string.lemonState1
                2 -> R.string.lemonState2
                3 -> R.string.lemonState3
                else -> R.string.lemonState4
            }


            Button(onClick = { state = if (state < 4) ++state else 1; println(state) }) {
                Image(
                    painter = painterResource(picNumber),
                    contentDescription = null
                )

            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                stringResource(textNumber)
            )
        }

    }


}